package com.offnine.web_based_waller_backend.Controller;

import com.offnine.web_based_waller_backend.Repo.UserRepo;
import com.offnine.web_based_waller_backend.Request.SendRequest;
import com.offnine.web_based_waller_backend.Request.UserRequest;
import com.offnine.web_based_waller_backend.Response.SendResponse;
import com.offnine.web_based_waller_backend.Response.UserResponse;
import com.offnine.web_based_waller_backend.entites.UserEntity;
import com.offnine.web_based_waller_backend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api")

public class UserController {
    private  final UserService userService;
    private final UserRepo userRepo;

    @PostMapping("/register")

    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse register(@RequestBody UserRequest userRequest) {
        return  userService.registerUser(userRequest);


    }

    @PostMapping("/send")
    public SendResponse sendTransaction(@RequestBody SendRequest sendRequest) {
       return  userService.sendTransaction(sendRequest);

    }
    @GetMapping("/user")
public UserResponse getUser() {
      return   userService.logginUser();
    }
}
