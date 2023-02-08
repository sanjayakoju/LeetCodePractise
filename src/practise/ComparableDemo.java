package practise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A comparable object is capable of comparing itself with another object.
 * The class itself must implements the java.lang.Comparable interface to compare its instances.
 * Consider a Movie class that has members like, rating, name, year. Suppose we wish to sort a list
 * of Movies based on year of release. We can implement the Comparable interface with the Movie class,
 * and we override the method compareTo() of Comparable interface.
 */
public class ComparableDemo implements Comparable<ComparableDemo> {
    String name;
    String address;
    int age;

    public ComparableDemo(String name, String address, int age) {
        this.name = name;
        this.address = address;
        this.age = age;
    }

    @Override
    public int compareTo(ComparableDemo o) {
        return this.age - o.age;
    }

    @Override
    public String toString() {
        return "ComparableDemo{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        List<ComparableDemo> list = new ArrayList<>();
        list.add(new ComparableDemo("Sanjaya", "BKT", 28));
        list.add(new ComparableDemo("Omkar", "BTL", 32));
        list.add(new ComparableDemo("Shrawan", "BRT", 29));
        Collections.sort(list);
        for(ComparableDemo l: list) {
            System.out.println(l);
        }


    }
}
