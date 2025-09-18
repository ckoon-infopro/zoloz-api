package com.infopro.zoloz.dto.response;

import java.util.Map;

public class RealIdCheckResponseDto {

    private Map<String, Object> result;

    public RealIdCheckResponseDto(Map<String, Object> result) {
        this.result = result;
    }

    public Map<String, Object> getResult() {
        return result;
    }

    public void setResult(Map<String, Object> result) {
        this.result = result;
    }
}
