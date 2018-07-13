package models;

import javax.persistence.*;

@Entity
@Table(name="tills")
public class Till {

    private int id;
    private int amount;
    private Restaurant restaurant;

    public Till() {
    }


    public Till(int amount) {
        this.amount = amount;
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

    @Column(name = "amount")
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void increaseBalance(int bill){
        this.amount = amount += bill;
    }


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "till_id", nullable = false)
    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
