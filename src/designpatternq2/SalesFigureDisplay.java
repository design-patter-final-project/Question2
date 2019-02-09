package designpatternq2;

import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;

public class SalesFigureDisplay implements Display {

    TableView<Product> table;
    ProductInstance productInstance;
    
    TableColumn<Product, String> nameColumn;
    TableColumn<Product, String> quantityColumn;

    public SalesFigureDisplay(ProductInstance productInstance) {
        this.productInstance = productInstance;
        make();
    }

    public void make() {
        // Name column
        nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        // Name column
        quantityColumn = new TableColumn<>("Sales Figure");
        quantityColumn.setMinWidth(200);
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("soldQuantity"));

        table = new TableView<>();
        table.setItems(productInstance.getProduct());
        table.getColumns().addAll(nameColumn, quantityColumn);
    }

    public TableView getView() {
        return table;
    }
    
    public void update() {
        table.getColumns().clear();
        System.out.println(productInstance.getProduct().get(0).getSoldQuantity());
        table.getColumns().addAll(nameColumn, quantityColumn);
        //this.productInstance = productInstance;
        //table.setItems(productInstance.getProduct());
    }

}