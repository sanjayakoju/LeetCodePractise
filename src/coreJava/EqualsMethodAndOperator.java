package coreJava;

/**
 * In general, both equals() and “==” operators in Java are used to compare objects to check equality,
 * but here are some of the differences between the two:
 * The main difference between the .equals() method and == operator is that one is a method, and the other
 * is the operator.
 * We can use == operators for reference comparison (address comparison) and .equals() method for content
 * comparison. In simple words, == checks if both objects point to the same memory location whereas .equals()
 * evaluates to the comparison of values in the objects.
 * If a class does not override the equals method, then by default, it uses the equals(Object o) method of the
 * closest parent class that has overridden this method.
 */
public class EqualsMethodAndOperator {

    public static void main(String[] args) {
        String s1 = "HELLO";
        String s2 = "HELLO";
        String s3 =  new String("HELLO");

        System.out.println(s1 == s2); // true (reference comparison)
        System.out.println(s1 == s3); // false
        System.out.println(s1.equals(s2)); // true (content comparison)
        System.out.println(s1.equals(s3)); // true (content comparison)
    }
}
