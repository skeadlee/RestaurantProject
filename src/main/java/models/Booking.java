package models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;

import java.util.List;

@Entity
@Table(name="bookings")
public class Booking {

    private int id;
    private int capacity;
    private Customer customer;
    private Seating seating;
    private int pricePerHead;
    private double discountApplied;
    private Restaurant restaurant;

    public Booking() {
    }


    public Booking(int capacity, Customer customer, Seating seating, Restaurant restaurant) {
        this.capacity = capacity;
        this.customer = customer;
        this.seating = seating;
        this.pricePerHead = 50;
        this.discountApplied = 35;
        this.restaurant = restaurant;


    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Column(name = "capacity")
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @ManyToOne
    @JoinColumn(name = "customer_id")
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @ManyToOne
    @JoinColumn(name = "seating_id")
    public Seating getSeating() {
        return seating;
    }

    public void setSeating(Seating seating) {
        this.seating = seating;
    }

    @Column(name = "price_per_head")
    public int getPricePerHead() {
        return pricePerHead;
    }

    public void setPricePerHead(int pricePerHead) {
        this.pricePerHead = pricePerHead;
    }

    @Column(name = "discount_applied")
    public double getDiscountApplied() {
        return discountApplied;
    }

    public void setDiscountApplied(double discountApplied) {
        this.discountApplied = discountApplied;
    }

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    //public void checkAvailability(GregorianCalendar dateTime, int capacity) {

    //}

    public void takeBooking(int party, Customer customer, Seating table) {
        if (table.getChairs() <= party) {
            table.addCustomer(customer);
        }
    }
}
