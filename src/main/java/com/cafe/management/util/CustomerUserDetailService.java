package com.cafe.management.util;

import com.cafe.management.entity.User;
import com.cafe.management.dao.UserDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;

@Slf4j
@Service
public class CustomerUserDetailService implements UserDetailsService {

    @Autowired
    UserDao userDao;

    private User userDetails;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("Inside loadByUserName {}", username);
        userDetails = userDao.findByEmailId(username);
        if (!Objects.isNull(username)) {

            return new org.springframework.security.core.userdetails.User(userDetails.getEmail(), userDetails.getPassword(), new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User doesn't found");
        }

    }

    public User getUserDetails() {
        return userDetails;
    }
}
