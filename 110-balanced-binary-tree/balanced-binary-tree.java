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

    boolean balance = true;
    public boolean isBalanced(TreeNode root) {
        getHeight(root);
        return balance;
    }

    private int getHeight(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = getHeight(root.left);
        int right = getHeight(root.right);

        if(Math.abs(left - right) > 1){
            balance = false;
        }

        return 1 + Math.max(left, right);
    }
}