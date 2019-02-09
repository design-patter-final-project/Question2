package designpatternq2;

public class Product {

    private String name;
    private double price;
    private int quantity;
    private int soldQuantity;

    public Product() {
        this.name = "";
        this.price = 0;
        this.quantity = 0;
        this.soldQuantity = 0;
    }

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSoldQuantity() {
        return this.soldQuantity;
    }

    public void setSoldQuantity(int quantity) {
        this.soldQuantity = quantity;
    }
}