package com.offnine.web_based_waller_backend.service;

import com.offnine.web_based_waller_backend.Request.SendRequest;
import com.offnine.web_based_waller_backend.Request.UserRequest;
import com.offnine.web_based_waller_backend.Response.SendResponse;
import com.offnine.web_based_waller_backend.Response.UserResponse;

public interface UserService {
    UserResponse registerUser(UserRequest userRequest);
    String findByUserId();
    UserResponse logginUser();
    SendResponse sendTransaction(SendRequest sendRequest);
}
