package leetCode.hard;

import assessment.yahoo.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 297. Serialize and Deserialize Binary Tree
 * Hard
 * Topics
 * Companies
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 *
 * Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3,null,null,4,5]
 * Output: [1,2,3,null,null,4,5]
 * Example 2:
 *
 * Input: root = []
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 104].
 * -1000 <= Node.val <= 1000
 */
public class SerializeAndDeserializeBinaryTree {

    private int i;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> list = new ArrayList<>();
        serializeDfs(root, list);
        return String.join(",", list);
    }

    private void serializeDfs(TreeNode root, List<String> list) {
        if(root == null) {
            list.add("N");
            return;
        }
        list.add(String.valueOf(root.val));
        serializeDfs(root.left, list);
        serializeDfs(root.right, list);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String [] tokens = data.split(",");
        return deserializeDfs(tokens);
    }

    private TreeNode deserializeDfs(String [] tokens) {
        String token = tokens[i];
        if(token.equals("N")) {
            this.i++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(token));
        this.i++;
        node.left = deserializeDfs(tokens);
        node.right = deserializeDfs(tokens);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
