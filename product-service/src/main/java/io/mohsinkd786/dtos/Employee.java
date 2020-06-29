package io.mohsinkd786.dtos;

import lombok.Data;

@Data
public class Employee {

    private int employeeId;
    private String userName;
    private String password;
    private String employeeEmail;
    private String city;
    private String pinCode;
}
