package WeekThree;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        String[] arr = s.split(" ");
        if(arr.length==0){
            return 0;
        }
        return arr[arr.length-1].length();
    }
}
//https://leetcode.com/discuss/explore/september-leetcoding-challenge/847546/Length-of-Last-Word-or-Java-or-Beats-100-or-Simple-and-Explained