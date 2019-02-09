package designpatternq2;

import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

public class ProductInstance {

    protected static ProductInstance instance;
    protected ObservableList<Product> products = FXCollections.observableArrayList();

    protected ProductInstance(){
        products.add(new Product("Laptop", 900.4, 15));
        products.add(new Product("Bauncy Ball", 2.46, 105));
        products.add(new Product("Toilet", 99.00, 23));
        products.add(new Product("The Notebook DVD", 19.99, 48));
        products.add(new Product("Corn", 1.46, 535));
    }

    public static ProductInstance getInstance() {
        if(instance == null) {
            instance = new ProductInstance();
        }
        return instance;
    }

    public ObservableList<Product> getProduct() {
        return products;
    }

    public void sellProduct(String productName){
        Product product = getProduct(productName);
        decrementQuantity(product);
        incrementSoldQuantity(product);
        System.out.println(product.getSoldQuantity());
    }

    private void decrementQuantity(Product product) {
        int quantity = product.getQuantity();
        product.setQuantity(quantity - 1);
    }

    private void incrementSoldQuantity(Product product) {
        int soldQuantity = product.getSoldQuantity();
        product.setSoldQuantity(soldQuantity + 1);
    }
    
    private Product getProduct(String productName) {
        for(int i = 0; i < products.size(); i++){
            if(products.get(i).getName().equals(productName)){
                return products.get(i);
            }
        }
        return null;
    }
}