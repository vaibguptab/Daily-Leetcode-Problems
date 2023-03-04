package Daily_Leetcode_Qs;

import java.lang.reflect.Array;

public class March_4th {
    public static void main(String[] args) {
        int[] nums = {1,3,5,2,7,5};
        int mink = 1,maxk =5;
        System.out.println(Q2444(nums,mink,maxk));
    }

    private static int Q2444(int[] nums, int mink, int maxk) {
        int count=0;
        int n = nums.length;
        int leftbound = -1,lastmin=-1,lastmax=-1;
        for (int i=0;i< nums.length;i++){
            if (nums[i] >= mink && nums[i]<=maxk){
                lastmin = (nums[i]==mink)? i : lastmin;
                lastmax = (nums[i]==maxk)? i : lastmax;
                count += Math.max(0,Math.min(lastmin,lastmax)-leftbound);
            }else{
                leftbound = i;
                lastmin = -1;
                lastmax = -1;
            }
        }
        return count;
    }

}
