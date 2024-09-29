package designPatterns.solid.InterfaceSegregationPrinciple;

public class MultiFunctionPrinter implements Printer, Scanner, FaxMachine {
    public void printDocument() { /* implementation */ }
    public void scanDocument() { /* implementation */ }
    public void faxDocument() { /* implementation */ }
}
