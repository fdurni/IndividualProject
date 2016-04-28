package com.feliciadurni.tt.persistence;

import com.feliciadurni.tt.entity.Exercise;
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
public class ExerciseDao {

    private final Logger log = Logger.getLogger(this.getClass());

    public List<Exercise> getAllExercises() {
        List<Exercise> exercises = new ArrayList<Exercise>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        exercises = (ArrayList<Exercise>)session.createCriteria(Exercise.class).list();
        return exercises;
    }

    public Exercise getExercise(Integer id) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        return (Exercise)session.get(Exercise.class, id);
    }

    public Exercise getExerciseByName(String exerciseName) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();

        Criteria crit = session.createCriteria(Exercise.class);
        crit.add( Restrictions.eq("exerciseName",exerciseName) );
        Exercise exercise = (Exercise)crit.uniqueResult();

        return exercise;
    }

    public void updateExercise(Exercise exercise) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.merge(exercise);
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

    public Boolean deleteExercise(Exercise routine) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction dbTransaction = null;

        try {
            dbTransaction = session.beginTransaction();
            Exercise exerciseToDelete = (Exercise)session.get(Exercise.class, routine.getExerciseId());
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

    public int addExercise(Exercise exercise) {

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
