package com.datingapp.db;

import com.datingapp.models.User;

import java.time.LocalDate;
import java.time.Month;

public class Users {
    public User getUserById(String id) {
        LocalDate birthDate = LocalDate.of(1999, Month.MARCH, 12);
        return new User(id, "first", "last", birthDate, "black", "non-binary", "atheist", "leftist", "Atlanta, GA");
    }
}
