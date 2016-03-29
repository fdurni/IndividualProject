package com.feliciadurni.tt.persistence;

import com.feliciadurni.tt.entity.RoutinesEntity;
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
public class RoutinesEntityDaoWithHibernate implements RoutinesEntityDao {

    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    public List<RoutinesEntity> getAllRoutines() {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        List<RoutinesEntity> routines = new ArrayList<RoutinesEntity>();
        Transaction dbTransaction = null;

        try {
            dbTransaction = session.beginTransaction();
            List routinesInDB = session.createQuery("FROM RoutinesEntity").list();

            for (Iterator iterator = routinesInDB.iterator(); iterator.hasNext();) {

                RoutinesEntity routine = (RoutinesEntity) iterator.next();
                routines.add(routine);
            }

            dbTransaction.commit();

        } catch (HibernateException error) {
            if (dbTransaction!=null) dbTransaction.rollback();
            error.printStackTrace();
        } finally {
            session.close();
        }

        log.info("Number of routines: " + routines.size());

        return routines;
    }

    public RoutinesEntity getRoutine(Integer id) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        List<RoutinesEntity> routine = new ArrayList<RoutinesEntity>();
        Transaction dbTransaction = null;

        String query = ("FROM RoutinesEntity E WHERE E.routineId =" + id);

        try {
            dbTransaction = session.beginTransaction();
            routine = session.createQuery(query).list();

        } catch (HibernateException error) {
            if (dbTransaction!=null) dbTransaction.rollback();
            error.printStackTrace();
        } finally {
            session.close();
        }

        return routine.get(0);
    }

    @Override
    public void updateRoutine(RoutinesEntity routine) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.update(routine);
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
    public Boolean deleteRoutine(RoutinesEntity routine) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction dbTransaction = null;

        try {
            dbTransaction = session.beginTransaction();
            RoutinesEntity routineToDelete = (RoutinesEntity)session.get(RoutinesEntity.class, routine.getRoutineId());
            session.delete(routineToDelete);
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
    public int addRoutine(RoutinesEntity routine) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        Integer routineId = null;
        try {
            tx = session.beginTransaction();
            routineId = (Integer) session.save(routine);
            tx.commit();
            log.info("Added routine: " + routine + " with id of: " + routineId);
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }
        return routineId;
    }
}
