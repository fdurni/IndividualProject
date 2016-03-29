package com.feliciadurni.tt.persistence;

import com.feliciadurni.tt.entity.ProgramroutinesEntity;
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
public class ProgramRoutinesEntityDaoWithHibernate implements ProgramRoutinesEntityDao {

    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    public List<ProgramroutinesEntity> getAllProgramRoutines() {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        List<ProgramroutinesEntity> programRoutines = new ArrayList<ProgramroutinesEntity>();
        Transaction dbTransaction = null;

        try {
            dbTransaction = session.beginTransaction();
            List programRoutinesInDB = session.createQuery("FROM ProgramroutinesEntity").list();

            for (Iterator iterator = programRoutinesInDB.iterator(); iterator.hasNext();) {

                ProgramroutinesEntity personGoal = (ProgramroutinesEntity) iterator.next();
                programRoutines.add(personGoal);
            }

            dbTransaction.commit();

        } catch (HibernateException error) {
            if (dbTransaction!=null) dbTransaction.rollback();
            error.printStackTrace();
        } finally {
            session.close();
        }

        log.info("Number of programRoutines: " + programRoutines.size());

        return programRoutines;
    }

    public ProgramroutinesEntity getProgramRoutine(Integer id) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        List<ProgramroutinesEntity> programRoutine = new ArrayList<ProgramroutinesEntity>();
        Transaction dbTransaction = null;

        String query = ("FROM ProgramroutinesEntity P WHERE P.programRoutinesId =" + id);

        try {
            dbTransaction = session.beginTransaction();
            programRoutine = session.createQuery(query).list();

        } catch (HibernateException error) {
            if (dbTransaction!=null) dbTransaction.rollback();
            error.printStackTrace();
        } finally {
            session.close();
        }

        return programRoutine.get(0);
    }

    @Override
    public void updateProgramRoutine(ProgramroutinesEntity personGoal) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.update(personGoal);
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
    public Boolean deleteProgramRoutine(ProgramroutinesEntity personGoal) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction dbTransaction = null;

        try {
            dbTransaction = session.beginTransaction();
            ProgramroutinesEntity programRoutineToDelete = (ProgramroutinesEntity)session.get(ProgramroutinesEntity.class, personGoal.getProgramRoutinesId());
            session.delete(programRoutineToDelete);
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
    public int addProgramRoutine(ProgramroutinesEntity programRoutine) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        Integer programRoutinesId = null;
        try {
            tx = session.beginTransaction();
            programRoutinesId = (Integer) session.save(programRoutine);
            tx.commit();
            log.info("Added programRoutine: " + programRoutine + " with id of: " + programRoutinesId);
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }
        return programRoutinesId;
    }
}
