package WeekFive;

//https://leetcode.com/discuss/explore/september-leetcoding-challenge/871646/First-Missing-Positive-or-C%2B%2B-Two-Solutions-O(N)-Time-100
public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {

        boolean hasOne = false;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0){
                nums[i]=0;
            }else if(nums[i]==1){
                hasOne=true;
            }
        }

        if(!hasOne){
            return 1;
        }

        for(int i=0;i<nums.length;i++){
            int curr = Math.abs(nums[i]);
            if(curr>0 && curr<=nums.length && nums[curr-1]>=0){
                if(nums[curr-1]==0){
                    nums[curr-1]=-1;
                }else{
                    nums[curr-1]=-nums[curr-1];
                }

            }
        }
//        for(int i=0;i<nums.length;i++){
//            System.out.print(nums[i]+ " ");
//        }

        for(int i=0;i<nums.length;i++){
            if(nums[i]>-1){
                return i+1;
            }
        }

        return nums.length+1;
    }

    public static void main(String[] args){
        FirstMissingPositive ff = new FirstMissingPositive();
        System.out.println(ff.firstMissingPositive(new int[]{7,8,9,11,12}));
        System.out.println(ff.firstMissingPositive(new int[]{3,4,-1,1}));
        System.out.println(ff.firstMissingPositive(new int[]{1,2,0}));
    }
}
