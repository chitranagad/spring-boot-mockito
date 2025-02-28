package com.mockito.spring_boot_mockito.dao;

import com.mockito.spring_boot_mockito.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    List<User> findByAddress(String address);
}
