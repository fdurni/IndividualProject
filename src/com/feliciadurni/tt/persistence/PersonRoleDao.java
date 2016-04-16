package com.feliciadurni.tt.persistence;

import com.feliciadurni.tt.entity.PersonRole;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by felic on 4/16/2016.
 */
public class PersonRoleDao {

    private final Logger log = Logger.getLogger(this.getClass());

    public List<PersonRole> getAllRoles() {
        List<PersonRole> roles = new ArrayList<PersonRole>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        roles = (ArrayList<PersonRole>)session.createCriteria(PersonRole.class).list();
        return roles;
    }

    public PersonRole getPersonRole(Integer id) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        return (PersonRole)session.get(PersonRole.class, id);
    }

    public void updatePersonRole(PersonRole personRole) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.merge(personRole);
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

    public Boolean deletePersonRole(PersonRole personRole) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction dbTransaction = null;

        try {
            dbTransaction = session.beginTransaction();
            PersonRole personRoleToDelete = (PersonRole)session.get(PersonRole.class, personRole.getPersonId());
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

    public int addPersonRole(PersonRole personRole) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        Integer personId = null;
        try {
            tx = session.beginTransaction();
            personId = (Integer) session.save(personRole);
            tx.commit();
            log.info("Added personRole: " + personRole + " with id of: " + personId);
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }
        return personId;
    }
}
