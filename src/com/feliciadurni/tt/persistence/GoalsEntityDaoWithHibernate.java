package com.feliciadurni.tt.persistence;

import com.feliciadurni.tt.entity.GoalsEntity;
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
public class GoalsEntityDaoWithHibernate implements GoalsEntityDao {

    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    public List<GoalsEntity> getAllGoals() {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        List<GoalsEntity> goals = new ArrayList<GoalsEntity>();
        Transaction dbTransaction = null;

        try {
            dbTransaction = session.beginTransaction();
            List PersonGoalsInDB = session.createQuery("FROM GoalsEntity").list();

            for (Iterator iterator = PersonGoalsInDB.iterator(); iterator.hasNext();) {

                GoalsEntity goal = (GoalsEntity) iterator.next();
                goals.add(goal);
            }

            dbTransaction.commit();

        } catch (HibernateException error) {
            if (dbTransaction!=null) dbTransaction.rollback();
            error.printStackTrace();
        } finally {
            session.close();
        }

        log.info("Number of goals: " + goals.size());

        return goals;
    }

    public GoalsEntity getGoal(Integer id) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        List<GoalsEntity> goal = new ArrayList<GoalsEntity>();
        Transaction dbTransaction = null;

        String query = ("FROM GoalsEntity P WHERE P.goalId =" + id);

        try {
            dbTransaction = session.beginTransaction();
            goal = session.createQuery(query).list();

        } catch (HibernateException error) {
            if (dbTransaction!=null) dbTransaction.rollback();
            error.printStackTrace();
        } finally {
            session.close();
        }

        return goal.get(0);
    }

    @Override
    public void updateGoal(GoalsEntity goal) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.update(goal);
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
    public Boolean deleteGoal(GoalsEntity goal) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction dbTransaction = null;

        try {
            dbTransaction = session.beginTransaction();
            GoalsEntity personGoalToDelete = (GoalsEntity)session.get(GoalsEntity.class, goal.getGoalId());
            session.delete(personGoalToDelete);
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
    public int addGoal(GoalsEntity goal) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        Integer goalId = null;
        try {
            tx = session.beginTransaction();
            goalId = (Integer) session.save(goal);
            tx.commit();
            log.info("Added goal: " + goal + " with id of: " + goalId);
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }
        return goalId;
    }
}
