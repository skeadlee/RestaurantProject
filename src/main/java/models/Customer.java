package models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="customers")
public class Customer {

    private int id;
    private String name;
    private int wallet;
    private int loyaltyCard;
    private List<Booking> bookings;
    private Restaurant restaurant;
    private Seating table;

    public Customer(){}

    public Customer(String name, int wallet, int loyaltyCard) {
        this.name = name;
        this.wallet = wallet;
        this.loyaltyCard = loyaltyCard;
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

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public void addBookings(Booking booking) { this.bookings.add(booking);}

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    public Restaurant getRestaurant() {
        return restaurant;
    }

    @ManyToOne
    @JoinColumn(name = "seating_id")
    public Seating getTable() {
        return table;
    }

    public void setTable(Seating seating) {
        this.table = seating;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }


    public void addLoyaltyPoints(int i){
        setLoyaltyCard(loyaltyCard += i);
    }

}
