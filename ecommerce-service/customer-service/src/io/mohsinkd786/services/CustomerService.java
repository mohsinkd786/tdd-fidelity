package io.mohsinkd786.services;

import io.mohsinkd786.dtos.UserDto;

public class CustomerService {

    public void getUserDetails(){
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setName("Mohsin");
    }
}
