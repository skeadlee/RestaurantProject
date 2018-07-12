package models;

import java.util.ArrayList;

public class Customer {

    private int id;
    private String name;
    private int wallet;
    private int loyaltyCard;
    private ArrayList<Booking> bookings;

    public Customer(){}

    public Customer(String name, int wallet) {
        this.name = name;
        this.wallet = wallet;
        this.loyaltyCard = 0;
        this.bookings = new ArrayList<Booking>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWallet() {
        return wallet;
    }

    public void setWallet(int wallet) {
        this.wallet = wallet;
    }

    public int getLoyaltyCard() {
        return loyaltyCard;
    }

    public void setLoyaltyCard(int loyaltyCard) {
        this.loyaltyCard = loyaltyCard;
    }

    public ArrayList<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(ArrayList<Booking> bookings) {
        this.bookings = bookings;
    }
}
