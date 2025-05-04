package com.offnine.web_based_waller_backend.Repo;


import com.offnine.web_based_waller_backend.entites.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends MongoRepository<UserEntity, String> {
    Optional<UserEntity> findByPhone(String phone);

}
