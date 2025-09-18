package com.infopro.zoloz.config;

import com.zoloz.api.sdk.client.OpenApiClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZolozConfig {

    @Value("${zoloz.api.host_url}")
    private String hostUrl;

    @Value("${zoloz.api.client_id}")
    private String clientId;

    @Value("${zoloz.api.zoloz_public_key}")
    private String zolozPublicKey;

    @Value("${zoloz.api.merchant_private_key}")
    private String merchantPrivateKey;

    @Bean
    public OpenApiClient openApiClient() {
        OpenApiClient client = new OpenApiClient();
        client.setHostUrl(hostUrl);
        client.setClientId(clientId);
        client.setMerchantPrivateKey(merchantPrivateKey);
        client.setOpenApiPublicKey(zolozPublicKey);
        return client;
    }
}
