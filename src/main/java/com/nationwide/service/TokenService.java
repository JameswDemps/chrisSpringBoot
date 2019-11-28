package com.nationwide.service;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nationwide.persistence.domain.Token;
import com.nationwide.persistence.repository.TokenRepository;

/**
 * A service that calls the {@link TokenRepository} to communicate with the database
 * @author Adam
 *
 */
@Service
public class TokenService {

	@Autowired
	private TokenRepository tokenRepository;
	
	/**
	 * returns an {@link Token} from the database using the parameter
	 * @param username - a String that contains the username from the database
	 * @return an optional {@link Token} found using the username
	 */
	public Token readByUsername(String username) {
		return tokenRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("username not found"));
	}
	
	/**
	 * returns an {@link Token} from the database using the parameter
	 * @param bearerToken - a String that contains the bearerToken from the database
	 * @return an optional {@link Token} found using the bearerToken
	 */
	public Token readByBearerToken(String bearerToken) {
		return tokenRepository.findByBearerToken(bearerToken).orElseThrow(() -> new RuntimeException("BearerToken not found"));
	}

	/**
	 * returns a random string for the token
	 * @return when account verified will a random 32 character {@link String}
	 */
	private String randomStringGenerator() {
		SecureRandom secureRandom = new SecureRandom(); //threadsafe
		Base64.Encoder base64Encoder = Base64.getUrlEncoder(); //threadsafe

		byte[] randomBytes = new byte[24];
		secureRandom.nextBytes(randomBytes);
		System.out.println(base64Encoder.encodeToString(randomBytes));
		return base64Encoder.encodeToString(randomBytes);
	}

	/**
	 * returns an {@link Token} that generates a random token, sets the random token and username to a Token object
	 * @param username - this is the username
	 * @return an {@link Token} that sets the random token with a username
	 */
	public Token createToken(String username) {
		Token token = new Token();
		token.setUsername(username);
		token.setBearerToken(randomStringGenerator());
		return tokenRepository.saveAndFlush(token);
	}

	/**
	 * After a preset time it will generate a new token and set this in the object {@link Token}
	 * @param bearerToken - a String that contains the bearerToken from the database
	 * @return updates token in {@link Token} give the bearerToken
	 */
	public Token updateToken(String bearerToken) {
		Token token = readByBearerToken(bearerToken);
		token.setBearerToken(randomStringGenerator());
		tokenRepository.flush();
		return token;
	}

	/**
	 * Deletes the token
	 * @param bearerToken - a String that contains the bearerToken from the database
	 */
	public void deleteToken(String bearerToken) {
		Token token = readByBearerToken(bearerToken);
		tokenRepository.delete(token);
	}

}
