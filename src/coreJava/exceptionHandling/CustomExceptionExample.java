package coreJava.exceptionHandling;

public class CustomExceptionExample {
    public static void riskyMethod() throws MyCustomException {
        throw new MyCustomException("Something went wrong!");
    }

    public static void main(String[] args) {
        try {
            riskyMethod();
        } catch (MyCustomException e) {
            System.out.println("Caught custom exception: " + e.getMessage());
        }
    }
}
