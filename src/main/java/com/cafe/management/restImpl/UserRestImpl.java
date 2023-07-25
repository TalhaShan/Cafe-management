package com.cafe.management.restImpl;

import com.cafe.management.constants.CafeConstants;
import com.cafe.management.rest.UserRest;
import com.cafe.management.service.UserService;
import com.cafe.management.utils.CafeUtil;
import com.cafe.management.wrapper.UserWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class UserRestImpl implements UserRest {


    @Autowired
    UserService userService;

    @Override
    public ResponseEntity<String> signup(Map<String, String> requestMap) {
        try {

            return userService.signup(requestMap);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return CafeUtil.getResponseEntity(CafeConstants
                .SOME_THING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> login(Map<String, String> requestMap) {

        try {
            return userService.login(requestMap);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return CafeUtil.getResponseEntity(CafeConstants
                .SOME_THING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<List<UserWrapper>> getAllUser() {
     try {
        return userService.getAllUsers();
     }catch (Exception e){
         e.printStackTrace();
     }
        return new ResponseEntity<List<UserWrapper>>(new ArrayList<>(),HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
