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
import java.time.LocalDate;
import java.time.Month;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Disabled;

/**
 *
 * @author Yaw Agyepong <yaw.agyepong@gmail.com>
 */
public class UserRepresentationTest {
    
    public UserRepresentationTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }
    
    /**
     * Test of build method, of class UserRepresentation.
     */
    @Disabled
    @Test
    public void testBuild() {
        LocalDate birthDate = LocalDate.of(1999, Month.MARCH, 12);
        User user = new User() {
            @Override
            public String userName() {
                return "1";
            }

            @Override
            public String firstName() {
                return "first";
            }

            @Override
            public String lastName() {
                return "last";
            }

            @Override
            public LocalDate birthDate() {
                return LocalDate.of(1999, Month.MARCH, 12);
            }

            @Override
            public String ethnicity() {
                return "black";
            }

            @Override
            public String gender() {
                return "non-binary";
            }

            @Override
            public String religion() {
                return "atheist";
            }

            @Override
            public String politicalOrientation() {
                return "leftist";
            }
        };
        UserRepresentation instance = new UserRepresentation(user);
        String expResult = "{"
                + "\"type\":\"User\","
                + "\"properties\": {"
                + "\"userId\": \"1\", \"firstName\": \"first\", \"lastName\": \"last\", \"birthDate\": \"" + birthDate.toString() + "\", " +
                "\"ethnicity\": \"black\", \"gender\": \"non-binary\", \"religion\": \"atheist\", \"politicalOrientation\": \"leftist\""
                + "},"
                + "\"children\": ["
                + "],"
                + "\"links\": ["
                + "],"
                + "\"actions\": ["
                + "]"
                + "}";
        String result = instance.build();
        assertEquals(expResult, result);
    }

    /**
     * Test of addChild method, of class UserRepresentation.
     */
    @Disabled
    @Test
    public void testAddChild() {
        System.out.println("addChild");
        Representation childRepresentation = null;
        UserRepresentation instance = null;
        Representation<User> expResult = null;
        Representation<User> result = instance.addChild(childRepresentation);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addLink method, of class UserRepresentation.
     */
    @Disabled
    @Test
    public void testAddLink() {
        System.out.println("addLink");
        String relationship = "";
        String href = "";
        UserRepresentation instance = null;
        Representation<User> expResult = null;
        Representation<User> result = instance.addLink(relationship, href);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addAction method, of class UserRepresentation.
     */
    @Disabled
    @Test
    public void testAddAction() {
        System.out.println("addAction");
        Action action = null;
        UserRepresentation instance = null;
        Representation<User> expResult = null;
        Representation<User> result = instance.addAction(action);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
