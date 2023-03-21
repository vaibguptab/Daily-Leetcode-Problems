package Daily_Leetcode_Qs;

public class March_21st {
    public static void main(String[] args) {
        int[] nums = {1,3,0,0,2,0,0,4};
        System.out.println(Q2348(nums));
    }

    private static long Q2348(int[] nums) {
        long res=0;
        for (int i=0,j=0;i< nums.length;i++){
            if (nums[i] != 0)
                j = i+1;
            res += i-j+1;
        }
        return res;

    }
}
