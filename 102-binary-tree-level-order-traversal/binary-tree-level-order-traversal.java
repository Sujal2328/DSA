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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> rs = new ArrayList<>();
         if(root==null){
            return rs;
         } 
         Queue<TreeNode> q= new LinkedList<>();
         q.offer(root);
         while(!q.isEmpty()){
            int lvlSize = q.size();
          List<Integer> currentlvl = new ArrayList<>(lvlSize);
          
          for(int i=0;i<lvlSize;i++){
            TreeNode currentNode = q.poll();
            currentlvl.add(currentNode.val);
            if(currentNode.left!=null){
                q.offer(currentNode.left);
            }
            if(currentNode.right!=null){
                q.offer(currentNode.right);
            }
          }
          rs.add(currentlvl);
         }
         return rs;
    }
}