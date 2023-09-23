package com.train.reservation.reservation.controllers;

import com.train.reservation.reservation.model.AuthRequest;
import com.train.reservation.reservation.model.AuthResponseResponse;
import com.train.reservation.reservation.model.RegisterRequest;
import com.train.reservation.reservation.model.RegisterResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class AuthenticationController {
    public static final String url = "http://20.244.56.144/train/register";
    public static final String urlAuth = "http://20.244.56.144/train/auth";

    @PostMapping(path ="/register",consumes = "application/json", produces = "application/json")
    public RegisterResponse register(@RequestBody RegisterRequest registerRequest){
        RestTemplate restTemplate = new RestTemplate();
        RegisterResponse response= restTemplate.postForObject(url,registerRequest, RegisterResponse.class);
        return response;
    }

    public AuthResponseResponse getToken( AuthRequest authRequest){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<AuthResponseResponse> response= restTemplate.postForEntity(urlAuth,authRequest, AuthResponseResponse.class);
        return response.getBody();
    }

}
