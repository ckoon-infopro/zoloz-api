package com.infopro.zoloz.dto.request;

public class RealIdCheckRequestDto {

    private String bizId;
    private String transactionId;
    private String isReturnImage;

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getIsReturnImage() {
        return isReturnImage;
    }

    public void setIsReturnImage(String isReturnImage) {
        this.isReturnImage = isReturnImage;
    }
}
