package WeekTwo;
//https://leetcode.com/discuss/explore/september-leetcoding-challenge/846166/DP-Explained-or-Java-or-House-Robber
public class HouseRobber {

    public int rob(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }

        int dp_prev_2 = nums[0];
        int dp_prev_1 = Math.max(dp_prev_2, nums[1]);
        int i = 2;
        while (i<nums.length){
            if(nums[i]+dp_prev_2 > dp_prev_1){
                int tmp = dp_prev_2;
                dp_prev_2 = dp_prev_1;
                dp_prev_1 = nums[i]+tmp;
            }else{
                dp_prev_2 = dp_prev_1;
            }
            i++;
        }

        return dp_prev_1;
    }

    public static void main(String[] args){
        HouseRobber houseRobber = new HouseRobber();
        System.out.println(houseRobber.rob(new int[]{2,4,8,9,9,3}));
        System.out.println(houseRobber.rob(new int[]{1,7,1,3,9, 2}));
        System.out.println(houseRobber.rob(new int[]{2,7,9,3,1}));
        System.out.println(houseRobber.rob(new int[]{2,9,9,5,1,1,9}));
    }
}
