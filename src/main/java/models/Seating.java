package models;

import java.util.ArrayList;

public enum Seating {

    TABLETWO(2, "Seating for two"),
    TABLEFOUR(4, "Seating for four"),
    TABLESIX(6, "Seating for six");

    private int chairs;
    private String name;
    private ArrayList<Customer> diners;

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
    
}
