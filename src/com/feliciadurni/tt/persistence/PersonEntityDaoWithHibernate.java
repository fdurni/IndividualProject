package com.feliciadurni.tt.persistence;

import com.feliciadurni.tt.entity.PersonEntity;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by felic on 2/7/2016.
 */
public class PersonEntityDaoWithHibernate implements PersonEntityDao {

    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    public List<PersonEntity> getAllPeople() {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        List<PersonEntity> people = new ArrayList<PersonEntity>();
        Transaction dbTransaction = null;

        try {
            dbTransaction = session.beginTransaction();
            List peopleInDB = session.createQuery("FROM PersonEntity").list();

            for (Iterator iterator = peopleInDB.iterator(); iterator.hasNext();) {

                PersonEntity person = (PersonEntity) iterator.next();
                people.add(person);
            }

            dbTransaction.commit();

        } catch (HibernateException error) {
            if (dbTransaction!=null) dbTransaction.rollback();
            error.printStackTrace();
        } finally {
            session.close();
        }

        log.info("Number of people: " + people.size());

        return people;
    }

    public PersonEntity getPerson(Integer id) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        List<PersonEntity> people = new ArrayList<PersonEntity>();
        Transaction dbTransaction = null;

        String query = ("FROM PersonEntity P WHERE P.personId =" + id);

        try {
            dbTransaction = session.beginTransaction();
            people = session.createQuery(query).list();

        } catch (HibernateException error) {
            if (dbTransaction!=null) dbTransaction.rollback();
            error.printStackTrace();
        } finally {
            session.close();
        }

        return people.get(0);
    }

    @Override
    public void updatePerson(PersonEntity person) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.update(person);
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

    @Override
    public Boolean deletePerson(PersonEntity person) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction dbTransaction = null;

        try {
            dbTransaction = session.beginTransaction();
            PersonEntity personToDelete = (PersonEntity)session.get(PersonEntity.class, person.getPersonId());
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

    @Override
    public int addPerson(PersonEntity person) {

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