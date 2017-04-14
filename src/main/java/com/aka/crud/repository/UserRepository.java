package com.aka.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aka.crud.model.User;
 
/**
 * 
 * @author jibanezg
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
 
}