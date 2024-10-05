package designPatterns.solid.InterfaceSegregationPrinciple;

/**
 * Definition: Clients should not be forced to depend on methods they do not use.
 * Instead of having large coreJava.interfaces, break them into smaller, more specific ones.
 *
 * Example: Let’s design coreJava.interfaces for a machine with multiple operations.
 */

// Violating ISP
public interface Machine {
    void printDocument();
    void scanDocument();
    void faxDocument();
}

