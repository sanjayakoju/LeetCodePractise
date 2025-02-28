package coreJava.consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Consumer is a functional interface that takes an argument but does not return anything (its accept() method). It’s
 * commonly used for operations like printing or modifying elements in a collection.
 */
public class ConsumerDemo {

    public static void main(String[] args) {
        Consumer<Integer> display = a -> System.out.println(a);

        display.accept(10);

        // Consumer to multiply 2 to every integer of a list
        Consumer<List<Integer>> modify = list ->
        {
            for (int i = 0; i < list.size(); i++)
                list.set(i, 2 * list.get(i));
        };

        // Consumer to display a list of numbers
        Consumer<List<Integer> > displayList = list -> list.stream().forEach(a -> System.out.print(a + " "));

        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(1);
        list.add(3);

        // Implement modify using accept()
        modify.accept(list);

        // Implement displayList using accept()
        displayList.accept(list);


        System.out.println();
        Consumer<String> printMessage = msg -> System.out.println("Message: " + msg);
        printMessage.accept("Hello, Java!"); // Message: Hello, Java!

    }
}
