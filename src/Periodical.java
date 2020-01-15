import java.lang.Comparable;

public class Periodical extends Item implements Comparable {

    int issue;

    public Periodical() {
        super();
    }

    public Periodical(String name, int issue) {
        this.name = name;
        this.issue = issue;
    }

    public int getIssue() {
        return issue;
    }

    public void setIssue(int issue) {
        this.issue = issue;
    }

    @Override
    public void print() {
        System.out.print("[Name: \"" + name + "\"][Issue: " + issue + "]");
    }

    @Override
    public String toString() {
        return "[Name: \"" + name + "\"][Issue: " + issue + "]";
    }

    @Override
    public int compareTo(Object o) {

        Periodical p = (Periodical)o;

        if(this.getName().compareTo(p.getName()) < 0) {
            return -1;
        } else if(this.getName().compareTo(p.getName()) > 0) {
            return 1;
        } else {
            if(this.issue < p.getIssue()) {
                return -1;
            } else if(this.issue > p.getIssue()) {
                return 1;
            }
            return 0;
        }
    }

}