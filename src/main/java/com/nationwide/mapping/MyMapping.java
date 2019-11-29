package com.nationwide.mapping;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Will map values from one object into a new Object of a specified type;
 * @author Chris
 *
 */
public class MyMapping {

	@Autowired
	private ModelMapper modelMapper;

	/**
	 * Turns one object into another type of object.
	 *  <b>Example:</b>
	 * 	Account account = map(accountDto, Account.class)
	 * @param source - an object that you want to convert
	 * @param destinationType - the type of class you want to turn it into
	 * @return
	 */
	public <T, S> S map(T source, Class<S> destinationType) {
		return modelMapper.map(source, destinationType);
	}

	/**
	 * Turns a list of items into another list of items.
	 *  <b>Example:</b>
	 * 	List<Account> accounts = map(accountDtos, Account.class)
	 * @param source - an object that you want to convert
	 * @param destinationType - the type of class you want to turn it into
	 * @return
	 */
	public <T, S> List<S> map(List<T> source, Class<S> destinationType) {
		return source.stream().map(sourceItem -> map(sourceItem, destinationType)).collect(Collectors.toList());
	}
}
