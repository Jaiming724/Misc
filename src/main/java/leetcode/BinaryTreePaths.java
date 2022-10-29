package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> arr = new ArrayList<>();
        helper(root, arr, "");
        return arr;
    }

    private void helper(TreeNode root, List<String> list, String solution) {
        if (root == null) {
            return;
        }
        if (isLeaf(root)) {
            list.add(solution + root.val);
        }
        if (root.left != null) {
            helper(root.left, list, solution + root.val + "->");
        }
        if (root.right != null) {
            helper(root.right, list, solution + root.val + "->");

        }
    }
}