package com.feliciadurni.tt;

import com.feliciadurni.tt.entity.Person;
import com.feliciadurni.tt.entity.Program;
import com.feliciadurni.tt.persistence.PersonDao;
import com.feliciadurni.tt.persistence.ProgramDao;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by felic on 4/16/2016.
 */
public class PersonDaoTest {

    private final Logger log = Logger.getLogger(this.getClass());

    @Test
    public void testGetAllPeople() throws Exception {

        PersonDao dao = new PersonDao();
        List<Person> people = dao.getAllPeople();

        assertTrue("There is the wrong amount in the list", people.size() > 0);
    }

    @Test
    public void testGetPerson() throws Exception {

        PersonDao dao = new PersonDao();
        Person person = dao.getPerson(1);
        assertNotNull("Could not get person", person);
    }

    @Test
    public void testGetPersonByUsername() throws Exception {

        PersonDao dao = new PersonDao();
        Person person = dao.getPersonByUsername("Storm");

        Integer personId = person.getPersonId();
        log.info("Person Id: " + personId);

        assertNotNull("Could not get person", person.getPersonId());
    }

    @Test
    public void testUpdatePerson() throws Exception {

        PersonDao dao = new PersonDao();
        Person person = new Person();
        person.setPersonId(1);
        person.setFirstName("Updated-First-Name");
        person.setLastName("Updated-Last-Name");
        person.setUserName("Updated-User-Name");
        person.setPassword("Updated-Password");

        dao.updatePerson(person);
        assertNotNull("Could not update person", person.getPersonId());
    }

    @Test
    public void testDeletePerson() throws Exception {

        PersonDao dao = new PersonDao();
        Person person = new Person();
        person.setPersonId(2);

        Boolean personDeleted = dao.deletePerson(person);
        assertTrue(personDeleted);
    }

    @Test
    public void testAddPerson() throws Exception {

        PersonDao dao = new PersonDao();
        int insertPersonId = 0;

        Person person = new Person();
        person.setFirstName("First-Name");
        person.setLastName("Last-Name");
        person.setUserName("User-Name");
        person.setPassword("Password");

        insertPersonId = dao.addPerson(person);

        assertTrue(insertPersonId > 0);
    }
}
