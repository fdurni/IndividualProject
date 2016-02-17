package com.feliciadurni.tt.persistence;

import com.feliciadurni.tt.entity.Person;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by felic on 2/7/2016.
 */
public class PersonDaoWithHibernate implements PersonDao {

    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    public List<Person> getAllPeople() {
        List<Person> people = new ArrayList<Person>();
        return people;
    }

    @Override
    public void updatePerson(Person person) {

    }

    @Override
    public void deletePerson(Person person) {

    }

    @Override
    public int addPerson(Person person) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        Integer personId = null;
        try {
            tx = session.beginTransaction();
            personId = (Integer) session.save(person);
            tx.commit();
            log.info("Added person: " + person + " with id of: " + personId);
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }
        return personId;
    }
}