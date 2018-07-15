package db;

import models.Restaurant;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class DBRestaurant {

    private static Session session;


    public static Restaurant getRestaurant(String restaurantName){
        session = HibernateUtil.getSessionFactory().openSession();
        Restaurant restaurant = null;

        try {
            Criteria cr = session.createCriteria(Restaurant.class);
            cr.add(Restrictions.eq("name", restaurantName));
            restaurant = (Restaurant)cr.uniqueResult();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return restaurant;
    }
}
