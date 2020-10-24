package WeekFour;

import java.util.*;
import java.util.stream.Collectors;

public class LargestNumber {

    public String largestNumber(int[] nums) {
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Collections.sort(list, (o1,  o2) -> -(o1.toString()+o2.toString()).compareTo(o2.toString()+o1.toString()));
        StringBuilder str = new StringBuilder();
        list.forEach(e -> str.append(e));
        return str.charAt(0)=='0' ? "0" : str.toString();
    }

    public static void main(String[] args){
        LargestNumber ll = new LargestNumber();
        System.out.println(ll.largestNumber(new int[]{3,30,34,5,9}));
        System.out.println(ll.largestNumber(new int[]{3,353,35,5,9}));
        System.out.println(ll.largestNumber(new int[]{0,0}));
        System.out.println(ll.largestNumber(new int[]{824,938,1399,5607,6973,5703,9609,4398,8247}));
    }
}
//38,395
//                        39, 385
//                                353
//                                        35
//                                                35353,35335