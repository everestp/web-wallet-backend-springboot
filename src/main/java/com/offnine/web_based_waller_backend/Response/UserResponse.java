package com.offnine.web_based_waller_backend.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {
    private String id;
    private String name;
    private String phone;
    private  String privateKey;
    private String seedPhrase;
    private String publicKey;


}
