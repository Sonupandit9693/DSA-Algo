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
class Solution {
    public int goodNodes(TreeNode root) {
        return countGoodNode(root, Integer.MIN_VALUE);
    }

    private int countGoodNode(TreeNode root, int max_value){
        if(root == null){
            return 0;
        }

        int count = 0;

        // check if good node cond
        if(root.val >= max_value){
            count = 1;
            max_value = root.val;
        }

        // do for left sub child or right
        count += countGoodNode(root.left, max_value);
        count += countGoodNode(root.right, max_value);

        return count;
    }
}