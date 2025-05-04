package com.offnine.web_based_waller_backend.Controller;

import com.offnine.web_based_waller_backend.Request.UserRequest;
import com.offnine.web_based_waller_backend.Response.UserResponse;
import com.offnine.web_based_waller_backend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api")

public class UserController {
    private  final UserService userService;

    @PostMapping("/register")

    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse register(@RequestBody UserRequest userRequest) {
        return  userService.registerUser(userRequest);


    }


}
