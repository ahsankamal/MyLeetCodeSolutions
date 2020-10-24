package WeekThree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://www.youtube.com/watch?v=i9Ye_rzeYPw
public class MaximumXORofTwoNumbers {

    public class Trie{
        Node root;
        public Trie(){
            root = new Node();
        }
    }
    public class Node{
        Map<Integer, Node> edges;
        public Node(){
            edges = new HashMap<>();
        }

        public void add(int x){
            if(edges.get(x)!=null){
                edges.put(x, new Node());
            }
        }
    }

    public void printTrie(Node root, String binary){
       if(root.edges.get(0)==null && root.edges.get(1)==null){
           System.out.println(binary);
           return;
       }
       if(root.edges.get(0)!=null){
           printTrie(root.edges.get(0), binary+"0");
       }
        if(root.edges.get(1)!=null){
            printTrie(root.edges.get(1), binary+"1");
        }
    }

    public int findMaximumXOR(int[] nums) {

        Trie trie = new Trie();
        for(int no: nums){
            Node root = trie.root;
            for(int i=31;i>=0;i--){
                int isBitSet = (no>>i)&1;
                if(isBitSet==1){
                    if(root.edges.get(1)==null) {
                        root.edges.put(1, new Node());
                    }
                    root=root.edges.get(1);
                }else{
                    if(root.edges.get(0)==null) {
                        root.edges.put(0, new Node());
                    }
                    root=root.edges.get(0);
                }
            }
        }
//        printTrie(trie.root, "");

        int max_xor = 0;
        for(int no: nums){
            if(no==5 || no==25){
                no=no;
            }
            Node root = trie.root;
            int prev = 0;
            for(int i=31;i>=0;i--){
                prev = prev*2;
                int isBitSet = (no>>i)&1;
                if(isBitSet==1){
                    if(root.edges.get(0)!=null) {
                        root=root.edges.get(0);
                    }else {
                        root=root.edges.get(1);
                        prev+=1;
                    }

                }else{
                    if(root.edges.get(1)!=null) {
                        root=root.edges.get(1);
                        prev+=1;
                    }else {
                        root=root.edges.get(0);
                    }
                }
            }

            if((no^prev)>max_xor){
                max_xor=(no^prev);
            }
        }

        return max_xor;
    }

    public static void main(String[] args){
        MaximumXORofTwoNumbers mm = new MaximumXORofTwoNumbers();
        System.out.println(mm.findMaximumXOR(new int[]{3, 10, 5, 25, 2, 8}));
    }
}
