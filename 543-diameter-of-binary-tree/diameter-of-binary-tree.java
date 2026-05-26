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
    int daimeter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
      hepler(root);
      return daimeter;
    }

    public int hepler(TreeNode root){
        if(root==null){
            return 
            0;
        }
        int left = hepler(root.left);
        int right = hepler(root.right);
         
        daimeter = Math.max(daimeter,left+right);

        int height = Math.max(left,right)+1;

        return height;
    }
}