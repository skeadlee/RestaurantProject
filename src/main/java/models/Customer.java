package models;

public class Customer {

    private int id;
    private String name;
    private int wallet;
    private int loyaltyCard;

    public Customer(){}

    public Customer(String name, int wallet) {
        this.name = name;
        this.wallet = wallet;
        this.loyaltyCard = 0;
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
}
