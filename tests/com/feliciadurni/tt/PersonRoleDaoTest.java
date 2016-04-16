package com.feliciadurni.tt;

import com.feliciadurni.tt.entity.PersonRole;
import com.feliciadurni.tt.persistence.PersonRoleDao;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by felic on 4/16/2016.
 */
public class PersonRoleDaoTest {

    private final Logger log = Logger.getLogger(this.getClass());

    @Test
    public void testGetAllRoles() throws Exception {

        PersonRoleDao dao = new PersonRoleDao();
        List<PersonRole> roles = dao.getAllRoles();

        assertTrue("There is the wrong amount in the list", roles.size() > 0);
    }

    @Test
    public void testGetPersonRole() throws Exception {

        PersonRoleDao dao = new PersonRoleDao();
        PersonRole personRole = dao.getPersonRole(1);
        assertNotNull("Could not get personRole", personRole);
    }

    @Test
    public void testUpdatePersonRole() throws Exception {

        PersonRoleDao dao = new PersonRoleDao();
        PersonRole personRole = new PersonRole();
        personRole.setPersonId(1);
        personRole.setRole("admin");

        dao.updatePersonRole(personRole);
        assertNotNull("Could not update personRole", personRole.getPersonId());
    }

    @Test
    public void testDeletePersonRole() throws Exception {

        PersonRoleDao dao = new PersonRoleDao();
        PersonRole personRole = new PersonRole();
        personRole.setPersonId(2);

        Boolean personRoleDeleted = dao.deletePersonRole(personRole);
        assertTrue(personRoleDeleted);
    }

    @Test
    public void testAddPersonRole() throws Exception {

        PersonRoleDao dao = new PersonRoleDao();
        int insertPersonRoleId = 0;

        PersonRole personRole = new PersonRole();
        personRole.setRole("admin");
        personRole.setUserName("username");

        insertPersonRoleId = dao.addPersonRole(personRole);

        assertTrue(insertPersonRoleId > 0);
    }
}
