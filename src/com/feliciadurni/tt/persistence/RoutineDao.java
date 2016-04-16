package com.feliciadurni.tt.persistence;

import com.feliciadurni.tt.entity.Routine;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by felic on 4/16/2016.
 */
public class RoutineDao {

    private final Logger log = Logger.getLogger(this.getClass());

    public List<Routine> getAllRoutines() {
        List<Routine> routines = new ArrayList<Routine>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        routines = (ArrayList<Routine>)session.createCriteria(Routine.class).list();
        return routines;
    }

    public Routine getRoutine(Integer id) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        return (Routine)session.get(Routine.class, id);
    }

    public void updateRoutine(Routine routine) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.merge(routine);
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

    public Boolean deleteRoutine(Routine routine) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction dbTransaction = null;

        try {
            dbTransaction = session.beginTransaction();
            Routine routineToDelete = (Routine)session.get(Routine.class, routine.getRoutineId());
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

    public int addRoutine(Routine routine) {

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
