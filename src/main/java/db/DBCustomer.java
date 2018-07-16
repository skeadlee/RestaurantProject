package db;

import models.Booking;
import models.Customer;
import models.Restaurant;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.awt.print.Book;
import java.util.List;

import static db.DBHelper.getList;

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

    public static List<Booking> getBookingsForCustomer(Customer customer){
        List<Booking> bookings = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try{
        Criteria cr = session.createCriteria(Booking.class);
        cr.add(Restrictions.eq("customer", customer));
        bookings = cr.list();

    } catch (HibernateException ex) {
        ex.printStackTrace();
    } finally {
        session.close();
    } return bookings;
    }


}
