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
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> ans = inOrder(root, new ArrayList<Integer>());
        return ans.get(k-1); // becasue ArrayList Have 0 based indexing that reson we do k-1
    }

    public ArrayList<Integer> inOrder(TreeNode root, ArrayList<Integer> arr){
        if(root == null){
            return arr;
        }

        // call fot left child
        inOrder(root.left, arr);
        // backtracking the value
        // add value curent node 
        arr.add(root.val);
        // then call for right child
        inOrder(root.right, arr);

        // after this simply return my arr
        return arr;
    }
}