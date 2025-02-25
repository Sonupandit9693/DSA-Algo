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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(! queue.isEmpty()){
            int levelsize = queue.size();
            for (int i=0; i < levelsize; i++){
                TreeNode currentNode = queue.poll();
                // add last nod's value of each level to the result list
                if(i == levelsize - 1){
                    result.add(currentNode.val);
                }

                // Add both left, right child nod's in queue for next level
                if(currentNode.left != null){
                    queue.add(currentNode.left);
                } 

                if(currentNode.right != null){
                    queue.add(currentNode.right);
                }
            }
        }

        return result;
    }
}