/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int parentValue = root.val;
        int pval = p.val;
        int qval = q.val;
        
        // call for right BST
        if(pval > parentValue && q.val > parentValue){
            return lowestCommonAncestor(root.right, p, q);
        }

        // call for left BST;
        if(pval < parentValue && qval < parentValue){
            return lowestCommonAncestor(root.left, p, q);
        }
        else{
            // simply return our root node
            return root;
        }
    }
}