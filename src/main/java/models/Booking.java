package models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

@Entity
@Table(name="bookings")
public class Booking {

    private int id;
    private int capacity;
    private List<Customer> customers;
    private Seating seating;
    private int pricePerHead;
    private double discountApplied;
    private Restaurant restaurant;

    public Booking() {
    }


    public Booking(int capacity, Customer customer, Seating seating) {
        this.capacity = capacity;
        this.customers = new ArrayList<>();
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

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public void addCustomers(Customer customer){ this.customers.add(customer);}


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
    @JoinColumn(name = "restuarant_id")
    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public void checkAvailability(GregorianCalendar dateTime, int capacity) {

    }

    public void takeBooking(int party, Customer customer, Seating table) {
        if (table.getChairs() <= party) {
            table.addCustomer(customer);
        }
    }
}
