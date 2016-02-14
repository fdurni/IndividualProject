package com.feliciadurni.tt.persistence;

import com.feliciadurni.tt.entity.User;
import org.apache.log4j.Logger;
import org.junit.Test;

import javax.ejb.TransactionAttribute;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by felic on 2/7/2016.
 */
public class UserDaoWithHibernateTest {

    @Test
    public void testGetAllUsers() throws Exception {

    }

    @Test
    public void testUpdateUser() throws Exception {

    }

    @Test
    public void testDeleteUser() throws Exception {

    }

    @Test
    public void testAddUser() throws Exception {

        UserDaoWithHibernate dao = new UserDaoWithHibernate();
        int insertedUserId = 0;
        //create user to add
        User user = new User();
        user.setFirstName("Second");
        user.setLastName("Test");
        user.setEmailAddress("secondtest@gmail.com");
        user.setPassword("supersecret");
        user.setId(0);

        insertedUserId = dao.addUser(user);

        assertTrue(insertedUserId > 0);
    }
}