package com.infopro.zoloz.dto.response;

import com.infopro.tpint.zoloz.dto.ResultDto;

public class InitResponseDto {
    private String transactionId;
    private String clientCfg;
    private ResultDto result;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getClientCfg() {
        return clientCfg;
    }

    public void setClientCfg(String clientCfg) {
        this.clientCfg = clientCfg;
    }

    public ResultDto getResult() {
        return result;
    }

    public void setResult(ResultDto result) {
        this.result = result;
    }
}
