public class Book extends Item {

    String author;

    public Book() {
        super();
    }

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public void print() {
        super.print();
        System.out.print("[Author: " + author + "]");
    }

    @Override
    public String toString() {
        return super.toString() + "[Author: " + author + "]";
    }

    @Override
    public int compareTo(Object o) {
        Book b = (Book)o;

        if(this.getName().compareTo(b.getName()) < 0) {
            return -1;
        } else if(this.getName().compareTo(b.getName()) > 0) {
            return 1;
        } else {
            if(this.author.compareTo(b.getAuthor()) < 0) {
                return -1;
            } else if(this.author.compareTo(b.getAuthor()) > 0) {
                return 1;
            } else {
                return 0;
            }
        }

    }
}