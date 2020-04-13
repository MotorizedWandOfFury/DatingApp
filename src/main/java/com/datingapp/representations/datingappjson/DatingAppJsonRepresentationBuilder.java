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

package com.datingapp.representations.datingappjson;

import com.datingapp.config.LocalDataTypeAdapter;
import com.datingapp.representations.Action;
import com.datingapp.representations.Representation;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Yaw Agyepong <yaw.agyepong@gmail.com>
 */
public final class DatingAppJsonRepresentationBuilder<T> implements Representation<T> {

    @SerializedName("type") private final String type;
    @SerializedName("properties") private final T resource;
    @SerializedName("children") private final ArrayList<Representation<?>> children;
    @SerializedName("links") private final HashMap<String, String> links;
    @SerializedName("actions") private final ArrayList<Action> actions;

    DatingAppJsonRepresentationBuilder(T resource, String type) {
        this.resource = resource;
        this.type = type;
        this.children = new ArrayList<>();
        this.links = new HashMap<>();
        this.actions = new ArrayList<>();
    }

    @Override
    public void addChild(Representation<?> childRepresentation) {
        children.add(childRepresentation);
    }

    @Override
    public void addLink(String relationship, String href) {
        links.put(relationship, href);
    }

    @Override
    public void addAction(Action action) {
        actions.add(action);
    }

    @Override
    public String build() {
        return new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(LocalDate.class, new LocalDataTypeAdapter())
                .create()
                .toJson(this);
    }
}
