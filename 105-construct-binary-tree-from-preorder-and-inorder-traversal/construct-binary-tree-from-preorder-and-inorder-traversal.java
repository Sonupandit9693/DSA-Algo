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
    int preOrderIndex;
    Map<Integer, Integer> preOrderMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preOrderIndex = 0;
        preOrderMap = new HashMap<>();

        // put all value of inorder in in preorder map
        for(int i=0; i<inorder.length; i++){
            preOrderMap.put(inorder[i], i);
        }

        return arrayToTree(preorder, 0, preorder.length-1);
    }

    public TreeNode arrayToTree(int [] preorder, int left, int right){
        // base case
        if(left > right){
            return null;
        }

        int rootValue = preorder[preOrderIndex];
        preOrderIndex ++;

        TreeNode root = new TreeNode(rootValue);
        root.left = arrayToTree(preorder, left, preOrderMap.get(rootValue) -1);
        root.right = arrayToTree(preorder, preOrderMap.get(rootValue) + 1, right);
        return root;
    }
}