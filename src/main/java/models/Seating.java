package models;

import javax.persistence.*;
import java.util.ArrayList;

public enum Seating {

    TABLETWO(2, "Seating for two"),
    TABLEFOUR(4, "Seating for four"),
    TABLESIX(6, "Seating for six");

    private int chairs;
    private String name;
    private ArrayList<Customer> diners;
    private Restaurant restaurant;
    private Booking booking;

    Seating(int chairs, String name) {

        this.chairs = chairs;
        this.name = name;
        this.diners = new ArrayList<Customer>();
    }

    public int getChairs() {
        return chairs;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getDiners() {
        return diners;
    }

    public void addCustomer(Customer customers){
        this.diners.add(customers);
    }

    //@ManyToOne
   // @JoinColumn(name = "restaurant_id", nullable = false)
    @Enumerated(value = EnumType.STRING)
    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    //@OneToMany(mappedBy = "seating", fetch = FetchType.LAZY)
    @Enumerated(value = EnumType.STRING)
    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
}
