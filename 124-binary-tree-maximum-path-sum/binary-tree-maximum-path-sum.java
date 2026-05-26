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
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        hepler(root);
        return ans;
    }
    public int hepler(TreeNode node){
        if(node==null){
            return 0;
        }
        int left = hepler(node.left);
        int right = hepler(node.right);
        
        left = Math.max(0,left);
        right = Math.max(0,right);

        int pathSum = Math.max(ans,left+right+node.val);

        ans = Math.max(ans,pathSum);

        return Math.max(left,right) + node.val;
    }

}