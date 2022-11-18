package com.example.serverReto1.user;

import com.example.serverReto1.security.JwtTokenUtil;
import com.example.serverReto1.song.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    AuthenticationManager authManager;
    @Autowired
    JwtTokenUtil jwtUtil;
    @PostMapping("/auth/signup")
    public ResponseEntity<?> createUser(@RequestBody @Valid User user) {

        int response = userService.signUp(user);

        if(response == 0) {
            return ResponseEntity.status(432).body("El usuario ya existe");
        }else if(response == 2){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }
    @PostMapping("/auth/login")
    public ResponseEntity<?> login(@RequestBody @Valid AuthRequest request) {
        try {
            Authentication authentication = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
            );

            System.out.println(authentication);

            User user = (User) authentication.getPrincipal();
            String accessToken = jwtUtil.generateAccessToken(user);
            AuthResponse response = new AuthResponse(user.getUsername(), accessToken);

            return ResponseEntity.ok().body(response);

        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
    @GetMapping("/loginNoToken")
    public ResponseEntity<?> loginNoToken(@RequestBody AuthRequest request){
        List<?> response = userService.logUser(request.getUsername(), request.getPassword());
        if(response.get(0).equals("-1")){
            return ResponseEntity.status(432).body("El usuario no existe");
        }else if(response.get(0).equals("-2")){
            return ResponseEntity.status(433).body("La contraseña es errónea");
        }else{
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
        }



    }

}
