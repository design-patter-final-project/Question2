package designpatternq2;

import javafx.scene.control.ListView;

public class AlphabeticalDecorator extends DisplayDecorator {

    public AlphabeticalDecorator(ProductDisplay productDisplay) {
        super(productDisplay);
    }

    public void make() {
        super.make();
    }

    public void order() {
        getView().getItems().sort(null);
    }
}