package designpatternq2;

import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

public class ProductAdapter {

    protected static ObservableList<String> products_name_list = FXCollections.observableArrayList();

    public static ObservableList<String> getProduct(ProductInstance productInstance) {
        productInstance.getProduct().forEach((product) -> {
            products_name_list.add(product.getName());
        });
        return products_name_list;
    }
}