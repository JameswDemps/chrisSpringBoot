package com.nationwide.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nationwide.persistence.domain.Account;
import com.nationwide.persistence.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;
	
	public Optional<Account> readByUsername(String username) {
		return accountRepository.findByUsername(username);
	}
	
	public Optional<Account> readByBearerToken(String bearerToken) {
		return accountRepository.findByBearerToken(bearerToken);
	}
	
	public Optional<Account> readById(String id) {
		return accountRepository.findById(id);
	}
	
	public List<Account> readAll() {
		return accountRepository.findAll();
	}
	
}
