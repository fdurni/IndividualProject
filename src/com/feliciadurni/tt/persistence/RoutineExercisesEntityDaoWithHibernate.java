package com.feliciadurni.tt.persistence;

import com.feliciadurni.tt.entity.RoutineexercisesEntity;
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
public class RoutineExercisesEntityDaoWithHibernate implements RoutineExercisesEntityDao {

    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    public List<RoutineexercisesEntity> getAllRoutineExercises() {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        List<RoutineexercisesEntity> routineExercises = new ArrayList<RoutineexercisesEntity>();
        Transaction dbTransaction = null;

        try {
            dbTransaction = session.beginTransaction();
            List routineExercisesInDB = session.createQuery("FROM RoutineexercisesEntity").list();

            for (Iterator iterator = routineExercisesInDB.iterator(); iterator.hasNext();) {

                RoutineexercisesEntity person = (RoutineexercisesEntity) iterator.next();
                routineExercises.add(person);
            }

            dbTransaction.commit();

        } catch (HibernateException error) {
            if (dbTransaction!=null) dbTransaction.rollback();
            error.printStackTrace();
        } finally {
            session.close();
        }

        log.info("Number of routineExercises: " + routineExercises.size());

        return routineExercises;
    }

    public RoutineexercisesEntity getRoutineExercise(Integer id) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        List<RoutineexercisesEntity> routineExercise = new ArrayList<RoutineexercisesEntity>();
        Transaction dbTransaction = null;

        String query = ("FROM RoutineexercisesEntity P WHERE P.routineExercisesId =" + id);

        try {
            dbTransaction = session.beginTransaction();
            routineExercise = session.createQuery(query).list();

        } catch (HibernateException error) {
            if (dbTransaction!=null) dbTransaction.rollback();
            error.printStackTrace();
        } finally {
            session.close();
        }

        return routineExercise.get(0);
    }

    @Override
    public void updateRoutineExercise(RoutineexercisesEntity routineExercise) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.update(routineExercise);
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
    public Boolean deleteRoutineExercise(RoutineexercisesEntity routineExercise) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction dbTransaction = null;

        try {
            dbTransaction = session.beginTransaction();
            RoutineexercisesEntity routineExerciseToDelete = (RoutineexercisesEntity)session.get(RoutineexercisesEntity.class, routineExercise.getRoutineExercisesId());
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

    @Override
    public int addRoutineExercise(RoutineexercisesEntity routineExercise) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        Integer routineExercisesId = null;
        try {
            tx = session.beginTransaction();
            routineExercisesId = (Integer) session.save(routineExercise);
            tx.commit();
            log.info("Added routineExercise: " + routineExercise + " with id of: " + routineExercisesId);
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }
        return routineExercisesId;
    }
}
