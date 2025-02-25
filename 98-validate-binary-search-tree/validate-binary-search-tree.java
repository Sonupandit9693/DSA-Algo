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
    public boolean isValidBST(TreeNode root) {
        return checkValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean checkValid(TreeNode node, long minimum, long maximum){
        if(node == null) return true;

        if(!(node.val > minimum && node.val < maximum)){
            return false;
        }

        // do check for next left and right child
        return checkValid(node.left, minimum, node.val) && checkValid(node.right, node.val, maximum); 
    }

}