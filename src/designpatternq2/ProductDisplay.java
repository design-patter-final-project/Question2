package designpatternq2;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ListView;

public class ProductDisplay implements Display {

    private ListView<String> list;
    ProductInstance productInstance;

    public ProductDisplay(ProductInstance productDisplay) {
        this.productInstance = productDisplay;
        make();
    }

    public void make() {
        list = new ListView<>();
        list.setPrefWidth(500);
        list.getItems().addAll(ProductAdapter.getProduct(productInstance)); //.addAll("Iron Man", "Titanic", "Contact", "Surrogates", "Aba");
        list.getSelectionModel().selectedItemProperty()
             .addListener( new ChangeListener<String>() {
                 public void changed(ObservableValue<? extends String> observable,
                     String oldValue, String newValue) {
                     productInstance.sellProduct(newValue);
                 }
             });
    }

    public ListView getView() {
        return list;
    }
}