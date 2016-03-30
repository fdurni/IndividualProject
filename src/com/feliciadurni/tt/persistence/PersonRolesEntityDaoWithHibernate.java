package com.feliciadurni.tt.persistence;

import com.feliciadurni.tt.entity.PersonrolesEntity;
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
public class PersonRolesEntityDaoWithHibernate implements PersonRolesEntityDao {

    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    public List<PersonrolesEntity> getAllPersonRoles() {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        List<PersonrolesEntity> personRoles = new ArrayList<PersonrolesEntity>();
        Transaction dbTransaction = null;

        try {
            dbTransaction = session.beginTransaction();
            List personRolesInDB = session.createQuery("FROM PersonrolesEntity").list();

            for (Iterator iterator = personRolesInDB.iterator(); iterator.hasNext();) {

                PersonrolesEntity personRole = (PersonrolesEntity) iterator.next();
                personRoles.add(personRole);
            }

            dbTransaction.commit();

        } catch (HibernateException error) {
            if (dbTransaction!=null) dbTransaction.rollback();
            error.printStackTrace();
        } finally {
            session.close();
        }

        log.info("Number of personRoles: " + personRoles.size());

        return personRoles;
    }

    public PersonrolesEntity getPersonRole(String userName) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        List<PersonrolesEntity> personRole = new ArrayList<PersonrolesEntity>();
        Transaction dbTransaction = null;

        String query = ("FROM PersonrolesEntity P WHERE P.userName =" + userName);

        try {
            dbTransaction = session.beginTransaction();
            personRole = session.createQuery(query).list();

        } catch (HibernateException error) {
            if (dbTransaction!=null) dbTransaction.rollback();
            error.printStackTrace();
        } finally {
            session.close();
        }

        return personRole.get(0);
    }

    @Override
    public void updatePersonRole(PersonrolesEntity personRole) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.update(personRole);
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
    public Boolean deletePersonRole(PersonrolesEntity personRole) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction dbTransaction = null;

        try {
            dbTransaction = session.beginTransaction();
            PersonrolesEntity personRoleToDelete = (PersonrolesEntity)session.get(PersonrolesEntity.class, personRole.getUserName());
            session.delete(personRoleToDelete);
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
    public String addPersonRole(PersonrolesEntity personRole) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        String userName = null;
        try {
            tx = session.beginTransaction();
            userName = (String) session.save(personRole);
            tx.commit();
            log.info("Added personRole: " + personRole + " with userName of: " + userName);
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }
        return userName;
    }
}
