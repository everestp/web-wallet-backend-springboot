package com.offnine.web_based_waller_backend.service.impl;



import com.offnine.web_based_waller_backend.Repo.UserRepo;
import com.offnine.web_based_waller_backend.Request.UserRequest;
import com.offnine.web_based_waller_backend.Response.UserResponse;
import com.offnine.web_based_waller_backend.entites.UserEntity;
import com.offnine.web_based_waller_backend.service.AuthenticationFacade;
import com.offnine.web_based_waller_backend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private  final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationFacade authenticationFacade;
    @Override
    public UserResponse registerUser(UserRequest request) {
        UserEntity newUser = convertToUserEntity(request);
        newUser = userRepo.save(newUser);
        return convertToUserResponse(newUser);
    }

    @Override
    public String findByUserId() {
        String logggedInPhone = authenticationFacade.getAuthentication().getName();
        UserEntity loggedInUser =  userRepo.findByPhone(logggedInPhone).orElseThrow(()->new UsernameNotFoundException("User Not Found"));
        return  loggedInUser.getId();
    }

    private UserEntity convertToUserEntity(UserRequest userRequest) {
        return UserEntity.builder()
                .phone(userRequest.getPhone())
                .name(userRequest.getName())
                .seedPhrase(userRequest.getSeedPhrase())
                .privateKey(userRequest.getPrivateKey())
                .publicKey(userRequest.getPublicKey())
                .password(passwordEncoder.encode(userRequest.getPassword())).build();



    }

    private UserResponse convertToUserResponse(UserEntity registered) {
        return UserResponse.builder()
                .id(registered.getId())
                .name(registered.getName())
                .phone(registered.getPhone())
                .seedPhrase(registered.getSeedPhrase())
                .privateKey(registered.getPrivateKey())
                .publicKey(registered.getPublicKey())

                .build();
    }
}
