package com.nationwide.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nationwide.persistence.domain.Account;
import com.nationwide.persistence.repository.AccountRepository;

/**
 * A service that calls the {@link AccountREpository} to communicate with the database
 * @author Adam
 *
 */
@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;
	
	/**
	 * returns an {@link Account} from the database using the parameter
	 * @param username - a String that contains the username from the database
	 * @return an optional {@link Account} found using the username
	 */
	public Optional<Account> readByUsername(String username) {
		return accountRepository.findByUsername(username);
	}
	
	/**
	 * returns an {@link Account} from the database using the parameter
	 * @param bearerToken - a String that contains the bearerToken from the database
	 * @return an optional {@link Account} found using the bearerToken
	 */
	public Optional<Account> readByBearerToken(String bearerToken) {
		return accountRepository.findByBearerToken(bearerToken);
	}
	
	/**
	 * returns an {@link Account} from the database using the parameter
	 * @param id - a long that contains the id from the database
	 * @return an optional {@link Account} found using the id
	 */
	public Optional<Account> readById(long id) {
		return accountRepository.findById(id);
	}
	
	/** returns all {@link Account}s from the database
	 * @return a {@link List} of {@link Account}
	 */
	public List<Account> readAll() {
		return accountRepository.findAll();
	}
	
	
	/**
	 * Takes in an {@link Account} and saves it to DB
	 * @param account
	 * @return account
	 */
	public Account createAccount(Account account) {
		return new Account();
	}
	
}
