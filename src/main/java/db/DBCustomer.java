package db;

import models.Customer;
import models.Restaurant;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBCustomer {


    private static Session session;
    private static Transaction transaction;

    public static List<Customer> orderByLoyaltyPoints(){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Customer> customers = null;
        try {
            Criteria cr = session.createCriteria(Customer.class);
            cr.addOrder(Order.desc("points"));
            customers = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return customers;
    }


    public static Customer getCustomer(int customerId){
        session = HibernateUtil.getSessionFactory().openSession();
        Customer customer = null;

        try {
            Criteria cr = session.createCriteria(Customer.class);
            cr.add(Restrictions.eq("id", customerId));
            customer = (Customer)cr.uniqueResult();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return customer;
    }


}
