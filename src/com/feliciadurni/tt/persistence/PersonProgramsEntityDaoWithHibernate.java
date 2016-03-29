package com.feliciadurni.tt.persistence;

import com.feliciadurni.tt.entity.PersonprogramsEntity;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by felic on 3/29/2016.
 */
public class PersonProgramsEntityDaoWithHibernate implements PersonProgramsEntityDao {

    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    public List<PersonprogramsEntity> getAllPersonPrograms() {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        List<PersonprogramsEntity> personPrograms = new ArrayList<PersonprogramsEntity>();
        Transaction dbTransaction = null;

        try {
            dbTransaction = session.beginTransaction();
            List personProgramsInDB = session.createQuery("FROM PersonprogramsEntity").list();

            for (Iterator iterator = personProgramsInDB.iterator(); iterator.hasNext();) {

                PersonprogramsEntity personProgram = (PersonprogramsEntity) iterator.next();
                personPrograms.add(personProgram);
            }

            dbTransaction.commit();

        } catch (HibernateException error) {
            if (dbTransaction!=null) dbTransaction.rollback();
            error.printStackTrace();
        } finally {
            session.close();
        }

        log.info("Number of personPrograms: " + personPrograms.size());

        return personPrograms;
    }

    public PersonprogramsEntity getPersonProgram(Integer id) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        List<PersonprogramsEntity> personProgram = new ArrayList<PersonprogramsEntity>();
        Transaction dbTransaction = null;

        String query = ("FROM PersonprogramsEntity P WHERE P.personProgramId =" + id);

        try {
            dbTransaction = session.beginTransaction();
            personProgram = session.createQuery(query).list();

        } catch (HibernateException error) {
            if (dbTransaction!=null) dbTransaction.rollback();
            error.printStackTrace();
        } finally {
            session.close();
        }

        return personProgram.get(0);
    }

    @Override
    public void updatePersonProgram(PersonprogramsEntity personProgram) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.update(personProgram);
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
    public Boolean deletePersonProgram(PersonprogramsEntity personProgram) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction dbTransaction = null;

        try {
            dbTransaction = session.beginTransaction();
            PersonprogramsEntity personProgramToDelete = (PersonprogramsEntity)session.get(PersonprogramsEntity.class, personProgram.getPersonProgramId());
            session.delete(personProgramToDelete);
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
    public int addPersonProgram(PersonprogramsEntity personProgram) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        Integer personProgramId = null;
        try {
            tx = session.beginTransaction();
            personProgramId = (Integer) session.save(personProgram);
            tx.commit();
            log.info("Added personProgram: " + personProgram + " with id of: " + personProgramId);
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }
        return personProgramId;
    }
}
