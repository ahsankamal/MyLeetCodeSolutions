package WeekTwo;

import java.util.HashMap;
import java.util.Map;

public class BullsAndCows {
    public String getHint(String secret, String guess) {

        int bulls=0;
        int cows=0;

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<secret.length();i++){
            if(secret.charAt(i)==guess.charAt(i)){
                bulls++;
            }else{
                map.put(Character.getNumericValue(secret.charAt(i)), map.getOrDefault(Character.getNumericValue(secret.charAt(i)), 0)+1);
            }
        }

        map.forEach((k,v)->System.out.print(k+" "+v+","));
        System.out.println();
        for(int i=0;i<guess.length();i++){
            if(secret.charAt(i) != guess.charAt(i)){

                Integer val = map.get(Character.getNumericValue(guess.charAt(i)));
                if(val!=null && val!=0){
                    cows++;
                    map.put(Character.getNumericValue(guess.charAt(i)), map.get(Character.getNumericValue(guess.charAt(i)))-1);
                }
            }

        }

        return bulls+"A"+cows+"B";
    }
    public static void main(String[] args){
        BullsAndCows bc = new BullsAndCows();
//        System.out.println(bc.getHint("1807", "7810"));
//        System.out.println(bc.getHint("1123", "0111"));
        System.out.println(bc.getHint("011123279", "011123270"));
    }
}
