import javax.swing.*;
import BreezySwing.*;

public class GUI extends GBFrame {
    JButton addBook       = addButton("Add Book", 3, 1, 1, 1);
    JButton addPeriodical = addButton("Add Periodical", 3, 2, 1, 1);
    JButton printLibrary  = addButton("Print Library", 3, 3, 1, 1);
    JTextArea output      = addTextArea("", 1, 1, 1, 1);

    InheritanceAndInterfacesApplication app;

    public GUI(InheritanceAndInterfacesApplication app) {
        super();
        this.app = app;
    }

    public void buttonClicked(JButton button) {
        if(button == addBook) {
            AddBook addB = new AddBook(this);
        } else if(button == addPeriodical) {
            AddPeriodical addP = new AddPeriodical(this);
        } else if(button == printLibrary) {
            output.setText(null);
            int i = 1;
            StringBuilder sb = new StringBuilder();
            for(Item it : app.getLibrary()) {
                sb.append("Item #" + (i++) + ": ").append(it.toString()).append("\n");
            }
            output.setText(sb.toString());
        }
    }

}