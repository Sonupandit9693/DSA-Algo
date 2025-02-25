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
    List<List<Integer>> ans = new ArrayList<>();
    public void levelOrder(TreeNode node, int level){
        if(ans.size() == level){
            ans.add(new ArrayList<Integer>());
        }
        ans.get(level).add(node.val);

        // call for left sub tree
        if(node.left != null){
            levelOrder(node.left, level + 1);
        }

        // call for right sub tree
        if(node.right != null){
            levelOrder(node.right, level +1);
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return ans;
        }
        // call to level order traveesal by passing intializing levele at 0
        levelOrder(root, 0);
        
        return ans;
    }
}