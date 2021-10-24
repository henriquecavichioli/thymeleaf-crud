package com.cavicci.thymeleafcrud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cavicci.thymeleafcrud.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
