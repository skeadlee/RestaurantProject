package models;

import java.util.ArrayList;
import java.util.Arrays;

public enum Table {

    TABLETWO(2, "Table for two"),
    TABLEFOUR(4, "Table for four"),
    TABLESIX(6, "Table for six");

    private int chairs;
    private String name;
    private ArrayList<Customer> diners;
    private ArrayList<TimeSlot> timeSlots;


    Table(int chairs, String name) {

        this.chairs = chairs;
        this.name = name;
        this.diners = new ArrayList<Customer>();
        this.timeSlots = new ArrayList<>(Arrays.asList(TimeSlot.SEVEN, TimeSlot.SEVENTHIRTY, TimeSlot.EIGHT, TimeSlot.EIGHTTHIRTY,
        TimeSlot.NINE, TimeSlot.NINETHIRTY, TimeSlot.TEN, TimeSlot.TENTHIRTY, TimeSlot.ELEVEN));

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
