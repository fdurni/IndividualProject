package com.feliciadurni.tt.persistence;

import com.feliciadurni.tt.entity.Exercise;
import com.feliciadurni.tt.entity.RoutineExercise;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by felic on 4/16/2016.
 */
public class RoutineExerciseDao {

    private final Logger log = Logger.getLogger(this.getClass());

    public List<RoutineExercise> getAllRoutineExercises() {
        List<RoutineExercise> routineExercises = new ArrayList<RoutineExercise>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        routineExercises = (ArrayList<RoutineExercise>)session.createCriteria(RoutineExercise.class).list();
        return routineExercises;
    }

    public RoutineExercise getRoutineExercise(Integer id) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        return (RoutineExercise)session.get(RoutineExercise.class, id);
    }

    public void updateRoutineExercise(RoutineExercise routineExercise) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.merge(routineExercise);
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

    public Boolean deleteRoutineExercise(RoutineExercise routineExercise) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction dbTransaction = null;

        try {
            dbTransaction = session.beginTransaction();
            RoutineExercise routineExerciseToDelete = (RoutineExercise)session.get(RoutineExercise.class, routineExercise.getRoutineexerciseId());
            session.delete(routineExerciseToDelete);
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

    public int addRoutineExercise(RoutineExercise routineExercise) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        Integer routineExerciseId = null;
        try {
            tx = session.beginTransaction();
            routineExerciseId = (Integer) session.save(routineExercise);
            tx.commit();
            log.info("Added routineExercise: " + routineExercise + " with id of: " + routineExerciseId);
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }
        return routineExerciseId;
    }
}
