package com.feliciadurni.tt.persistence;

import com.feliciadurni.tt.entity.User;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

/**
 * Created by felic on 2/7/2016.
 */
public class UserDaoWithSqlTest {

    @Test
    public void testGetAllUsers() throws Exception {

        UserDaoWithSql daoWithSql = new UserDaoWithSql();
        List<User> users = daoWithSql.getAllUsers();
        assertTrue(users.size() > 0);
    }

    @Test
    public void testUpdateUser() throws Exception {

    }

    @Test
    public void testDeleteUser() throws Exception {

    }

    @Test
    public void testAddUser() throws Exception {

    }
}