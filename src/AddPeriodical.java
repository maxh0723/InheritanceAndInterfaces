import javax.swing.*;
import BreezySwing.*;
import java.util.List;

public class AddPeriodical extends GBDialog {

    GUI gui;

    JLabel nameLabel  = addLabel("Name: ", 1, 1, 1, 1);
    JLabel issueLabel = issueLabel = addLabel("Issue: ", 1, 2, 1, 1);

    JTextField nameField  = addTextField("", 2, 1, 1, 1);
    JTextField issueField = addTextField("", 2, 2, 1, 1);

    JButton addPeriodical = addButton("Add Periodical", 3, 1, 1, 1);

    public AddPeriodical(GUI gui) {
        super(gui);
        this.gui = gui;
    }

    public void buttonClicked(JButton button) {
        try {
            int issue = Integer.parseInt(issueField.getText());
            if (button == addPeriodical) {
                gui.getApp().getLibrary().add(new Periodical(nameField.getText(), issue));
                gui.getOutput().setText(null);
                int i = 1;
                StringBuilder sb = new StringBuilder();
                for(Item it : gui.getApp().getLibrary()) {
                    sb.append("Item #" + (i++) + ": ").append(it.toString()).append("\n");
                }
                gui.getOutput().setText(sb.toString());
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid issue specified: " + issueField.getText());
        }
        dispose();
    }
}