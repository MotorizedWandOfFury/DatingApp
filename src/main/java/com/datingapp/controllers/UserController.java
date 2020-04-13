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

import javax.ws.rs.*;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

/**
 *
 * @author Yaw Agyepong <yaw.agyepong@gmail.com>
 */
@Path("/users")
public final class UserController {
    @GET
    @Path("/{username}")
    @Produces("application/vnd.datingapp+json")
    public Response getUser(@PathParam("username") String username, @HeaderParam(HttpHeaders.AUTHORIZATION) String authToken) {

        try {
            Users users = new PgUsers();
            User user = users.getUserById(1);

            if(user == null) {
                throw new NotFoundException();
            }

            UserRepresentation representation = new UserRepresentation(user);
            representation.addLink("self", "/users/"+username);

            return Response.ok(representation).build();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new InternalServerErrorException(e);
        }
    }
}
