package com.feliciadurni.tt.persistence;

import com.feliciadurni.tt.entity.ProgramroutineexerciseEntity;
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
public class ProgramRoutineExerciseEntityDaoWithHibernate implements ProgramRoutineExerciseEntityDao {

    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    public List<ProgramroutineexerciseEntity> getAllProgramRoutineExercises() {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        List<ProgramroutineexerciseEntity> programRoutineExercises = new ArrayList<ProgramroutineexerciseEntity>();
        Transaction dbTransaction = null;

        try {
            dbTransaction = session.beginTransaction();
            List programRoutineExercisesInDB = session.createQuery("FROM ProgramroutineexerciseEntity").list();

            for (Iterator iterator = programRoutineExercisesInDB.iterator(); iterator.hasNext();) {

                ProgramroutineexerciseEntity exercise = (ProgramroutineexerciseEntity) iterator.next();
                programRoutineExercises.add(exercise);
            }

            dbTransaction.commit();

        } catch (HibernateException error) {
            if (dbTransaction!=null) dbTransaction.rollback();
            error.printStackTrace();
        } finally {
            session.close();
        }

        log.info("Number of programRoutineExercises: " + programRoutineExercises.size());

        return programRoutineExercises;
    }

    public ProgramroutineexerciseEntity getProgramRoutineExercise(Integer id) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        List<ProgramroutineexerciseEntity> exercise = new ArrayList<ProgramroutineexerciseEntity>();
        Transaction dbTransaction = null;

        String query = ("FROM ProgramroutineexerciseEntity E WHERE E.programRoutineExerciseId =" + id);

        try {
            dbTransaction = session.beginTransaction();
            exercise = session.createQuery(query).list();

        } catch (HibernateException error) {
            if (dbTransaction!=null) dbTransaction.rollback();
            error.printStackTrace();
        } finally {
            session.close();
        }

        return exercise.get(0);
    }

    @Override
    public void updateProgramRoutineExercise(ProgramroutineexerciseEntity programRoutineExercise) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.update(programRoutineExercise);
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
    public Boolean deleteProgramRoutineExercise(ProgramroutineexerciseEntity programRoutineExercise) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction dbTransaction = null;

        try {
            dbTransaction = session.beginTransaction();
            ProgramroutineexerciseEntity exerciseToDelete = (ProgramroutineexerciseEntity)session.get(ProgramroutineexerciseEntity.class, programRoutineExercise.getProgramRoutineExerciseId());
            session.delete(exerciseToDelete);
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
    public int addProgramRoutineExercise(ProgramroutineexerciseEntity programRoutineExercise) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        Integer programRoutineExerciseId = null;
        try {
            tx = session.beginTransaction();
            programRoutineExerciseId = (Integer) session.save(programRoutineExercise);
            tx.commit();
            log.info("Added programRoutineExercise: " + programRoutineExercise + " with id of: " + programRoutineExerciseId);
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }
        return programRoutineExerciseId;
    }
}
