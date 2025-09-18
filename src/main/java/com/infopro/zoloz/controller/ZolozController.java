package com.infopro.zoloz.controller;

import com.infopro.zoloz.dto.request.RealIdCheckRequestDto;
import com.infopro.zoloz.dto.response.RealIdCheckResponseDto;
import com.infopro.zoloz.service.ZolozService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.infopro.zoloz.dto.request.InitRequestDto;
import com.infopro.zoloz.dto.response.InitResponseDto;

@RestController
@RequestMapping("/api/zoloz")
public class ZolozController {

    private final ZolozService zolozService;

    public ZolozController(ZolozService zolozService) {
        this.zolozService = zolozService;
    }

    @PostMapping("/realid/initialize")
    public InitResponseDto realIdInit(@RequestBody InitRequestDto requestDto) throws Exception {
        return zolozService.realIdInitSvc(requestDto);
    }

    @PostMapping("/realid/checkresult")
    public RealIdCheckResponseDto realIdCheck(@RequestBody RealIdCheckRequestDto request) {
        return zolozService.realIdCheckSvc(request);
    }
}