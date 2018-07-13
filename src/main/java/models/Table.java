package models;

import java.util.ArrayList;

public enum Table {

    TABLETWO(2, "Table for two"),
    TABLEFOUR(4, "Table for four"),
    TABLESIX(6, "Table for six");

    private int chairs;
    private String name;
    private ArrayList<Customer> diners;

    Table(int chairs, String name) {

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
    
}
