/*
 * The MIT License
 *
 * Copyright 2020 Yaw Agyepong <yaw.agyepong@gmail.com>.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.datingapp.models;

import java.time.LocalDate;

/**
 *
 * @author Yaw Agyepong <yaw.agyepong@gmail.com>
 */
public class User {
    private final String userId;
    private final String firstName;
    private final String lastName;
    private final LocalDate birthDate;
    private final String ethnicity;
    private final String gender;
    private final String religion;
    private final String politicalOrientation;
    private final String location;
/**
 * 
 * @param userId
 * @param firstName
 * @param lastName
 * @param birthDate
 * @param ethnicity
 * @param gender
 * @param religion
 * @param politicalOrientation
 * @param location 
 */
    public User(String userId, String firstName, String lastName, LocalDate birthDate, String ethnicity, String gender, String religion, String politicalOrientation, String location) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.ethnicity = ethnicity;
        this.gender = gender;
        this.religion = religion;
        this.politicalOrientation = politicalOrientation;
        this.location = location;
    }

    public String getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public String getGender() {
        return gender;
    }

    public String getReligion() {
        return religion;
    }

    public String getPoliticalOrientation() {
        return politicalOrientation;
    }

    public String getLocation() {
        return location;
    }   

    public String toJsonString() {
        return "{" 
                + "'userId': '" + userId + "', "
                + "'firstName': '" + firstName + "', "
                + "'lastName': '" + lastName + "', "
                + "'birthDate': '" + birthDate.toString() + "', "
                + "'ethnicity': '" + ethnicity + "', "
                + "'gender': '" + gender + "', "
                + "'religion': '" + religion + "', "
                + "'politicalOrientation': '" + politicalOrientation + "', "
                + "'location': '" + location + "'"
                + '}';
    }
}
