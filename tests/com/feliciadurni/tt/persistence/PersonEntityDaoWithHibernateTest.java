package com.feliciadurni.tt.persistence;

import com.feliciadurni.tt.entity.PersonEntity;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by felic on 2/7/2016.
 */
public class PersonEntityDaoWithHibernateTest {

    @Test
    public void testGetAllPeople() throws Exception {

        PersonEntityDaoWithHibernate dao = new PersonEntityDaoWithHibernate();
        List<PersonEntity> people = dao.getAllPeople();

        assertTrue("There is the wrong amount in the list", people.size() > 0);
    }

    @Test
    public void testGetPerson() throws Exception {

        PersonEntityDaoWithHibernate dao = new PersonEntityDaoWithHibernate();
        PersonEntity person = dao.getPerson(19);

        assertNotNull("Could not get person", person);
    }

    @Test
    public void testUpdatePerson() throws Exception {

        PersonEntityDaoWithHibernate dao = new PersonEntityDaoWithHibernate();
        PersonEntity person = new PersonEntity();
        person.setPersonId(6);
        person.setFirstName("Salu");
        person.setLastName("Digby");
        person.setUserName("AtomGirl");
        person.setPassword("password1");

        dao.updatePerson(person);
        assertEquals("This is the wrong user", "Second", person.getFirstName());
    }

    @Test
    public void testDeletePerson() throws Exception {

        PersonEntityDaoWithHibernate dao = new PersonEntityDaoWithHibernate();
        PersonEntity person = new PersonEntity();
        int sizeBefore;
        int sizeAfter;
        person.setPersonId(6);
        person.setFirstName("Salu");
        person.setLastName("Digby");
        person.setUserName("AtomGirl");
        person.setPassword("password1");
        sizeBefore = dao.getAllPeople().size();
        dao.deletePerson(person);
        sizeAfter = dao.getAllPeople().size();

        assertTrue("The user was not deleted", sizeBefore > sizeAfter);
    }

    @Test
    public void testAddPerson() throws Exception {

        PersonEntityDaoWithHibernate dao = new PersonEntityDaoWithHibernate();
        int insertUserId = 0;

        //create user to add
        PersonEntity person = new PersonEntity();
        person.setFirstName("Ororo");
        person.setLastName("Monroe");
        person.setUserName("Storm");
        person.setPassword("password1");

        insertUserId = dao.addPerson(person);

        assertTrue(insertUserId > 0);
    }
}