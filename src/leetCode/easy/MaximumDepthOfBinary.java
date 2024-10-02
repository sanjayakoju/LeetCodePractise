package leetCode.easy;

import assessment.yahoo.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 104. Maximum Depth of Binary Tree
 * Solved
 * Easy
 * Topics
 * Companies
 * Given the root of a binary tree, return its maximum depth.
 *
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * Example 1:
 *
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 3
 * Example 2:
 *
 * Input: root = [1,null,2]
 * Output: 2
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 104].
 * -100 <= Node.val <= 100
 */
public class MaximumDepthOfBinary {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */

    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        // DFS recursive
        // return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));

        // BFS
//        int level = 0;
//        Queue<TreeNode> q = new LinkedList<>();
//        q.add(root);
//        while(!q.isEmpty()) {
//            int size = q.size();
//            for(int i=0;i<size;i++) {
//                TreeNode node = q.poll();
//                if(node.left != null) {
//                    q.add(node.left);
//                }
//                if(node.right != null) {
//                    q.add(node.right);
//                }
//            }
//            level++;
//        }
//        return  level;

        // DFS using interative
        int maxLevel = 0;
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new Pair<>(root, 1));  // Start with the root node at level 1

        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> current = stack.pop();
            TreeNode node = current.getKey();
            int level = current.getValue();

            // Update the maximum level
            maxLevel = Math.max(maxLevel, level);

            // Push the children onto the stack, with their level incremented
            if (node.left != null) {
                stack.push(new Pair<>(node.left, level + 1));
            }
            if (node.right != null) {
                stack.push(new Pair<>(node.right, level + 1));
            }
        }
        return maxLevel;
    }

    public static void main(String[] args) {

    }

    static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}
