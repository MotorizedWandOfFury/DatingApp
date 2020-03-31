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

import java.util.Date;

/**
 *
 * @author Yaw Agyepong <yaw.agyepong@gmail.com>
 */
public class Message {
    private final String messageId;
    private final String messageThreadId;
    private final String toUserId;
    private final String fromUserId;
    private final Date dateSent;
    private final String messageText;

    public Message(String messageId, String messageThreadId, String toUserId, String fromUserId, Date dateSent, String messageText) {
        this.messageId = messageId;
        this.messageThreadId = messageThreadId;
        this.toUserId = toUserId;
        this.fromUserId = fromUserId;
        this.dateSent = dateSent;
        this.messageText = messageText;
    }

    public String getMessageId() {
        return messageId;
    }

    public String getMessageThreadId() {
        return messageThreadId;
    }

    public String getToUserId() {
        return toUserId;
    }

    public String getFromUserId() {
        return fromUserId;
    }

    public Date getDateSent() {
        return dateSent;
    }

    public String getMessageText() {
        return messageText;
    }
}
