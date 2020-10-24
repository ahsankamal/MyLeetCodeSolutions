package WeekOne;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class AllElementsInBST {
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

    public static List<Integer> inorder2(TreeNode root, ArrayList<Integer> list){
        if(root.left!=null){
            AllElementsInBST.inorder2(root.left, list);
        }
        list.add(root.val);
        if(root.right!=null){
            AllElementsInBST.inorder2(root.right, list);
        }
        return list;
    }

    //to review
     public static List<Integer> inorder(TreeNode root){
         ArrayList<Integer> list = new ArrayList<>();
         ArrayDeque<TreeNode> stack1 = new ArrayDeque<>();
         TreeNode tmp = root;
         try {
             while (true){
                 while (tmp.left!=null){
                     stack1.push(tmp);
                     tmp = tmp.left;
                 }
//                 System.out.println(tmp.val);
                 list.add(tmp.val);
                 if(tmp.right==null){
                     tmp = stack1.pop();
//                     System.out.println(tmp.val);
                     list.add(tmp.val);
                 }
                 tmp = tmp.right;
             }
         }catch (Exception e){

         }
         return list;
     }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {

        List<Integer> list1 = AllElementsInBST.inorder2(root1, new ArrayList<>());
        List<Integer> list2 = AllElementsInBST.inorder2(root2, new ArrayList<>());
        List<Integer> newList = new ArrayList<>();

        int i=0;
        int j=0;
//        list1.forEach(e->System.out.print(e+" "));
//        System.out.println();
//        list2.forEach(e->System.out.print(e+" "));
//        System.out.println();

        while (i<list1.size()&&j<list2.size()){
            if(list1.get(i)>=list2.get(j)){
                newList.add(list2.get(j));
                j++;
            }else {
                newList.add(list1.get(i));
                i++;
            }
        }

//        newList.forEach(e->System.out.print(e+" "));
//        System.out.println();

        while(i<list1.size()){
            newList.add(list1.get(i));
            i++;
        }
//        list2.forEach(e->System.out.print(e+" "));
//        System.out.println(j);
        while(j<list2.size()){
            newList.add(list2.get(j));
            j++;
        }

        return newList;
    }

    public static void main(String[] args){
        AllElementsInBST bst = new AllElementsInBST();

        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(7);
        root1.left.left = new TreeNode(0);
        root1.left.right = new TreeNode(2);

//        TreeNode root1 = new TreeNode(5);
//        root1.left = new TreeNode(3);
//        root1.right = new TreeNode(9);
//        root1.left.left = new TreeNode(1);
//        root1.left.right = new TreeNode(4);
//        root1.right.left = new TreeNode(7);
//
//        TreeNode root2 = new TreeNode(10);
//        root2.left = new TreeNode(6);
//        root2.right = new TreeNode(19);
//        root2.left.left = new TreeNode(2);
//        root2.left.right = new TreeNode(8);
//        root2.right.left = new TreeNode(17);

//        System.out.println(bst.getAllElements(root1, root2));
        System.out.println(bst.getAllElements(root1, null));
    }

}
