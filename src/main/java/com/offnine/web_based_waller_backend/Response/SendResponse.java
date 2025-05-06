package com.offnine.web_based_waller_backend.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SendResponse {
    private String name;
   private String publicKey;
   private  String remark;
   private String phone;
}
