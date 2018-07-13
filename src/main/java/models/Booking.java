package models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.GregorianCalendar;

public class Booking {

    private int id;
    private GregorianCalendar dateTime;
    private int capacity;
    private Customer customer;
    private Seating seating;
    private int pricePerHead;
    private double discountApplied;
    private Restaurant restaurant;

    public Booking() {
    }


    public Booking(GregorianCalendar dateTime, int capacity, Customer customer, Seating seating) {
        this.dateTime = dateTime;
        this.capacity = capacity;
        this.customer = customer;
        this.seating = seating;
        this.pricePerHead = 50;
        this.discountApplied = 35;

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

    @Column(name = "date_and_time")
    public GregorianCalendar getDateTime() {
        return dateTime;
    }

    public void setDateTime(GregorianCalendar dateTime) {
        this.dateTime = dateTime;
    }

    @Column(name = "capacity")
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @ManyToMany
    @JoinTable(name = "customer_booking",
            joinColumns = {@JoinColumn(name = "booking_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "customer_id", nullable = false, updatable = false)})
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Enumerated(value = EnumType.STRING)
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
    @JoinColumn(name="restuarant_id", nullable = false)
    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public void checkAvailability(GregorianCalendar dateTime, int capacity){

    }

}
