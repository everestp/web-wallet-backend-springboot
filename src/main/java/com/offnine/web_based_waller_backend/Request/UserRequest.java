package com.offnine.web_based_waller_backend.Request;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter
@Data
@Builder
public class UserRequest {
    private String name;
    private String phone;
    private String password;
    private  String privateKey;
    private String seedPhrase;
    private String publicKey;



}
