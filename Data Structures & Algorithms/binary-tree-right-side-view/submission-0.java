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
          ArrayList<Integer> res=new ArrayList<>();
        left(root, res, 0);
        return res;
    }
    
    public static void left(TreeNode curr, ArrayList<Integer> res, int depth){
        if(curr==null) return;
        if(depth==res.size()) res.add(curr.val);
        
        left(curr.right,res,depth+1);
        left(curr.left, res,depth+1);
        
    }
}
