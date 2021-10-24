package com.cavicci.thymeleafcrud.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cavicci.thymeleafcrud.domain.User;
import com.cavicci.thymeleafcrud.repository.UserRepository;

import javassist.NotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public User findById(Long id) throws NotFoundException {
		
		Optional<User> opUser = repository.findById(id);
		
		if(opUser.isEmpty()) {
			throw new NotFoundException(String.format("Usuário com id %d, não encontrado.", id));
		}
		return opUser.get();
	}
	
	public Iterable<User> findAllUsers() throws NotFoundException {
		
		return repository.findAll();
		
	}
	
	public void deleteUser(User user) {
		repository.delete(user);
		
	}
	
	
	
	public User saveUser(User user) {
		return repository.save(user);
	}
	
}
