package com.feliciadurni.tt.persistence;

import com.feliciadurni.tt.entity.Person;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by felic on 4/16/2016.
 */
public class PersonDao {

    private final Logger log = Logger.getLogger(this.getClass());

    public List<Person> getAllPeople() {
        List<Person> people = new ArrayList<Person>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        people = (ArrayList<Person>)session.createCriteria(Person.class).list();
        return people;
    }

    public Person getPerson(Integer id) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        return (Person)session.get(Person.class, id);
    }

    public Person getPersonByUsername(String username) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();

        Criteria crit = session.createCriteria(Person.class);
        crit.add( Restrictions.eq("userName",username) );
        List<Person> person = crit.list();

        return person.get(0);
    }

    public void updatePerson(Person person) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.merge(person);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public Boolean deletePerson(Person person) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction dbTransaction = null;

        try {
            dbTransaction = session.beginTransaction();
            Person personToDelete = (Person)session.get(Person.class, person.getPersonId());
            session.delete(personToDelete);
            dbTransaction.commit();

        } catch (HibernateException error) {
            if (dbTransaction != null) dbTransaction.rollback();
            error.printStackTrace();
            return false;
        } finally {
            session.close();
        }

        return true;
    }

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
