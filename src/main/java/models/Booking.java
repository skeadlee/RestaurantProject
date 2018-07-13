package models;

import java.util.GregorianCalendar;

public class Booking {

    private int id;
    private GregorianCalendar dateTime;
    private int capacity;
    private Customer customer;
    private Table table;
    private int pricePerHead;
    private double discountApplied;

    public Booking() {
    }

    public Booking(GregorianCalendar dateTime, int capacity, Customer customer, Table table) {
        this.dateTime = dateTime;
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

    public GregorianCalendar getDateTime() {
        return dateTime;
    }

    public void setDateTime(GregorianCalendar dateTime) {
        this.dateTime = dateTime;
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
