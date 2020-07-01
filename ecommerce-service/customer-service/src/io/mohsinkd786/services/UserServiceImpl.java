package io.mohsinkd786.services;

import io.mohsinkd786.dtos.UserDto;
import io.mohsinkd786.services.apis.UserService;

public class UserServiceImpl implements UserService {

    @Override
    public UserDto getUser() {
        UserDto userDto = new UserDto();
        userDto.setId(100);
        userDto.setName("Dummy User");
        return userDto;
    }
}
