package WeekTwo;

public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {

        long final_maxp = Integer.MIN_VALUE;
        long sub_maxp = Integer.MIN_VALUE;
        long sub_prod_so_far = Integer.MIN_VALUE;
        int current_subarray_len = 0;
        long pos_prod = Integer.MIN_VALUE;

        int[] m = new int[nums.length];
        int[] n = new int[nums.length];
        m[0] = n[0] = nums[0];

        for(int i=1; i<nums.length;i++){
            m[i] = Math.max(nums[i],m[i-1]*nums[i]);
            m[i] = Math.max(m[i],nums[i]*n[i-1]);

            n[i] = Math.min(nums[i],m[i-1]*nums[i]);
            n[i] = Math.min(n[i], nums[i]*n[i-1]);

        }

        int max = Integer.MIN_VALUE;
        for(int i=0;i<m.length;i++){
            if(m[i]>max){
                max = m[i];
            }
        }
        return max;
    }

    public static void main(String[] args){
        MaximumProductSubarray mps = new MaximumProductSubarray();
        System.out.println(mps.maxProduct(new int[]{2,3,-2,4}));
        System.out.println(mps.maxProduct(new int[]{-2,0,-1}));
        System.out.println(mps.maxProduct(new int[]{3,-1,4,0,-1}));
        System.out.println(mps.maxProduct(new int[]{-1,2,3,5,-2,0,-1,-3,-9,-8}));
        System.out.println(mps.maxProduct(new int[]{1,-1,2,3,5,-2,0,-1,-3,0,-9,-8}));
        System.out.println(mps.maxProduct(new int[]{-8}));
        System.out.println(mps.maxProduct(new int[]{-2, 3, -4}));
        System.out.println(mps.maxProduct(new int[]{2,-5,-2,-4,3}));
    }
}
