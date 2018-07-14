package models;

import javax.persistence.*;
import javax.persistence.Table;
import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;

@Entity
@Table(name="restaurants")
public class Restaurant {

    private int id;
    private String name;
    private ArrayList<Seating> tables;
    private Till till;
    private List<Booking> bookings;
    private List<Customer> customer;

    public Restaurant(String name) {
        this.name = name;
        this.tables = new ArrayList<Seating>();
        this.till = new Till();
        this.bookings = new ArrayList<Booking>();
        makeTables();
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

    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToOne(mappedBy = "restaurant", fetch = FetchType.LAZY)
    public Till getTill() {
        return till;
    }

    public void setTill(Till till) {
        this.till = till;
    }

    @Enumerated(value= EnumType.STRING)
    public ArrayList<Seating> getTables() {
        return tables;
    }

    public void setTables(ArrayList<Seating> tables) {
        this.tables = tables;
    }

    public void makeTables(){
        Seating seating1 = Seating.TABLETWO;
        Seating seating2 = Seating.TABLETWO;
        Seating seating3 = Seating.TABLETWO;
        Seating seating4 = Seating.TABLETWO;
        Seating seating5 = Seating.TABLETWO;
        Seating seating6 = Seating.TABLETWO;
        Seating seating7 = Seating.TABLEFOUR;
        Seating seating8 = Seating.TABLEFOUR;
        Seating seating9 = Seating.TABLEFOUR;
        Seating seating10 = Seating.TABLEFOUR;
        Seating seating11 = Seating.TABLESIX;
        Seating seating12 = Seating.TABLESIX;
        this.tables = new ArrayList<Seating>(Arrays.asList(seating1, seating2, seating3, seating4,
                seating5, seating6, seating7, seating8, seating9, seating10, seating11, seating12));
    }

    @OneToMany(mappedBy = "restaurant", fetch = FetchType.LAZY)
    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    @OneToMany(mappedBy = "restaurant", fetch = FetchType.LAZY)
    public List<Customer> getCustomer() {
        return customer;
    }

    public void setCustomer(List<Customer> customer) {
        this.customer = customer;
    }


public void makeBooking(Booking booking){

            bookings.add(booking);
        }
}

