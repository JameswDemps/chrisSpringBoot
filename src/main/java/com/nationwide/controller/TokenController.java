package com.nationwide.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nationwide.dto.ResponseTokenDto;
import com.nationwide.persistence.domain.Token;
import com.nationwide.service.TokenService;

@RestController
@CrossOrigin("*")
@RequestMapping("/token")
public class TokenController {
	
    @Autowired
    private TokenService tokenService;

    @PostMapping("/{username}")
    public ResponseTokenDto createToken(@PathVariable String username) {
    	Token token = tokenService.createToken(username);
    	ResponseTokenDto response = new ResponseTokenDto();
    	response.setUsername(token.getUsername());
    	response.setBearerToken(token.getBearerToken());
    	return response;
    }
    
    @GetMapping("/{bearerToken}")
    public Token getTokenUserDetails(@PathVariable String bearerToken){
        return tokenService.readByBearerToken(bearerToken);
    }
    
    @PutMapping("/{bearerToken}")
    public Token updateToken(@PathVariable String bearerToken) {
    	return tokenService.updateToken(bearerToken);
    }
    
    @DeleteMapping("/{bearerToken}")
    public String deleteToken(@PathVariable String bearerToken) {
    	tokenService.deleteToken(bearerToken);
    	return "Token Deleted";
    }
}
