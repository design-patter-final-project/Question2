package designpatternq2;

import javafx.collections.transformation.SortedList;
import javafx.scene.control.ListView;

public class DisplayDecorator implements Display {

    private ProductDisplay wrappee;

    public DisplayDecorator(ProductDisplay productDisplay) {
        wrappee = productDisplay;
    }

    public void make() {
        wrappee.make();
    }

    public ListView getView() {
        return wrappee.getView();
    }

    public void sort() {
        getView().getItems().sort(null);
    }
}