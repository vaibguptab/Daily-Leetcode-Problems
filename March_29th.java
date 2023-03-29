package Daily_Leetcode_Qs;

import java.util.Arrays;

public class March_29th {
    public static void main(String[] args) {
        int[] satisfaction = {-1,-8,0,5,-9};
        int n = satisfaction.length;
        System.out.println(Q1402(satisfaction,0,0));
        int[][] t = new int[n+1][n+1];
        for (int[] e:t) Arrays.fill(e,-1);
        System.out.println(Q1402Memo(satisfaction,0,0,t));
        System.out.println(Q1402Tabulation(satisfaction));

        System.out.println(maxSatisfaction(satisfaction));
    }

    public static int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int ans=0,suf=0,t=0;
        for(int i=satisfaction.length-1;i>=0;i--){
            suf+=satisfaction[i];
            t+=suf;
            ans=Math.max(ans,t);
        }
        return ans;
    }
    private static int Q1402Tabulation(int[] satisfaction) {
        int n = satisfaction.length;
        int[][] dp = new int[n+1][n+1];

        for (int index = n-1 ;index>=0;index--){
            for (int time = index;time>=0;time--){
                int include = satisfaction[index]*(time+1) + dp[index+1][time+1];
                int exclude = dp[index+1][time];

                dp[index][time] = Math.max(include,exclude);
            }
        }
        return dp[0][0];
    }

    private static int Q1402Memo(int[] satisfaction, int index, int time, int[][] t) {
        if (index==satisfaction.length) return 0;
        if (t[index][time] !=-1) return t[index][time];
        int include = satisfaction[index] * (time+1) + Q1402Memo(satisfaction,index+1,time+1,t);
        int exclude = Q1402Memo(satisfaction,index+1,time,t);
        return t[index][time] = Math.max(include,exclude);
    }

    private static int Q1402(int[] satisfaction,int index , int time) {
        if (index==satisfaction.length) return 0;

        int include = satisfaction[index] * (time+1) + Q1402(satisfaction,index+1,time+1);
        int exclude = Q1402(satisfaction,index+1,time);
        return Math.max(include,exclude);
    }
}
