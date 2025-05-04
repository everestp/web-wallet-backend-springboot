package com.offnine.web_based_waller_backend.Controller;

import com.offnine.web_based_waller_backend.Request.AuthRequest;
import com.offnine.web_based_waller_backend.Response.AuthResponse;
import com.offnine.web_based_waller_backend.service.impl.AppUserDetailsService;
import com.offnine.web_based_waller_backend.utils.JwtUtil;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
@AllArgsConstructor



public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final AppUserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;
    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getPhone(), request.getPassword()));
        final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getPhone());
        final String jwtToken = jwtUtil.generateToken(userDetails);
        return  new AuthResponse(request.getPhone(), jwtToken);

    }



}
