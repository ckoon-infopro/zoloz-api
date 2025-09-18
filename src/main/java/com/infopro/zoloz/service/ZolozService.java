package com.infopro.zoloz.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zoloz.api.sdk.client.OpenApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.infopro.zoloz.dto.request.InitRequestDto;
import com.infopro.zoloz.dto.response.InitResponseDto;
import com.infopro.zoloz.constants.*;
import com.infopro.zoloz.dto.request.RealIdCheckRequestDto;
import com.infopro.zoloz.dto.response.RealIdCheckResponseDto;

import java.lang.reflect.Type;
import java.util.Map;

@Service
public class ZolozService {

    private static final String API_REALID_INITIALIZE = "v1.zoloz.realid.initialize";
    private static final String API_REALID_CHECKRESULT = "v1.zoloz.realid.checkresult";
    private static final String DUMMY_BIZID_PREFIX = "dummy_bizid_";
    private static final String DUMMY_USERID_PREFIX = "dummy_userid_";
    private static final String FLOW_TYPE_REALIDLITE_KYC = "REALIDLITE_KYC";

    private final OpenApiClient openApiClient;
    private final Gson gson = new Gson();

    @Value("${zoloz.default.service-level}")
    private String defaultServiceLevel;

    @Value("${zoloz.default.doc-type}")
    private String defaultDocType;

    @Autowired
    public ZolozService(OpenApiClient openApiClient) {
        this.openApiClient = openApiClient;
    }

    public InitResponseDto realIdInitSvc(InitRequestDto requestDto) throws Exception {
        if (null == requestDto.getBizId())
            requestDto.setBizId(DUMMY_BIZID_PREFIX + System.currentTimeMillis());

        if (null == requestDto.getUserId())
            requestDto.setUserId(DUMMY_USERID_PREFIX + System.currentTimeMillis());

        if (null == requestDto.getServiceLevel())
            requestDto.setServiceLevel(defaultServiceLevel);

        if (null == requestDto.getDocType())
            requestDto.setDocType(defaultDocType);

        requestDto.setFlowType(FLOW_TYPE_REALIDLITE_KYC);

        String responseStr = openApiClient.callOpenApi(
                API_REALID_INITIALIZE,
                gson.toJson(requestDto)
        );

        return gson.fromJson(responseStr, InitResponseDto.class);
    }

    public RealIdCheckResponseDto realIdCheckSvc(RealIdCheckRequestDto request) {
        String apiRespStr = openApiClient.callOpenApi(
                API_REALID_CHECKRESULT,
                gson.toJson(request)
        );

        Type type = new TypeToken<Map<String, Object>>(){}.getType();
        Map<String, Object> apiResp = gson.fromJson(apiRespStr, type);

        return new RealIdCheckResponseDto(apiResp);
    }
}
