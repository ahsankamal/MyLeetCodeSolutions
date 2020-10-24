package WeekOne;

import java.util.HashMap;
import java.util.Objects;
import java.util.TreeSet;

public class ContainsDuplicate {

    public static class Pair implements Comparable<Pair>{
        long value;
        long index;
        public Pair(long v, long ind){
            this.value = v;
            this.index = ind;
        }

        @Override
        public int compareTo(Pair o) {
            if(this.value==o.value){
                return Long.compare(this.index, o.index);
            }
            return Long.compare(this.value, o.value);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return value == pair.value &&
                    index == pair.index;
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, index);
        }
    }


    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

//        HashMap<Integer, Integer> countMap = new HashMap<>();
//        for(int i: nums){
//            countMap.put(i, countMap.getOrDefault(i, 0));
//        }


        TreeSet<Pair> set = new TreeSet<>();
        for(int i=0;i<=k&&i<nums.length;i++){
            set.add(new Pair(nums[i], i));
        }
//        set.forEach(e->System.out.print(e.value+" "+e.index+", "));
//        System.out.println();
        for(int i=0; i<nums.length-1; i++){
            set.remove(new Pair(nums[i], i));
//            set.forEach(e->System.out.print(e.value+" "+e.index+", "));
//            System.out.println();
//            System.out.println((long)nums[i]-t +" "+Long.MIN_VALUE+ "<=> "+(long)nums[i]+t+" "+Long.MAX_VALUE);

            Pair lower_bound = set.floor(new Pair((long)nums[i]+t, Long.MAX_VALUE));
            Pair upper_bound = set.ceiling(new Pair((long)nums[i]-t, Long.MIN_VALUE));

            if(lower_bound!=null && upper_bound!=null){
//                System.out.println(lower_bound.value + " "+lower_bound.index + ", "+upper_bound.value + " "+upper_bound.index);

                if(lower_bound.value-upper_bound.value >0 || (lower_bound.value==upper_bound.value && Math.abs((long)nums[i]-lower_bound.value)<=t)){
                    return true;
                }

            }

            if(i+1+k<nums.length){
                set.add(new Pair(nums[i+1+k], i+1+k));
            }
        }

        return false;
    }


    public static void main(String[] args){
        ContainsDuplicate containsDuplicate = new ContainsDuplicate();
//        System.out.println(containsDuplicate.containsNearbyAlmostDuplicate(new int[]{3,6, 0, 4}, 2, 2));
//        System.out.println(containsDuplicate.containsNearbyAlmostDuplicate(new int[]{3,6, 0, 2}, 2, 2));
//        System.out.println(containsDuplicate.containsNearbyAlmostDuplicate(new int[]{}, 0, 0));
//        System.out.println(containsDuplicate.containsNearbyAlmostDuplicate(new int[]{1}, 1, 1));
//        System.out.println(containsDuplicate.containsNearbyAlmostDuplicate(new int[]{-1,2147483647}, 1, 2147483647));
//        System.out.println(containsDuplicate.containsNearbyAlmostDuplicate(new int[]{1,5,9,1,5,9}, 2, 3));
//        System.out.println(containsDuplicate.containsNearbyAlmostDuplicate(new int[]{1,5,9,1,5,9}, 2, 4));
//        System.out.println(containsDuplicate.containsNearbyAlmostDuplicate(new int[]{1,2, 3, 1}, 3, 0));
        System.out.println(containsDuplicate.containsNearbyAlmostDuplicate(new int[]{-2147483648,-2147483647}, 3, 3));

    }
}
