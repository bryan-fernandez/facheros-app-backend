package com.bichcon.pe.app.controller;

import com.bichcon.pe.app.dto.LoginDTO;
import com.bichcon.pe.app.dto.TokenDTO;
import com.bichcon.pe.app.security.UserDetailService;
import com.bichcon.pe.app.security.jwt.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class AuthController {

    @Autowired
    private TokenUtil util;

    @Autowired
    private UserDetailService service;

    @Autowired
    private PasswordEncoder encoder;

    @RequestMapping(path = "/generarToken", method = RequestMethod.POST)
    public ResponseEntity<?> generarToken(@RequestBody LoginDTO loginDTO) {
        UserDetails user = service.loadUserByUsername(loginDTO.getUsername());

        if (encoder.matches(loginDTO.getPassword(), user.getPassword()))
            return new ResponseEntity<>(new TokenDTO("Bearer", util.generateToken(user.getUsername())), HttpStatus.OK);
        else throw new UsernameNotFoundException("Contrasenia invalida");
    }
}
