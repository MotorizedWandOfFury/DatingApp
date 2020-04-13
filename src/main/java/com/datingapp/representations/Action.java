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
package com.datingapp.representations;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yaw Agyepong <yaw.agyepong@gmail.com>
 */
public class Action {

    private final ActionType type;
    private final String label;
    private final ActionMethod method;
    private final String href;
    private final List<Field> fields;

    private Action(ActionType type, String label, ActionMethod method, String href, List<Field> fields) {
        this.type = type;
        this.label = label;
        this.method = method;
        this.href = href;
        this.fields = fields;
    }

    public static Action newLoginAction() {
        return new Action.Builder()
                .setLabel("Please Sign In")
                .setType(Action.ActionType.FORM)
                .setMethod(ActionMethod.POST)
                .setHref("/auth")
                .addField(new Field("username", FieldType.TEXT))
                .addField(new Field("password", FieldType.TEXT))
                .createAction();
    }

    public enum ActionMethod {
        POST, PUT, DELETE
    }

    public enum FieldType {
        HIDDEN, TEXT, NUMBER
    }

    public enum ActionType {
        BUTTON, FORM
    }

    public static class Builder {
        private ActionType type;
        private String label;
        private Action.ActionMethod method;
        private String href;
        private List<Action.Field> fields;

        public Builder() {
            fields = new ArrayList<>();
        }

        public Builder setType(ActionType type) {
            this.type = type;
            return this;
        }

        public Builder setLabel(String label) {
            this.label = label;
            return this;
        }

        public Builder setMethod(Action.ActionMethod method) {
            this.method = method;
            return this;
        }

        public Builder setHref(String href) {
            this.href = href;
            return this;
        }

        public Builder addField(Field field) {
            this.fields.add(field);
            return this;
        }

        public Action createAction() {
            return new Action(type, label, method, href, fields);
        }
    }

    public static class Field {
        private final String name;
        private final FieldType type;
        private final String value;

        public Field(String name, FieldType type) {
            this(name, type, null);
        }

        public Field(String name, FieldType type, String value) {
            this.name = name;
            this.type = type;
            this.value = value;
        }
    }
}
