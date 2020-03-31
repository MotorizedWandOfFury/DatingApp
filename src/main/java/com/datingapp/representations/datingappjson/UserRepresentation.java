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
package com.datingapp.representations.datingappjson;

import com.datingapp.models.User;
import com.datingapp.representations.Action;
import com.datingapp.representations.Representation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

/**
 *
 * @author Yaw Agyepong <yaw.agyepong@gmail.com>
 */
public final class UserRepresentation implements Representation<User> {

    private final User user;
    private final ArrayList<Representation<?>> children;
    private final HashMap<String, String> links;
    private final ArrayList<Action> actions;

    public UserRepresentation(User user) {
        this.user = user;
        this.children = new ArrayList<>();
        this.links = new HashMap<>();
        this.actions = new ArrayList<>();
    }

    @Override
    public Representation<User> addChild(Representation<?> childRepresentation) {
        children.add(childRepresentation);
        return this;
    }

    @Override
    public Representation<User> addLink(String relationship, String href) {
        links.put(relationship, href);
        return this;
    }

    @Override
    public Representation<User> addAction(Action action) {
        actions.add(action);
        return this;
    }

    @Override
    public String build() {
        String typeKey = "%TYPE%";
        String propertiesKey = "%PROPERTIES%";
        String childrenKey = "%CHILDREN%";
        String linkKey = "%LINKS%";
        String actionsKey = "%ACTIONS%";
        
        String datingAppJsonTemplate = "{"
                + "\"type\":" + "\""+typeKey+"\","
                + "\"properties\": "
                + propertiesKey
                + ","
                + "\"children\": ["
                + childrenKey
                + "],"
                + "\"links\": ["
                + linkKey
                + "],"
                + "\"actions\": ["
                + actionsKey
                + "]"
                + "}";

        String type = "User";
        String childrenRepresentation = children.stream().map(Object::toString).collect(Collectors.joining(","));
        String linksRepresentation = links.entrySet().stream().map(entry -> String.format("{\"rel\":\"%s\", \"href\":\"%s\"}", entry.getKey(), entry.getValue())).collect(Collectors.joining(","));
        String actionsRepresentation = "";
        
        return datingAppJsonTemplate.replace(typeKey, type)
                .replace(propertiesKey, user.toJsonString())
                .replace(childrenKey, childrenRepresentation)
                .replace(linkKey, linksRepresentation)
                .replace(actionsKey, actionsRepresentation);
    }
}
