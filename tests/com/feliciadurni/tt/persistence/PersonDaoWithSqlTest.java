package com.feliciadurni.tt.persistence;

import com.feliciadurni.tt.entity.Person;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

/**
 * Created by felic on 2/7/2016.
 */
public class PersonDaoWithSqlTest {

    @Test
    public void testGetAllPeople() throws Exception {

        PersonDaoWithSql daoWithSql = new PersonDaoWithSql();
        List<Person> people = daoWithSql.getAllPeople();
        assertTrue(people.size() > 0);
    }

    @Test
    public void testUpdatePerson() throws Exception {

    }

    @Test
    public void testDeletePerson() throws Exception {

    }

    @Test
    public void testAddPerson() throws Exception {

    }
}