package com.example.tacoscloud.repository;

import com.example.tacoscloud.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);
}
