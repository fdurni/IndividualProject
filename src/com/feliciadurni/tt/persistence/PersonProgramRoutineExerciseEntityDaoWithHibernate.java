package com.feliciadurni.tt.persistence;

import com.feliciadurni.tt.entity.PersonprogramroutineexerciseEntity;
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
public class PersonProgramRoutineExerciseEntityDaoWithHibernate implements PersonProgramRoutineExerciseEntityDao {

    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    public List<PersonprogramroutineexerciseEntity> getAllPersonProgramRoutineExercises() {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        List<PersonprogramroutineexerciseEntity> personProgramRoutineExercises = new ArrayList<PersonprogramroutineexerciseEntity>();
        Transaction dbTransaction = null;

        try {
            dbTransaction = session.beginTransaction();
            List personProgramRoutineExercisesInDB = session.createQuery("FROM PersonprogramroutineexerciseEntity").list();

            for (Iterator iterator = personProgramRoutineExercisesInDB.iterator(); iterator.hasNext();) {

                PersonprogramroutineexerciseEntity personProgramRoutineExercise = (PersonprogramroutineexerciseEntity) iterator.next();
                personProgramRoutineExercises.add(personProgramRoutineExercise);
            }

            dbTransaction.commit();

        } catch (HibernateException error) {
            if (dbTransaction!=null) dbTransaction.rollback();
            error.printStackTrace();
        } finally {
            session.close();
        }

        log.info("Number of personProgramRoutineExercises: " + personProgramRoutineExercises.size());

        return personProgramRoutineExercises;
    }

    public PersonprogramroutineexerciseEntity getPersonProgramRoutineExercise(Integer id) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        List<PersonprogramroutineexerciseEntity> personProgramRoutineExercise = new ArrayList<PersonprogramroutineexerciseEntity>();
        Transaction dbTransaction = null;

        String query = ("FROM PersonprogramroutineexerciseEntity P WHERE P.exerciseId =" + id);

        try {
            dbTransaction = session.beginTransaction();
            personProgramRoutineExercise = session.createQuery(query).list();

        } catch (HibernateException error) {
            if (dbTransaction!=null) dbTransaction.rollback();
            error.printStackTrace();
        } finally {
            session.close();
        }

        return personProgramRoutineExercise.get(0);
    }

    @Override
    public void updatePersonProgramRoutineExercise(PersonprogramroutineexerciseEntity personProgramRoutineExercise) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.update(personProgramRoutineExercise);
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
    public Boolean deletePersonProgramRoutineExercise(PersonprogramroutineexerciseEntity personProgramRoutineExercise) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction dbTransaction = null;

        try {
            dbTransaction = session.beginTransaction();
            PersonprogramroutineexerciseEntity personProgramRoutineExerciseToDelete = (PersonprogramroutineexerciseEntity)session.get(PersonprogramroutineexerciseEntity.class, personProgramRoutineExercise.getExerciseId());
            session.delete(personProgramRoutineExerciseToDelete);
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
    public int addPersonProgramRoutineExercise(PersonprogramroutineexerciseEntity personProgramRoutineExercise) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        Integer personProgramRoutineExerciseId = null;
        try {
            tx = session.beginTransaction();
            personProgramRoutineExerciseId = (Integer) session.save(personProgramRoutineExercise);
            tx.commit();
            log.info("Added personProgramRoutineExercise: " + personProgramRoutineExercise + " with id of: " + personProgramRoutineExerciseId);
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }
        return personProgramRoutineExerciseId;
    }
}
