import javax.swing.*;
import BreezySwing.*;
import java.util.List;

public class AddBook extends GBDialog {
        GUI gui;

        JLabel nameLabel     = addLabel("Name: ", 1, 1, 1, 1);
        JLabel authorLabel   = addLabel("ID: ", 1, 2, 1, 1);

        JTextField nameField   = addTextField("", 2, 1, 1, 1);
        JTextField authorField = addTextField("", 2, 2, 1, 1);

        JButton addBook = addButton("Add Book", 3, 1, 1, 1);

        public AddBook(GUI gui) {
            super(gui);
            this.gui = gui;
        }

        public void buttonClicked(JButton button) {
            if (button == addBook)
                    gui.getApp().getLibrary().add(new Book(nameField.getText(), authorField.getText()));
            dispose();
        }
}