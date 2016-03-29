package com.feliciadurni.tt.persistence;

import com.feliciadurni.tt.entity.ProgramsEntity;
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
public class ProgramsEntityDaoWithHibernate implements ProgramsEntityDao {

    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    public List<ProgramsEntity> getAllPrograms() {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        List<ProgramsEntity> programs = new ArrayList<ProgramsEntity>();
        Transaction dbTransaction = null;

        try {
            dbTransaction = session.beginTransaction();
            List programsInDB = session.createQuery("FROM ProgramsEntity").list();

            for (Iterator iterator = programsInDB.iterator(); iterator.hasNext();) {

                ProgramsEntity program = (ProgramsEntity) iterator.next();
                programs.add(program);
            }

            dbTransaction.commit();

        } catch (HibernateException error) {
            if (dbTransaction!=null) dbTransaction.rollback();
            error.printStackTrace();
        } finally {
            session.close();
        }

        log.info("Number of programs: " + programs.size());

        return programs;
    }

    public ProgramsEntity getProgram(Integer id) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        List<ProgramsEntity> program = new ArrayList<ProgramsEntity>();
        Transaction dbTransaction = null;

        String query = ("FROM ProgramsEntity E WHERE E.programId =" + id);

        try {
            dbTransaction = session.beginTransaction();
            program = session.createQuery(query).list();

        } catch (HibernateException error) {
            if (dbTransaction!=null) dbTransaction.rollback();
            error.printStackTrace();
        } finally {
            session.close();
        }

        return program.get(0);
    }

    @Override
    public void updateProgram(ProgramsEntity program) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.update(program);
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
    public Boolean deleteProgram(ProgramsEntity program) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction dbTransaction = null;

        try {
            dbTransaction = session.beginTransaction();
            ProgramsEntity programToDelete = (ProgramsEntity)session.get(ProgramsEntity.class, program.getProgramId());
            session.delete(programToDelete);
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
    public int addProgram(ProgramsEntity program) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        Integer programId = null;
        try {
            tx = session.beginTransaction();
            programId = (Integer) session.save(program);
            tx.commit();
            log.info("Added program: " + program + " with id of: " + programId);
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }
        return programId;
    }
}
