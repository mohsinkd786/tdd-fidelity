package io.mohsinkd786.mappers;

import io.mohsinkd786.dtos.Employee;
import io.mohsinkd786.dtos.User;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapper extends ConfigurableMapper {
    @Override
    protected void configure(MapperFactory factory) {
        super.configure(factory);
        factory.registerClassMap(factory.classMap(User.class, Employee.class)
                .field("userId", "employeeId")
                .field("userName", "userName")
                .field("password", "password")
                .field("email", "employeeEmail")
                .field("address.city", "city")
                .field("address.zipCode", "pinCode")
                .toClassMap());
    }
}
