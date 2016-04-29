package com.feliciadurni.tt.persistence;

import com.feliciadurni.tt.entity.Program;
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
public class ProgramDao {

    private final Logger log = Logger.getLogger(this.getClass());

    public List<Program> getAllPrograms() {
        List<Program> programs = new ArrayList<Program>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        programs = (ArrayList<Program>)session.createCriteria(Program.class).list();
        return programs;
    }

    public Program getProgram(Integer id) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        return (Program)session.get(Program.class, id);
    }

    public Program getProgramByName(String name) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();

        Criteria crit = session.createCriteria(Program.class);
        crit.add( Restrictions.eq("programName",name) );
        List<Program> program = crit.list();

        return program.get(0);
    }

    public List<Program> getRoutines(Integer id) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Criteria c = session.createCriteria(Program.class, "program");
        c.createAlias("program.routines", "routine");
        c.add(Restrictions.eq("routine.routineId", id));
        c.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);

        List programs = c.list();

        return programs;
    }

    public void updateProgram(Program program) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.merge(program);
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

    public Boolean deleteProgram(Program program) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction dbTransaction = null;

        try {
            dbTransaction = session.beginTransaction();
            Program programToDelete = (Program)session.get(Program.class, program.getProgramId());
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

    public int addProgram(Program program) {

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
