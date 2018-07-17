package db;

import models.Booking;
import models.Customer;
import models.Restaurant;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.awt.print.Book;
import java.util.Calendar;
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


    //We'll need to add some sort of history of visits
    //Then check through this code to make sure it actually does what we think it should do!
    public static List<Customer> orderByFrequency(){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Customer> customers = null;
        try {
            Criteria cr = session.createCriteria(Customer.class);
            cr.createAlias("bookings", "bookings");
            //cr.createAlias("bookings.id", "frequency");
            cr.setProjection(Projections.projectionList()
                    .add(Projections.groupProperty("name"))
                    .add(Projections.count("bookings.id").as("frequency")));
            cr.addOrder(Order.desc("frequency"));
            customers = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return customers;
    }

    public static List<Customer> getCustomersByDate(Calendar timeDate){
        List<Customer> customers = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try{
            Criteria cr = session.createCriteria(Booking.class);
            cr.add(Restrictions.ge("timeDate", timeDate));
            customers = cr.list();
        } catch (HibernateException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        } return customers;
    }



}
