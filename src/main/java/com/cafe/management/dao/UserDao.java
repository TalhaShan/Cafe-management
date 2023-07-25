package com.cafe.management.dao;

import com.cafe.management.entity.User;
import com.cafe.management.wrapper.UserWrapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface UserDao extends JpaRepository<User,Integer> {
    User findByEmailId(@Param("email") String email);
    List<UserWrapper> getAllUsers();
}
