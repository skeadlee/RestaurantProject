package db;

import models.Booking;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.Calendar;
import java.util.List;

public class DBBooking {

    private static Session session;
    private static Transaction transaction;

    public static List<Booking> getBookingByDate(Calendar timeDate){
        List<Booking> bookings = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try{
            Criteria cr = session.createCriteria(Booking.class);
            cr.add(Restrictions.eq("timeDate", timeDate));
            bookings = cr.list();
            } catch (HibernateException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        } return bookings;
    }

        }
