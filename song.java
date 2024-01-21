import java.util.ArrayList;
import java.util.LinkedList;
public class song {
    String title;
    double length;
    // song name and length

    //constructor
    public song(String title, double length) {
        this.title = title;
        this.length = length;
    }
    public song(){

    }

    //title and length
    public String getTitle() {
        return title;
    }

    public double getLength() {
        return length;
    }

    //toString
    public String toString() {
        return ("\nName = " + title + "\n" +
                "Length = " + length);
    }


}