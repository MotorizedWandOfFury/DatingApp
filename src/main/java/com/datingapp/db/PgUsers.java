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
import com.datingapp.models.Users;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.generated.tables.records.UsersRecord;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;

import static org.jooq.generated.Tables.USERS;

/**
 * @author Yaw Agyepong <yaw.agyepong@gmail.com>
 */
public class PgUsers implements Users {

    public User getUserById(int id) throws SQLException {
        User user = null;

        try (Connection con = TomcatDataSource.INSTANCE.getAvailableConnection()) {
            DSLContext jooqContext = DSL.using(con, SQLDialect.POSTGRES);
            UsersRecord usersRecord = jooqContext.select()
                    .from(USERS)
                    .where(USERS.ID.eq(id))
                    .fetchOne()
                    .into(USERS);

            user = toUser(usersRecord);
        }

        return user;
    }

    public User getUserByUsernameAndPassword(String userId, String password) throws SQLException {
        User user = null;

        try (Connection con = TomcatDataSource.INSTANCE.getAvailableConnection()) {
            DSLContext jooqContext = DSL.using(con, SQLDialect.POSTGRES);
            UsersRecord usersRecord = jooqContext.select()
                    .from(USERS)
                    .where(USERS.USER_NAME.eq(userId))
                    .and(USERS.PASSWORD.eq(password))
                    .fetchOne()
                    .into(USERS);

            user = toUser(usersRecord);
        }

        return user;
    }

    private User toUser(UsersRecord user) {
        return new User() {
            @Override
            public String userName() {
                return user.getUserName();
            }

            @Override
            public String firstName() {
                return user.getFirstName();
            }

            @Override
            public String lastName() {
                return user.getLastName();
            }

            @Override
            public LocalDate birthDate() {
                return user.getBirthday().toLocalDate();
            }

            @Override
            public String ethnicity() {
                return user.getEthnicity().getLiteral();
            }

            @Override
            public String gender() {
                return user.getGender().getLiteral();
            }

            @Override
            public String religion() {
                return "";
            }

            @Override
            public String politicalOrientation() {
                return "";
            }
        };
    }
}
