package WeekOne;

import java.util.HashMap;
import java.util.Scanner;

public class WordPattern {

    public boolean wordPattern(String pattern, String str) {

        String[] str_words = str.split(" ");
        HashMap<Character, String> map = new HashMap<>();
        HashMap<String, Character> reverse_map = new HashMap<>();

        if(str_words.length != pattern.length()){
            return false;
        }

        for(int i=0; i<pattern.length(); i++){
//            System.out.println(pattern.charAt(i)+" "+str_words[i]+" "+map.get(pattern.charAt(i)));
            if(map.get(pattern.charAt(i))!=null && !map.get(pattern.charAt(i)).equals(str_words[i]) || (reverse_map.get(str_words[i])!=null && !reverse_map.get(str_words[i]).equals(pattern.charAt(i)))){
                return false;
            }
            map.put(pattern.charAt(i), str_words[i]);
            reverse_map.put(str_words[i], pattern.charAt(i));
        }
        return true;
    }


    public static void main(String[] args){
        WordPattern wp = new WordPattern();
        System.out.println(wp.wordPattern("abba", "dog cat cat dog"));
        System.out.println(wp.wordPattern("abba", "dog cat cat fish"));
        System.out.println(wp.wordPattern("aaaa", "dog cat cat dog"));
        System.out.println(wp.wordPattern("abba", "dog dog dog dog"));
    }
}
