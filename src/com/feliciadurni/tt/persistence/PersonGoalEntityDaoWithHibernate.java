package com.feliciadurni.tt.persistence;

import com.feliciadurni.tt.entity.PersongoalEntity;
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
public class PersonGoalEntityDaoWithHibernate implements PersonGoalEntityDao {

    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    public List<PersongoalEntity> getAllPersonGoals() {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        List<PersongoalEntity> personGoals = new ArrayList<PersongoalEntity>();
        Transaction dbTransaction = null;

        try {
            dbTransaction = session.beginTransaction();
            List PersonGoalsInDB = session.createQuery("FROM PersongoalEntity").list();

            for (Iterator iterator = PersonGoalsInDB.iterator(); iterator.hasNext();) {

                PersongoalEntity personGoal = (PersongoalEntity) iterator.next();
                personGoals.add(personGoal);
            }

            dbTransaction.commit();

        } catch (HibernateException error) {
            if (dbTransaction!=null) dbTransaction.rollback();
            error.printStackTrace();
        } finally {
            session.close();
        }

        log.info("Number of PersonGoals: " + personGoals.size());

        return personGoals;
    }

    public PersongoalEntity getPersonGoal(Integer id) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        List<PersongoalEntity> personGoal = new ArrayList<PersongoalEntity>();
        Transaction dbTransaction = null;

        String query = ("FROM PersongoalEntity P WHERE P.personGoalId =" + id);

        try {
            dbTransaction = session.beginTransaction();
            personGoal = session.createQuery(query).list();

        } catch (HibernateException error) {
            if (dbTransaction!=null) dbTransaction.rollback();
            error.printStackTrace();
        } finally {
            session.close();
        }

        return personGoal.get(0);
    }

    @Override
    public void updatePersonGoal(PersongoalEntity personGoal) {

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
    public Boolean deletePersonGoal(PersongoalEntity personGoal) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction dbTransaction = null;

        try {
            dbTransaction = session.beginTransaction();
            PersongoalEntity personGoalToDelete = (PersongoalEntity)session.get(PersongoalEntity.class, personGoal.getPersonGoalId());
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
    public int addPersonGoal(PersongoalEntity personGoal) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        Integer personGoalId = null;
        try {
            tx = session.beginTransaction();
            personGoalId = (Integer) session.save(personGoal);
            tx.commit();
            log.info("Added personGoal: " + personGoal + " with id of: " + personGoalId);
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }
        return personGoalId;
    }
}
