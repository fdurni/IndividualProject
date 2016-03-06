package com.feliciadurni.tt.persistence;

import com.feliciadurni.tt.entity.ExercisesEntity;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by felic on 3/6/2016.
 */
public class ExercisesEntityDaoWithHibernate implements ExercisesEntityDao {

    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    public List<ExercisesEntity> getAllExercises() {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        List<ExercisesEntity> exercises = new ArrayList<ExercisesEntity>();
        Transaction dbTransaction = null;

        try {
            dbTransaction = session.beginTransaction();
            List exercisesInDB = session.createQuery("FROM ExercisesEntity").list();

            for (Iterator iterator = exercisesInDB.iterator(); iterator.hasNext();) {

                ExercisesEntity exercise = (ExercisesEntity) iterator.next();
                exercises.add(exercise);
            }

            dbTransaction.commit();

        } catch (HibernateException error) {
            if (dbTransaction!=null) dbTransaction.rollback();
            error.printStackTrace();
        } finally {
            session.close();
        }

        log.info("Number of exercises: " + exercises.size());

        return exercises;
    }

    public ExercisesEntity getExercise(Integer id) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        List<ExercisesEntity> exercise = new ArrayList<ExercisesEntity>();
        Transaction dbTransaction = null;

        String query = ("FROM ExercisesEntity E WHERE E.exerciseId =" + id);

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
    public void updateExercise(ExercisesEntity exercise) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.update(exercise);
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
    public Boolean deleteExercise(ExercisesEntity exercise) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction dbTransaction = null;

        try {
            dbTransaction = session.beginTransaction();
            ExercisesEntity exerciseToDelete = (ExercisesEntity)session.get(ExercisesEntity.class, exercise.getExerciseId());
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
    public int addExercise(ExercisesEntity exercise) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        Integer exerciseId = null;
        try {
            tx = session.beginTransaction();
            exerciseId = (Integer) session.save(exercise);
            tx.commit();
            log.info("Added exercise: " + exercise + " with id of: " + exerciseId);
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }
        return exerciseId;
    }
}