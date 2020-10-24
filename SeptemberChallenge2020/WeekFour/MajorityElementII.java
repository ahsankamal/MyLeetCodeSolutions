package WeekFour;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//TODO
//https://gregable.com/2013/10/majority-vote-algorithm-find-majority.html

public class MajorityElementII {

    public List<Integer> majorityElement(int[] nums) {

        List<Integer> list = new ArrayList<>();
        int count = 0;
        if(nums.length==0){
            return list;
        }
        int candidate=nums[0];
        for(Integer e: nums){
            if(count==0){
                candidate=e;
            }
            if(candidate==e){
                count++;
                if(count==1+nums.length/3){
                    if(list.size()==0 || list.size()>0 && list.get(list.size()-1)!=candidate){
                        list.add(e);
                    }
                    count=0;
                }
            }else {
                count--;
                if(count==0){
                    candidate=e;
                    count++;
                }
            }
        }
        count=0;
//        if(list.size()>0 && list.get(list.size()-1)==candidate){
//            return list;
//        }
        for(Integer e: nums){
            if(candidate==e){
                count++;
                if(count==1+nums.length/3){
                    if(list.size()==0 || list.size()>0 && list.get(list.size()-1)!=candidate){
                        list.add(e);
                    }
                    break;
                }
            }
        }

        return list;
    }


    public static void main(String[] args){
        MajorityElementII mm = new MajorityElementII();
        System.out.println(mm.majorityElement(new int[]{3,0,3,4}));
        System.out.println(mm.majorityElement(new int[]{1,3,3,4}));
        System.out.println(mm.majorityElement(new int[]{0,3,4,0}));
        System.out.println(mm.majorityElement(new int[]{2,2}));
        System.out.println(mm.majorityElement(new int[]{1,2}));
        System.out.println(mm.majorityElement(new int[]{1,1,1,3,3,2,2,2}));
        System.out.println(mm.majorityElement(new int[]{3,2,3}));
        System.out.println(mm.majorityElement(new int[]{1,1,1,1,3,2,2,2,2}));
    }
}

