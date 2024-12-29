package com.gerolamo.authflow.controller;

import com.gerolamo.authflow.model.Usuario;
import com.gerolamo.authflow.model.dto.AuthRequestDTO;
import com.gerolamo.authflow.model.dto.TokenResponseDTO;
import com.gerolamo.authflow.repository.UserRepository;
import com.gerolamo.authflow.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, World!";
    }

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<TokenResponseDTO> login(@RequestBody AuthRequestDTO authRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword())
            );

            String token = jwtUtil.generateToken(authRequest.getEmail());
            Date expiration = jwtUtil.getExpirationDate();

            TokenResponseDTO response = new TokenResponseDTO(
                    token,
                    "Bearer",
                    expiration
            );

            return ResponseEntity.ok(response);
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }


    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Usuario user) {

        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        user.setRole("ROLE_USER");
        userRepository.save(user);
        return ResponseEntity.ok("Usuário registrado com sucesso!");
    }
}
