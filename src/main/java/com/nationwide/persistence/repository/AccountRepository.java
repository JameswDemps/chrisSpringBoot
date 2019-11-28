package com.nationwide.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nationwide.persistence.domain.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{
	
	/**
	 * Query database for given parameter
	 * @param username - of type String.
	 * @return an optional {@link Account} found using the username
	 */
	public Optional<Account> findByUsername(String username);
	
	/**
	 * Query database for given parameter
	 * @param bearerToken - of type String.
	 * @return an optional {@link Account} found using the bearerToken
	 */
	public Optional<Account> findByBearerToken(String bearerToken);
	
	/**
	 * Query database for given parameter
	 * @param id - of type String.
	 * @return an optional {@link Account} found using the id
	 */
	public Optional<Account> findById(String id);
	
	/**
	 * Query database for all {@link Account}s.
	 * @return all {@link Account}s in the database.
	 */
	public List<Account> findAll();

}
