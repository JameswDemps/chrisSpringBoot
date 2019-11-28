package com.nationwide.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nationwide.persistence.domain.Token;

public interface TokenRepository extends JpaRepository<Token, Long>{
	
	/**
	 * Query database for given parameter
	 * @param username - of type String.
	 * @return an optional {@link Token} found using the username
	 */
	public Optional<Token> findByUsername(String username);
	
	/**
	 * Query database for given parameter
	 * @param bearerToken - of type String.
	 * @return an optional {@link Token} found using the bearerToken
	 */
	public Optional<Token> findByBearerToken(String bearerToken);

}
