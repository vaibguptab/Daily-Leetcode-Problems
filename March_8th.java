package Daily_Leetcode_Qs;

import java.util.Arrays;

public class March_8th {
    public static void main(String[] args) {
        int[] piles = {805306368,805306368,805306368};
        System.out.println(Q875_2(piles,
                1000000000));
    }

    public static int Q875_2(int[] piles,int H){
        int start = 1;

        // Maximum speed of eating
        // is the maximum bananas in given piles
        int end = Arrays.stream(piles).max().getAsInt();

        while (start < end) {
            int mid = start + (end - start) / 2;

            // Check if the mid(hours) is valid
            if ((check(piles, mid, H)) == true) {

                // If valid continue to search
                // lower speed
                end = mid;
            }
            else {
                // If cant finish bananas in given
                // hours, then increase the speed
                start = mid + 1;
            }
        }
        return end;
    }

    static boolean check(int[] bananas, int mid_val, int H)
    {
        int time = 0;
        for (int i = 0; i < bananas.length; i++) {

            // to get the ceil value
            if (bananas[i] % mid_val != 0) {

                // in case of odd number
                time += ((bananas[i] / mid_val) + 1);
            }
            else {

                // in case of even number
                time += (bananas[i] / mid_val);
            }
        }

        // check if time is less than
        // or equals to given hour
        if (time <= H) {
            return true;
        }
        else {
            return false;
        }
    }



    private static int Q875(int[] piles, int h) {
        int ans = Integer.MAX_VALUE;
        int start = 1,end = h;
//        for (int e:piles) end = Math.max(end,e);
        while (start<=end){
            int mid = start+(end-start)/2;
            if (isValid(piles,mid,h)) {
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return start;
    }

    private static boolean isValid(int[] piles, int mid,int h) {
        int temp=0;
        for (int e:piles){
            temp+=e/mid;
            if (e%mid !=0)temp++;
        }
        return temp<=h;
    }
}
