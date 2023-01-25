package practise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * A comparator interface is used to order the objects of user-defined classes.
 * A comparator object is capable of comparing two objects of the same class.
 * Need to override the compare(o1,o2) method
 */
public class ComparatorDemo  {
    String name;
    String address;
    int age;

    public ComparatorDemo(String name, String address, int age) {
        this.name = name;
        this.address = address;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "ComparatorDemo{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        List<ComparatorDemo> list = new ArrayList<>();
        list.add(new ComparatorDemo("Sanjaya", "BKT", 28));
        list.add(new ComparatorDemo("Omkar", "BTL", 32));
        list.add(new ComparatorDemo("Shrawan", "BRT", 29));

        NameComparator nameComparator = new NameComparator();
        AgeComparator ageComparator = new AgeComparator();
        Collections.sort(list, nameComparator);
        for(ComparatorDemo l: list) {
            System.out.println(l);
        }
    }
}

class NameComparator implements Comparator<ComparatorDemo> {

    @Override
    public int compare(ComparatorDemo o1, ComparatorDemo o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

class AgeComparator implements Comparator<ComparatorDemo> {
    @Override
    public int compare(ComparatorDemo o1, ComparatorDemo o2) {
        return o1.age - o2.age;
    }
}
