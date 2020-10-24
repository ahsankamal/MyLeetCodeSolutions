package WeekOne;

import java.util.HashMap;
import java.util.TreeSet;

public class ContainsDuplicateTwo {


    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        HashMap<Integer, Integer> countMap = new HashMap<>();
        TreeSet<Long> set = new TreeSet<>();
        for(int i=0;i<=k&&i<nums.length;i++){
            set.add((long)nums[i]);
            countMap.put(nums[i], countMap.getOrDefault(nums[i], 0)+1);
        }
//        set.forEach(e->System.out.print(e+", "));
//        System.out.println();
        for(int i=0; i<nums.length-1; i++){
            if(countMap.get(nums[i])==1){
                set.remove((long)nums[i]);
                countMap.remove(nums[i]);
            }else{
                countMap.put(nums[i], countMap.get(nums[i])-1);
            }
//            set.forEach(e->System.out.print(e+", "));
//            System.out.println();
//            System.out.println((long)nums[i]-t +" "+Long.MIN_VALUE+ "<=> "+(long)nums[i]+t+" "+Long.MAX_VALUE);

            Long lower_bound = set.floor((long)nums[i]+t);
            Long upper_bound = set.ceiling((long)nums[i]-t);

            if(lower_bound!=null && upper_bound!=null){
//                System.out.println(lower_bound + ", "+upper_bound);

                if(lower_bound-upper_bound >0 || (lower_bound==upper_bound && Math.abs((long)nums[i]-lower_bound)<=t)){
                    return true;
                }

            }

            if(i+1+k<nums.length){
                set.add((long)nums[i+1+k]);
                countMap.put(nums[i+1+k], countMap.getOrDefault(nums[i+1+k], 0)+1);
            }
        }

        return false;
    }


    public static void main(String[] args){
        ContainsDuplicateTwo containsDuplicate = new ContainsDuplicateTwo();
        System.out.println(containsDuplicate.containsNearbyAlmostDuplicate(new int[]{3,6, 0, 4}, 2, 2));
        System.out.println(containsDuplicate.containsNearbyAlmostDuplicate(new int[]{3,6, 0, 2}, 2, 2));
        System.out.println(containsDuplicate.containsNearbyAlmostDuplicate(new int[]{}, 0, 0));
        System.out.println(containsDuplicate.containsNearbyAlmostDuplicate(new int[]{1}, 1, 1));
        System.out.println(containsDuplicate.containsNearbyAlmostDuplicate(new int[]{-1,2147483647}, 1, 2147483647));
        System.out.println(containsDuplicate.containsNearbyAlmostDuplicate(new int[]{1,5,9,1,5,9}, 2, 3));
        System.out.println(containsDuplicate.containsNearbyAlmostDuplicate(new int[]{1,5,9,1,5,9}, 2, 4));
        System.out.println(containsDuplicate.containsNearbyAlmostDuplicate(new int[]{1,2, 3, 1}, 3, 0));
        System.out.println(containsDuplicate.containsNearbyAlmostDuplicate(new int[]{1,2, 3, 1}, 2, 0));
        System.out.println(containsDuplicate.containsNearbyAlmostDuplicate(new int[]{-2147483648,-2147483647}, 3, 3));

    }
}
