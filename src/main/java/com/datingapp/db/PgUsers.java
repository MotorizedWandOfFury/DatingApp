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
import java.sql.SQLException;

import static org.jooq.generated.Tables.TOKENS;
import static org.jooq.generated.Tables.USERS;

/**
 * @author Yaw Agyepong <yaw.agyepong@gmail.com>
 */
public final class PgUsers implements Users {

    @Override
    public User getUserByToken(String token) throws SQLException {
        User user = null;

        try (Connection con = TomcatDataSource.INSTANCE.getAvailableConnection()) {
            DSLContext jooqContext = DSL.using(con, SQLDialect.POSTGRES);
            UsersRecord usersRecord = jooqContext.select()
                    .from(USERS)
                    .join(TOKENS)
                    .on(USERS.ID.eq(TOKENS.USER_ID))
                    .where(TOKENS.TOKEN.eq(token))
                    .fetchOne()
                    .into(USERS);

            user = new PgUser(usersRecord);
        }

        return user;
    }
}
