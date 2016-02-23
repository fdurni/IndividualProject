package com.feliciadurni.tt.persistence;

import com.feliciadurni.tt.entity.Person;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by felic on 2/7/2016.
 */
public class PersonDaoWithHibernateTest {

    @Test
    public void testGetAllPeople() throws Exception {

    }

    @Test
    public void testUpdatePerson() throws Exception {

    }

    @Test
    public void testDeletePerson() throws Exception {

    }

    @Test
    public void testAddPerson() throws Exception {

        PersonDaoWithHibernate dao = new PersonDaoWithHibernate();
        int insertedPersonId = 0;
        //create person to add
        Person person = new Person();
        person.setFirstName("First");
        person.setLastName("Test");
        person.setUserName("testUser01");
        person.setPassword("supersecret");
        person.setPersonId(0);

        insertedPersonId = dao.addPerson(person);

        assertTrue(insertedPersonId > 0);
    }
}