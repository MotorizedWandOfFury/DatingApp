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
package com.datingapp.controllers;

import com.datingapp.db.PgUsers;
import com.datingapp.models.Users;
import com.datingapp.models.User;
import com.datingapp.representations.datingappjson.UserRepresentation;
import org.glassfish.jersey.server.ManagedAsync;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

/**
 * @author Yaw Agyepong <yaw.agyepong@gmail.com>
 */
@Path("/user")
public final class UserController {
    @GET
    @Produces("application/vnd.datingapp+json")
    @ManagedAsync
    public void getUser(
            @HeaderParam(HttpHeaders.AUTHORIZATION) String authorization,
            @Suspended final AsyncResponse response) {

        try {
            Users users = new PgUsers();
            String authToken = authorization.replace("Bearer ", "").trim();
            User user = users.getUserByToken(authToken);

            if (user == null) {
                response.resume(new NotFoundException());
                return;
            }

            UserRepresentation representation = new UserRepresentation(user);
            representation.addLink("self", "/user");

            response.resume(Response.ok(representation).build());
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            response.resume(new InternalServerErrorException(e));
        }
    }
}
