import javax.swing.*;
import BreezySwing.*;
import java.util.List;

public class CompareItems extends GBDialog {
    GUI gui;

    JLabel item1Label;
    JLabel item2Label;

    JTextField item1Field = addTextField("", 2, 1, 1, 1);
    JTextField item2Field = addTextField("", 2, 2, 1, 1);

    JButton compare = addButton("Compare Items", 3, 1, 1, 1);

    public CompareItems(GUI gui) {
        super(gui);
        this.gui = gui;
        item1Label = addLabel("Item A ID(1-" + gui.getApp().getLibrary().size() + "): ", 1, 1, 1, 1);
        item2Label = addLabel("Item B ID(1-" + gui.getApp().getLibrary().size() + "): ", 1, 2, 1, 1);
    }

    public void buttonClicked(JButton button) {
        if (button == compare) {
            try {
                int item1Index = Integer.parseInt(item1Field.getText());
                int item2Index = Integer.parseInt(item2Field.getText());

                Item item1 = gui.getApp().getLibrary().get(item1Index - 1);
                Item item2 = gui.getApp().getLibrary().get(item2Index - 1);

                if(item1 == null || item2 == null) {
                    System.out.println("Invalid items specified.  item1=" + (item1 == null ? "null" : item1) + "/ item2=" + (item2 == null ? "null" : item2) + " ***");
                    gui.getOutput().setText("Invalid item IDs specified: " + "ID1: " + item1Index + " and ID2: " + item2Index + "\n");
                    dispose();
                    return;
                }

                if(!item1.getClass().equals(item2.getClass())) {
                    System.out.println("Items are not directly comparable.  Not the same class.  Item1[" + item1.getClass().getSimpleName() + "] Item2[" + item2.getClass().getSimpleName() + "]");
                    gui.getOutput().setText("Invalid Comparison Request.\nCannot compare a " + item1.getClass().getSimpleName() + " to a " + item2.getClass().getSimpleName() + "\n");
                    dispose();
                    return;
                }

                StringBuilder sb = new StringBuilder();
                // Output to console to show use of the print() method in the classes
                System.out.println("Comparing items:");
                item1.print();
                item2.print();

                sb.append("Comparing items:\n").append("item1: " + item1.toString() + "]\n").append("item2: " + item2.toString() + "]\n");

                int result = item1.compareTo(item2);
                String resultText;
                if(result < 0)
                    resultText = "<";
                else if(result > 0)
                    resultText = ">";
                else
                    resultText = "=";

                System.out.println("item1 " + resultText + " item2");
                sb.append("RESULT: item1 ").append(resultText).append(" item2").append("\n");
                gui.getOutput().setText(sb.toString());

            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                System.out.println(e.getClass().getSimpleName() + ": " + e.getMessage() + ".  Must be a linenumber from 1 - " + gui.getApp().getLibrary().size());
                System.out.println("Input: " + item1Field.getText() + " and " + item2Field.getText());
                gui.getOutput().setText(e.getClass().getSimpleName() + ": " + e.getMessage() + "\nMust be linenumbers from 1 - " +
                        gui.getApp().getLibrary().size() +"\nInput: " + item1Field.getText() + " and " + item2Field.getText() + "\n");
            }
        }
        dispose();
    }
}