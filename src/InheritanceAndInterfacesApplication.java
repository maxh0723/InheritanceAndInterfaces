import java.util.List;
import java.util.ArrayList;

public class InheritanceAndInterfacesApplication {

    List<Item> library = new ArrayList<>();

    public InheritanceAndInterfacesApplication() {

    }

    public List<Item> getLibrary() {
        return library;
    }

    public static void main(String[] args) {
        Item book1 = new Book("Dictionary", "Webster");
        Item book2 = new Book("The Castle", "Kafka, Franz");
        Item book3 = new Book("The Great Gatsby", "Fitzgerald, F. Scott");
        Item book4 = new Book("The Castle", "Hansen, Erik");

        Item mag1 = new Periodical("PC Pilot", 1);
        Item mag2 = new Periodical("Sports Illustrated", 234);
        Item mag3 = new Periodical("Sports Illustrated", 345);
        Item mag4 = new Periodical("National Geographic", 222);
        Item mag5 = new Periodical("National Geographic", 149);

        InheritanceAndInterfacesApplication app = new InheritanceAndInterfacesApplication();
        app.getLibrary().add(book1);
        app.getLibrary().add(book2);
        app.getLibrary().add(book3);
        app.getLibrary().add(book4);
        app.getLibrary().add(mag1);
        app.getLibrary().add(mag2);
        app.getLibrary().add(mag3);
        app.getLibrary().add(mag4);
        app.getLibrary().add(mag5);
        System.out.println("Created library with " + app.getLibrary().size() + " items.");

        Item item1 = app.getLibrary().get(3);
        Item item2 = app.getLibrary().get(1);
        System.out.print("Comparing item1[");
        item1.print();
        System.out.print("] and item2[");
        item2.print();
        System.out.print("]] => " + String.valueOf(item1.compareTo(item2)) + "\n");

        Item item3 = app.getLibrary().get(7);
        Item item4 = app.getLibrary().get(8);
        System.out.print("Comparing item3[");
        item3.print();
        System.out.print("] and item4[");
        item4.print();
        System.out.print("]] => " + item3.compareTo(item4) + "\n");

        System.out.println("Done.");

    }
}