package models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;

public class Customer {

    private int id;
    private String name;
    private int wallet;
    private int loyaltyCard;
    private ArrayList<Booking> bookings;
    private Restaurant restaurant;

    public Customer(){}

    public Customer(String name, int wallet) {
        this.name = name;
        this.wallet = wallet;
        this.loyaltyCard = 0;
        this.bookings = new ArrayList<Booking>();
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

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "wallet")
    public int getWallet() {
        return wallet;
    }

    public void setWallet(int wallet) {
        this.wallet = wallet;
    }

    @Column(name = "loyalty_card_number")
    public int getLoyaltyCard() {
        return loyaltyCard;
    }

    public void setLoyaltyCard(int loyaltyCard) {
        this.loyaltyCard = loyaltyCard;
    }

    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @ManyToMany
    @JoinTable(name = "customer_booking",
            joinColumns = {@JoinColumn(name = "customer_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "booking_id", nullable = false, updatable = false)})
    public ArrayList<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(ArrayList<Booking> bookings) {
        this.bookings = bookings;
    }

    @ManyToOne
    @JoinColumn(name = "restuarant_id", nullable = false)
    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }


    public void addLoyaltyPoints(int i){
        setLoyaltyCard(loyaltyCard += i);
    }

    public void addBookings(Booking booking){
        this.getBookings().add(booking);
    }
}
