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
import com.nationwide.mapping.MyMapping;
import com.nationwide.persistence.domain.Token;
import com.nationwide.service.TokenService;

@RestController
@CrossOrigin("*")
@RequestMapping("/token")
public class TokenController {
	
    @Autowired
    private TokenService tokenService;

    @Autowired
    private MyMapping myMapping;
    
    @PostMapping("/{username}")
    public ResponseTokenDto createToken(@PathVariable String username) {
    	Token token = tokenService.createToken(username);
    	return myMapping.map(token, ResponseTokenDto.class);
    }
    
    @GetMapping("/{bearerToken}")
    public ResponseTokenDto getTokenUserDetails(@PathVariable String bearerToken){
    	Token token =  tokenService.readByBearerToken(bearerToken);
    	ResponseTokenDto response = new ResponseTokenDto();
    	response.setUsername(token.getUsername());
    	response.setBearerToken(token.getBearerToken());
    	return response;
        
    }
    
    @PutMapping("/{bearerToken}")
    public ResponseTokenDto updateToken(@PathVariable String bearerToken) {
    	Token token =  tokenService.updateToken(bearerToken);
    	ResponseTokenDto response = new ResponseTokenDto();
    	response.setUsername(token.getUsername());
    	response.setBearerToken(token.getBearerToken());
    	return response;
    }
    
    @DeleteMapping("/{bearerToken}")
    public String deleteToken(@PathVariable String bearerToken) {
    	tokenService.deleteToken(bearerToken);
    	return "Token Deleted";
    }
}
