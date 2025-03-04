package com.cupom.infrastructure.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;

@Configuration
public class S3Config {
   public Dotenv dotenv;

   public S3Config(Dotenv dotenv){
       this.dotenv = dotenv;
   }
    public AWSCredentials credentials() {
        AWSCredentials credentials = new BasicAWSCredentials(
                Objects.requireNonNull(dotenv.get("AWS_ACESS_KEY")),
                Objects.requireNonNull(dotenv.get("AWS_SECRET_KEY"))
        );
        return credentials;
    }

    @Bean
    public AmazonS3 amazonS3() {
        AmazonS3 s3client = AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials()))
                .withRegion(Regions.US_EAST_1)
                .build();

        return s3client;

    }


}