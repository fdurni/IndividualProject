package com.feliciadurni.tt.persistence;

import com.feliciadurni.tt.entity.PersonprogramroutineEntity;
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
public class PersonProgramRoutineEntityDaoWithHibernate implements PersonProgramRoutineEntityDao {

    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    public List<PersonprogramroutineEntity> getAllPersonProgramRoutines() {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        List<PersonprogramroutineEntity> personProgramRoutines = new ArrayList<PersonprogramroutineEntity>();
        Transaction dbTransaction = null;

        try {
            dbTransaction = session.beginTransaction();
            List personProgramRoutinesInDB = session.createQuery("FROM PersonprogramroutineEntity").list();

            for (Iterator iterator = personProgramRoutinesInDB.iterator(); iterator.hasNext();) {

                PersonprogramroutineEntity personProgramRoutine = (PersonprogramroutineEntity) iterator.next();
                personProgramRoutines.add(personProgramRoutine);
            }

            dbTransaction.commit();

        } catch (HibernateException error) {
            if (dbTransaction!=null) dbTransaction.rollback();
            error.printStackTrace();
        } finally {
            session.close();
        }

        log.info("Number of personProgramRoutines: " + personProgramRoutines.size());

        return personProgramRoutines;
    }

    public PersonprogramroutineEntity getPersonProgramRoutine(Integer id) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        List<PersonprogramroutineEntity> personProgramRoutine = new ArrayList<PersonprogramroutineEntity>();
        Transaction dbTransaction = null;

        String query = ("FROM PersonprogramroutineEntity P WHERE P.personProgramRoutineId =" + id);

        try {
            dbTransaction = session.beginTransaction();
            personProgramRoutine = session.createQuery(query).list();

        } catch (HibernateException error) {
            if (dbTransaction!=null) dbTransaction.rollback();
            error.printStackTrace();
        } finally {
            session.close();
        }

        return personProgramRoutine.get(0);
    }

    @Override
    public void updatePersonProgramRoutine(PersonprogramroutineEntity personProgramRoutine) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.update(personProgramRoutine);
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
    public Boolean deletePersonProgramRoutine(PersonprogramroutineEntity personProgramRoutine) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction dbTransaction = null;

        try {
            dbTransaction = session.beginTransaction();
            PersonprogramroutineEntity personProgramRoutineToDelete = (PersonprogramroutineEntity)session.get(PersonprogramroutineEntity.class, personProgramRoutine.getPersonProgramRoutineId());
            session.delete(personProgramRoutineToDelete);
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
    public int addPersonProgramRoutine(PersonprogramroutineEntity personProgramRoutine) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        Integer personProgramRoutineId = null;
        try {
            tx = session.beginTransaction();
            personProgramRoutineId = (Integer) session.save(personProgramRoutine);
            tx.commit();
            log.info("Added personProgramRoutine: " + personProgramRoutine + " with id of: " + personProgramRoutineId);
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }
        return personProgramRoutineId;
    }
}
