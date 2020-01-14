import javax.swing.*;
import BreezySwing.*;
import java.util.List;

public class AddBook extends GBDialog {
        GUI gui;
        List<Item> library;

        public AddBook(GUI gui) {
            super(gui);
            this.gui = gui;
        }
}