package com.example.functions.configuration;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import com.azure.storage.common.StorageSharedKeyCredential;

@Configuration
public class AzureBlobStorageConfig {

    private String accountName = "sttrainee7";

    private String accountKey = "HtcDeIJjyykMVAp9+m54FZU/B/O3IyHlU23ksOnXDnGGAxd3GqjqkOQL042jmKj6ad2HUI/X4vIF+AStx6DMGA==";

    @Bean
    public BlobServiceClient getBlobServiceClient() {
        return new BlobServiceClientBuilder()
                .endpoint(String.format(Locale.ROOT, "https://%s.blob.core.windows.net", accountName))
                .credential(new StorageSharedKeyCredential(accountName, accountKey))
                .buildClient();
    }
}
