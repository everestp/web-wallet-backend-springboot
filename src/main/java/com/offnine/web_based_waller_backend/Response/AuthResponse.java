package com.offnine.web_based_waller_backend.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter

@AllArgsConstructor
public class AuthResponse {
    private String phone;
    private String token;
}
