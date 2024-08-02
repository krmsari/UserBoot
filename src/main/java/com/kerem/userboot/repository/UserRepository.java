package com.kerem.userboot.repository;

import com.kerem.userboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    Optional<User> findByName(String name);

    Optional<User> findUserById(Integer id);
}
