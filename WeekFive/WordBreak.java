package WeekFive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class WordBreak {


    public class TrieNode{
        TrieNode[] array;
        boolean end;
        public TrieNode(){
            array = new TrieNode[26];
        }
    }

    public class Trie{
        TrieNode root;
    }

    public boolean wordBreak(String s, List<String> wordDict) {

        Trie trie = new Trie();
        trie.root = new TrieNode();
        trie.root.end = false;

        for(String word: wordDict){
            TrieNode current = trie.root;
            for(char c: word.toCharArray()){
                if(current.array[c-'a']==null){
                    current.array[c-'a'] = new TrieNode();
                }
                current = current.array[c-'a'];
            }
            current.end = true;
        }

        int[] dp = new int[s.length()];
        for(int i=0;i<s.length();i++){
            dp[i]=0;
        }
        return canSegment(0, s.length(), s, trie.root, dp);

    }

    public boolean canSegment(int i, int n, String s, TrieNode root, int[] dp){
        if(i==n){
            return true;
        }
        if(dp[i]==1){//s[i..n-1] can't be segmented
            return false;
        }

        int from = i;
        TrieNode current = root;
        while(i < n && current.array[s.charAt(i)-'a']!=null) {
            current = current.array[s.charAt(i)-'a'];
            if(current.end && canSegment(i + 1, n, s, root, dp)){
                return true;
            }
            i++;
        }

        dp[from]=1;
        return false;

    }

    public static void main(String[] args){
        WordBreak ww = new WordBreak();
//        System.out.println(ww.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
//        System.out.println(ww.wordBreak("applepenapple", Arrays.asList("apple","pens","pen")));
        System.out.println(ww.wordBreak("abcd", Arrays.asList("a","abc","b","cd")));

//        "abcd"
//[]
    }

}

////        for(Character c: s.toCharArray()){
////            if (current.array[c-'a']!=null){
////                current=current.array[c-'a'];
////            }else if(current!=trie.root){
////                if(current.end!=true){
////                    return false;
////                }
////                current=trie.root;
////                if (current.array[c-'a']!=null){
////                    current=current.array[c-'a'];
////                }else{
////                    return false;
////                }
////            }else{
////                return false;
////            }
////        }