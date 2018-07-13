package models;

import java.util.GregorianCalendar;

public class Booking {

    private int id;
    private int bookingTime;
    private int capacity;
    private Customer customer;
    private Table table;
    private int pricePerHead;
    private double discountApplied;

    public Booking() {
    }

    public Booking(int bookingTime, int capacity, Customer customer, Table table) {
        this.bookingTime = bookingTime;
        this.capacity = capacity;
        this.customer = customer;
        this.table = table;
        this.pricePerHead = 50;
        this.discountApplied = 35;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(int bookingTime) {
        this.bookingTime = bookingTime;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public int getPricePerHead() {
        return pricePerHead;
    }

    public void setPricePerHead(int pricePerHead) {
        this.pricePerHead = pricePerHead;
    }

    public double getDiscountApplied() {
        return discountApplied;
    }

    public void setDiscountApplied(double discountApplied) {
        this.discountApplied = discountApplied;
    }


}
