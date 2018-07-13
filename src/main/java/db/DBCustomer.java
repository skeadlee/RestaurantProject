package db;

import models.Customer;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

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


}
