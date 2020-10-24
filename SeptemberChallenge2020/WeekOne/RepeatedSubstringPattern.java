package WeekOne;

public class RepeatedSubstringPattern {

    public boolean repeatedSubstringPattern(String s) {

        int len = s.length();
        for(int i=len/2; i>=1; i--){
            if(len%i==0){
                int j = 0;
                boolean valid = true;
                //check whether we can make string from multiple copies of substring of len i
                for(j=0;j<i;j++){
                    for(int k=j+i;k<len;k+=i){
                        if(s.charAt(j)!=s.charAt(k)){
                            valid = false;
                            break;
                        }
                    }
                    if(valid==false){
                        break;
                    }
                }
                if(j==i){
                    return true;
                }
            }
        }
        return false;

    }

    public static void main(String args[]){
        RepeatedSubstringPattern r = new RepeatedSubstringPattern();
        System.out.println(r.repeatedSubstringPattern("abcabcabcabc"));
        System.out.println(r.repeatedSubstringPattern("abab"));
        System.out.println(r.repeatedSubstringPattern("ababa"));
    }
}
