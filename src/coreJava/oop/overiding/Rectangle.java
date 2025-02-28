package coreJava.oop.overiding;

import javax.swing.*;

public class Rectangle implements Shape {
    @Override
    public int area(int a, int b) {
        return 0;
    }

    // Throw error not possible
//    public String area(int a, int b) {
//
//    }

    public static void main(String[] args) {
        String st = JOptionPane.showInputDialog("Type your name");
        System.out.println(st);
        System.out.println("ab".compareTo("ab"));
        JOptionPane.showMessageDialog(null, st);
    }
}
