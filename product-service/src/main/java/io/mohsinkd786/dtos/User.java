package io.mohsinkd786.dtos;

import lombok.Data;

@Data
public class User {

    private int userId;
    private String userName;
    private String password;
    private String email;
    private Address address;

    public void setAddress(Address address) {
    }

    @Data
    public static class Address{
        private int id;
        private String city;
        private String state;
        private String zipCode;
    }
}


