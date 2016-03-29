package com.feliciadurni.tt.persistence;

import com.feliciadurni.tt.entity.PersonalrecordEntity;
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
public class PersonalRecordEntityDaoWithHibernate implements PersonalRecordEntityDao {

    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    public List<PersonalrecordEntity> getAllPersonalRecords() {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        List<PersonalrecordEntity> personalRecords = new ArrayList<PersonalrecordEntity>();
        Transaction dbTransaction = null;

        try {
            dbTransaction = session.beginTransaction();
            List personalRecordsInDB = session.createQuery("FROM PersonalrecordEntity").list();

            for (Iterator iterator = personalRecordsInDB.iterator(); iterator.hasNext();) {

                PersonalrecordEntity personalRecord = (PersonalrecordEntity) iterator.next();
                personalRecords.add(personalRecord);
            }

            dbTransaction.commit();

        } catch (HibernateException error) {
            if (dbTransaction!=null) dbTransaction.rollback();
            error.printStackTrace();
        } finally {
            session.close();
        }

        log.info("Number of personalRecords: " + personalRecords.size());

        return personalRecords;
    }

    public PersonalrecordEntity getPersonalRecord(Integer id) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        List<PersonalrecordEntity> personalRecord = new ArrayList<PersonalrecordEntity>();
        Transaction dbTransaction = null;

        String query = ("FROM PersonalrecordEntity P WHERE P.personalRecordId =" + id);

        try {
            dbTransaction = session.beginTransaction();
            personalRecord = session.createQuery(query).list();

        } catch (HibernateException error) {
            if (dbTransaction!=null) dbTransaction.rollback();
            error.printStackTrace();
        } finally {
            session.close();
        }

        return personalRecord.get(0);
    }

    @Override
    public void updatePersonalRecord(PersonalrecordEntity personalRecord) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.update(personalRecord);
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
    public Boolean deletePersonalRecord(PersonalrecordEntity personalRecord) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction dbTransaction = null;

        try {
            dbTransaction = session.beginTransaction();
            PersonalrecordEntity personalRecordToDelete = (PersonalrecordEntity)session.get(PersonalrecordEntity.class, personalRecord.getPersonalRecordId());
            session.delete(personalRecordToDelete);
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
    public int addPersonalRecord(PersonalrecordEntity personalRecord) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        Integer personalRecordId = null;
        try {
            tx = session.beginTransaction();
            personalRecordId = (Integer) session.save(personalRecord);
            tx.commit();
            log.info("Added personalRecord: " + personalRecord + " with id of: " + personalRecordId);
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }
        return personalRecordId;
    }
}
