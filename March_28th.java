package Daily_Leetcode_Qs;

public class March_28th {
    public static void main(String[] args) {

    }
    public int mincostTickets(int[] days, int[] costs) {
        int lastDay = days[days.length - 1];
        int[] dp = new int[lastDay + 1];
        boolean[] isTravelDays = new boolean[lastDay + 1];
        for(int day : days) isTravelDays[day] = true;

        for(int i = 1; i <= lastDay; i++) {
            if(!isTravelDays[i]) {
                dp[i] = dp[i - 1];
                continue;
            }
            // select which type of ticket to buy
            dp[i] = costs[0] + dp[i - 1]; // 1-day
            dp[i] = Math.min(costs[1] + dp[Math.max(i - 7, 0)], dp[i]); // 7-day
            dp[i] = Math.min(costs[2] + dp[Math.max(i - 30, 0)], dp[i]); // 30-day
        }
        return dp[lastDay];
    }
}
