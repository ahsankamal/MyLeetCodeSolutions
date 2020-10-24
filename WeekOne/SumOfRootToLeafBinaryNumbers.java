package WeekOne;

public class SumOfRootToLeafBinaryNumbers {

     //Definition for a binary tree node.
     public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

    public static int postOrderAndSum(TreeNode root, String binary, int sum){
         if(root.left==null && root.right==null){
             return sum + Integer.parseInt(binary,2);
         }
         if(root.left!=null){
             sum = SumOfRootToLeafBinaryNumbers.postOrderAndSum(root.left, binary+root.left.val, sum);
         }
         if(root.right!=null){
             sum = SumOfRootToLeafBinaryNumbers.postOrderAndSum(root.right, binary+root.right.val, sum);
         }
         return sum;
    }

    public int sumRootToLeaf(TreeNode root) {
        return SumOfRootToLeafBinaryNumbers.postOrderAndSum(root, String.valueOf(root.val), 0);
    }

    public static void main(String[] args){
        SumOfRootToLeafBinaryNumbers s = new SumOfRootToLeafBinaryNumbers();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);
        System.out.println(s.sumRootToLeaf(root));
    }

}
