public abstract class Item implements Comparable {

    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "[Name: \"" + name + "\"]";
    }

    public void print() {
        System.out.print("[Name: \"" + name + "\"]");
    }
}