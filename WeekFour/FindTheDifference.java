package WeekFour;

import java.util.HashMap;
//https://leetcode.com/discuss/explore/september-leetcoding-challenge/861918/Find-the-Difference-or-Java-or-O(1)-Space-or-Simple-Explained
public class FindTheDifference {

    public char findTheDifference1(String s, String t) {

        HashMap<Character, Integer> map = new HashMap<>();
        for(Character c: s.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }

        for(Character c: t.toCharArray()){
            if(map.get(c)==null || map.get(c)==0){
                return c;
            }else{
               map.put(c, map.get(c)-1);
            }
        }
        return ' ';
    }

    public char findTheDifference(String s, String t) {

        int sum_s=0;
        for(Character c: s.toCharArray()){
            sum_s+=c;
        }

        int sum_t=0;
        for(Character c: t.toCharArray()){
            sum_t+=c;
        }

        return (char)(sum_t-sum_s);
    }

    public static void main(String[] arg){
        FindTheDifference ss = new FindTheDifference();
        System.out.println(ss.findTheDifference("abcd", "abcde"));
        System.out.println(ss.findTheDifference("zbeccd", "zbcdece"));
        System.out.println(ss.findTheDifference("abccde", "eacbdlc"));
    }
}
