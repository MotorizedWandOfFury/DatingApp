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

package com.datingapp.controllers;

import com.datingapp.models.Auth;
import com.datingapp.representations.Action;
import com.datingapp.representations.datingappjson.AuthRepresentation;
import org.glassfish.jersey.server.ManagedAsync;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Response;

/**
 * @author Yaw Agyepong <yaw.agyepong@gmail.com>
 */
@Path("/auth")
public final class AuthenticationController {
    @GET
    @Produces("application/vnd.datingapp+json")
    @ManagedAsync
    public void provideAuth(@Suspended final AsyncResponse response) {
        var auth = new Auth() {
            @Override
            public String toString() {
                return super.toString();
            }
        };

        var representation = new AuthRepresentation(auth);
        representation.addAction(Action.newLoginAction());
        representation.addLink("self", "/auth");
        representation.addLink("sign-up", "/registration");

        response.resume(Response.ok(representation).build());
    }
}
