package io.mohsinkd786.services.impl;

import io.mohsinkd786.dtos.Employee;
import io.mohsinkd786.dtos.User;
import io.mohsinkd786.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl {

    private UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public void transform(){
        User user = new User();
        user.setAddress(new User.Address());
        // call mapper
        Employee employee = userMapper.map(user,Employee.class);
    }
}
