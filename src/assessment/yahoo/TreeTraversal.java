package assessment.yahoo;

import java.util.ArrayDeque;
import java.util.Queue;

// => Write tree traversals
public class TreeTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left1 = new TreeNode(2);
        TreeNode right1 = new TreeNode(3);
        left1.left = new TreeNode(4);
        left1.right = new TreeNode(5);

        right1.left = new TreeNode(6);
        right1.right = new TreeNode(7);

        root.left = left1;
        root.right = right1;

        System.out.print("Pre Order : ");
        preOrder(root);

        System.out.println();
        System.out.print("Post Order : ");
        postOrder(root);

        System.out.println();
        System.out.print("In Order : ");
        inOrder(root);

        System.out.println();
        System.out.print("Level : ");
        level(root);
    }

    // DFS
    public static void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.val +" ");
            inOrder(root.right);
        }
    }

    // DFS
    public static void preOrder(TreeNode root) {
        if (root != null) {
            System.out.print(root.val +" ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    // DFS
    public static void postOrder(TreeNode root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.val + " ");
        }
    }

    // BFS
    public static void level(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");
            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }
}
