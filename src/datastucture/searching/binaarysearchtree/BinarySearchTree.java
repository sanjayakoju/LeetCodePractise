package datastucture.searching.binaarysearchtree;


/**
 * Time Complexity O(log n)
 */
public class BinarySearchTree {

    static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    private static Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        } else {
            // value already exists
            return current;
        }
        return current;
    }


    // Binary Search Tree recursive
    private static boolean containsNodeRecursive(Node current, int value) {
        if (current == null) {
            return false;
        }

        if (value == current.value) {
            return true;
        }

        if (value < current.value) {
            return containsNodeRecursive(current.left, value);
        } else {
            return containsNodeRecursive(current.right, value);
        }
    }

    // Non-recursive
    private static boolean containsNode(Node current, int value) {
        while (current != null) {
            if (current.value == value)
                return true;
            else if (value < current.value) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        addRecursive(node1,1);
        addRecursive(node1,2);
        addRecursive(node1,3);
        boolean isFound = containsNodeRecursive(node1,5);
        System.out.println("Is Found : "+isFound);
        System.out.println("Is Found : "+containsNodeRecursive(node1,3));
        System.out.println("Is Found : "+containsNode(node1,3));
        System.out.println("Is Found : "+containsNode(node1,5));
    }

}
