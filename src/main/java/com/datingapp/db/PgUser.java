/*
 * The MIT License
 *
 *  Copyright 2020 Yaw Agyepong <yaw.agyepong@gmail.com>.
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in
 *  all copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *  THE SOFTWARE.
 *
 */

package com.datingapp.db;

import com.datingapp.models.User;
import org.jooq.generated.tables.records.UsersRecord;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * @author Yaw Agyepong <yaw.agyepong@gmail.com>
 */
public class PgUser implements User {
    private final String userName;
    private final String firstName;
    private final String lastName;
    private final LocalDate birthday;
    private final String ethnicity;
    private final String gender;
    private final String religion;
    private final String politicalOrientation;

    PgUser(@NotNull UsersRecord usersRecord) {
        userName = usersRecord.getUserName();
        firstName = usersRecord.getFirstName();
        lastName = usersRecord.getLastName();
        birthday = usersRecord.getBirthday().toLocalDate();
        ethnicity = usersRecord.getEthnicity().getLiteral();
        gender = usersRecord.getGender().getLiteral();
        religion = usersRecord.getReligion().getLiteral();
        politicalOrientation = usersRecord.getPoliticalorientation().getLiteral();
    }

    @Override
    public String userName() {
        return userName;
    }

    @Override
    public String firstName() {
        return firstName;
    }

    @Override
    public String lastName() {
        return lastName;
    }

    @Override
    public LocalDate birthDate() {
        return birthday;
    }

    @Override
    public String ethnicity() {
        return ethnicity;
    }

    @Override
    public String gender() {
        return gender;
    }

    @Override
    public String religion() {
        return religion;
    }

    @Override
    public String politicalOrientation() {
        return politicalOrientation;
    }
}
