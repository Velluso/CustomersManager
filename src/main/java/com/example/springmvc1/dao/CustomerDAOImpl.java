package com.example.springmvc1.dao;

import com.example.springmvc1.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;


@Repository
public class CustomerDAOImpl implements CustomerDAO {


    @Override
    public List<Customer> getCustomers() {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Customer.class)
                .buildSessionFactory();


        Session currentSession = sessionFactory.getCurrentSession();

        List<Customer> customers = null;

        try {
            currentSession.beginTransaction();

            // facciamo una query
            String hql = "from Customer";

            customers = currentSession
                    .createQuery(hql, Customer.class)
                    .getResultList();


            currentSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessionFactory.close();
        }


        return customers;
    }


    @Override
    public void saveCustomer(Customer theCustomer) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Customer.class)
                .buildSessionFactory();


        Session currentSession = sessionFactory.getCurrentSession();


        try {
            currentSession.beginTransaction();

            currentSession.saveOrUpdate(theCustomer);

            currentSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessionFactory.close();
        }


    }

    @Override
    public Customer getCustomer(int id) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Customer.class)
                .buildSessionFactory();


        Session currentSession = sessionFactory.getCurrentSession();

        Customer theCustomer = null;

        try {
            currentSession.beginTransaction();


            theCustomer = currentSession.get(Customer.class, id);


            currentSession.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            sessionFactory.close();
        }


        return theCustomer;


    }

    @Override
    public Customer deleteCustomer(int id) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Customer.class)
                .buildSessionFactory();


        Session currentSession = sessionFactory.getCurrentSession();


        try {
            currentSession.beginTransaction();

            Query theQuery =
                    currentSession.createQuery("delete FROM Customer WHERE id=:customerId");

            theQuery.setParameter("customerId", id);

            theQuery.executeUpdate();


            currentSession.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            sessionFactory.close();
        }

        return null;
    }
}



