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
    public boolean isSame(TreeNode s, TreeNode e){
        if(s == null && e == null){
            return true;
        }
        if(s == null || e == null){
            return false;
        }
        if(s.val != e.val){
            return false;
        }

        return isSame(s.left, e.left) && isSame(s.right, e.right);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null){
            return false;
        }

        if(isSame(root, subRoot)){
            return true;
        }

        // do check for both child left or right through BFS.
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
}