package coreJava.optional;

import java.util.Optional;

public class OptionalExample {
    public static Optional<String> getName(boolean hasName) {
        String sentence1 = "hello world";
        String sentence2 = "hello of world";
        String [] st1 = sentence1.split(" ");
        String [] st2 = sentence2.split(" ");

        if (st1.length > st2.length) {
            String [] temp = st1;
            st1 = st2;
            st2 = temp;
        }
        return hasName ? Optional.of("John Doe") : Optional.empty();
    }

    public static void main(String[] args) {

        Optional<String> emptyOpt = Optional.empty();
        System.out.println(emptyOpt.isPresent());  // Output: false

        Optional<String> opts = Optional.of("Hello");
        System.out.println(opts.get());  // Output: Hello

        Optional<String> opt = Optional.ofNullable(null);
        System.out.println(opt.isPresent());  // Output: false

        Optional<String> optss = Optional.of("Hello");
        if (optss.isPresent()) {
            System.out.println("Value is present");
        }  // Output: Value is present

        Optional<String> op = Optional.ofNullable("Hello");
        op.ifPresent(value -> System.out.println(value));  // Output: Hello

        Optional<String> ot = Optional.ofNullable(null);
        System.out.println(ot.orElse("Default"));  // Output: Default




        Optional<String> nameOpt = getName(false);

        // Using ifPresent()
        nameOpt.ifPresent(name -> System.out.println("Name: " + name));

        // Using orElse()
        String name = nameOpt.orElse("No Name Available");
        System.out.println(name);  // Output: No Name Available
    }
}

