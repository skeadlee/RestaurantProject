package models;

public class Till {

    private int id;
    private int amount;

    public Till() {
    }

    public Till(int amount) {
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void increaseBalance(int bill){
        this.amount = amount += bill;
    }
}
