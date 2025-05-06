package com.offnine.web_based_waller_backend.entites;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "nodes")
@Builder
public class UserEntity {

    @Id
    private String Id;
    private String name;
    private String password;
    @Column(nullable = false, unique = true)
    private String phone;
    private  String privateKey;
    private String seedPhrase;
    private String publicKey;
    private String address;



}
