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
    int postindex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
           postindex = postorder.length - 1;
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(inorder,postorder,0,inorder.length-1,map);
    }
    public TreeNode build(int[] inorder,int[] postorder,int st,int end,HashMap<Integer,Integer>map){
        if(st>end){
            return null;        }
    
    int rootVal = postorder[postindex];
    postindex--;

    TreeNode root = new TreeNode(rootVal);
     int rootindex = map.get(rootVal);

    
    root.right = build(inorder,postorder,rootindex+1,end,map);

    root.left = build(inorder,postorder,st,rootindex-1,map);


    return root;
    }
}