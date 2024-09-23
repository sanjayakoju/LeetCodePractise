package leetCode.medium;

import assessment.yahoo.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 230. Kth Smallest Element in a BST
 * Solved
 * Medium
 * Topics
 * Companies
 * Hint
 * Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,1,4,null,2], k = 1
 * Output: 1
 * Example 2:
 *
 *
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 * Output: 3
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is n.
 * 1 <= k <= n <= 104
 * 0 <= Node.val <= 104
 */
public class KthSmallestElementInABST {

    public int kthSmallest(TreeNode root, int k) {
        // int n = 0;
        // Stack<TreeNode> stack = new Stack();
        // TreeNode curr = root;

        // while (curr != null || !stack.isEmpty()) {
        //     while (curr != null) {
        //         stack.push(curr);
        //         curr = curr.left;
        //     }
        //     curr = stack.pop();
        //     n += 1;
        //     if(n == k) {
        //         return curr.val;
        //     }
        //     curr = curr.right;
        // }
        // return -1;

        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list.get(k - 1);
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if(root == null) {
            return;
        }

        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}
