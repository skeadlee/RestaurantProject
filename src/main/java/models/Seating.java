package models;

import javax.persistence.*;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name="seating")
public class Seating {

    private int id;
    private int chairs;
    private String name;
    //private List<Customer> diners;
    private Restaurant restaurant;
    private List<Booking> booking;

    public Seating() {
    }

    public Seating(int chairs, String name, Restaurant restaurant) {

        this.chairs = chairs;
        this.name = name;
        //this.diners = new ArrayList<Customer>();
        this.booking = new ArrayList<>();
        this.restaurant = restaurant;
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

    @Column(name="chairs")
    public int getChairs() {
        return chairs;
    }

    public void setChairs(int chairs) {
        this.chairs = chairs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    @OneToMany
//    @JoinColumn(name = "customer_id", nullable = true)
//    public List<Customer> getDiners() {
//        return diners;
//    }
//
//    public void setDiners(List<Customer> diners) {
//        this.diners = diners;
//    }
//
//    public void addCustomer(Customer customers){
//        this.diners.add(customers);
//    }



//    @ManyToOne
//    @JoinColumn(name = "restaurant_id", nullable = false)
//    public Restaurant getRestaurant() {
//        return restaurant;
//    }
//
//
//
//    public void setRestaurant(Restaurant restaurant) {
//        this.restaurant = restaurant;
//    }

    @OneToMany(mappedBy = "seating", fetch = FetchType.LAZY)
    public List<Booking> getBookings() {
        return booking;
    }

    public void setBookings(List<Booking> booking) {
        this.booking = booking;
    }

    //public void addCustomersToTable(Customer customer){
    //    this.diners.add(customer);
    //}
}
