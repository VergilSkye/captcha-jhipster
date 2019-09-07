package com.mycompany.myapp.service;

import com.mycompany.myapp.config.ApplicationProperties;
import com.mycompany.myapp.service.RecaptchaResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.net.URI;

@Service
public class CaptchaService {

    private final RestTemplate restTemplate;
    private final ApplicationProperties applicationProperties;
    public String recaptchaSecret;
    public String recaptchaVerifyUrl;


    public CaptchaService(RestTemplateBuilder restTemplateBuilder, ApplicationProperties applicationProperties) {
        this.restTemplate = restTemplateBuilder.build();
        this.applicationProperties = applicationProperties;
    }
    @PostConstruct
    public void init(){
        this.recaptchaSecret = this.applicationProperties.getRecaptcha().getSecret();
        this.recaptchaVerifyUrl = this.applicationProperties.getRecaptcha().getSecret();
    }

    public boolean verify(String response) {
        MultiValueMap param= new LinkedMultiValueMap<>();
        param.add("secret", recaptchaSecret);
        param.add("response", response);

        final URI verifyUri = URI.create(String.format("https://www.google.com/recaptcha/api/siteverify?secret=%s&response=%s", recaptchaSecret, response));

        RecaptchaResponse recaptchaResponse = null;
        try {
            recaptchaResponse = this.restTemplate.getForObject(verifyUri, RecaptchaResponse.class);
            System.out.println(recaptchaResponse.toString());
        }catch(RestClientException e){
            System.out.print(e.getMessage() + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        }
        try{
            if(recaptchaResponse.isSuccess()){
                return true;
            }else {
                return false;
            }
        }catch (Exception e) {
            System.out.println(e + " FFFFFFFFFFFFFFFFFFFFFFFFF");
            return false;
        }

    }
}
