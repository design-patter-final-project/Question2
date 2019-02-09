package designpatternq2;

import java.awt.Rectangle;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.HBox;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.paint.Color;

public class Main extends Application {

    Stage window;
    Scene scene;

    AlphabeticalDecorator alphabeticalDecorator;
    SalesFigureDisplay salesFigureDisplay;
    
    ProductInstance productInstance;

    Button showProductListButton;
    Button showSalesFigureButton;
    Button sortButton;

    Pane left_layout;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Sales Figures");
        
        productInstance = ProductInstance.getInstance();
        alphabeticalDecorator = new AlphabeticalDecorator( new ProductDisplay(productInstance));
        salesFigureDisplay = new SalesFigureDisplay(productInstance);

        left_layout = new Pane();
        left_layout.getChildren().addAll(alphabeticalDecorator.getView());

        // Navigator buttons
        showProductListButton = new Button("Show Products");
        showProductListButton.setOnAction(e -> showProductList());

        showSalesFigureButton = new Button("Show Sales Figure");
        showSalesFigureButton.setOnAction(e -> showSalesFigure());

        sortButton = new Button("Sort");
        sortButton.setOnAction(e -> sortList());


        HBox right_layout = new HBox();
        right_layout.setPadding(new Insets(20, 20, 20, 20));
        right_layout.setSpacing(10);
        right_layout.getChildren().addAll(showProductListButton, showSalesFigureButton, sortButton);
        
        // layout
        HBox layout = new HBox();
        layout.getChildren().addAll(left_layout, right_layout);

        scene = new Scene(layout);
        window.setScene(scene);
        window.show();
    }
    
    public void showProductList() {
        left_layout.getChildren().clear();
        left_layout.getChildren().addAll(alphabeticalDecorator.getView());
    }

    public void showSalesFigure() {
        left_layout.getChildren().clear();
        salesFigureDisplay.update();
        left_layout.getChildren().addAll(salesFigureDisplay.getView());
    }

    public void sortList() {
        alphabeticalDecorator.order();
    }
}