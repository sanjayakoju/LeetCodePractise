package coreJava.tryWithResource;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TryWithResourceDemo {

    void myFunc() {
        try (FileOutputStream fileOutputStream = new FileOutputStream("../src/resources/AutoCorrectionPrototype.jpg")) {
            fileOutputStream.write(1);
            System.out.println("Try With Resource");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        TryWithResourceDemo tryWithResourceDemo = new TryWithResourceDemo();
        tryWithResourceDemo.myFunc();
    }
}
