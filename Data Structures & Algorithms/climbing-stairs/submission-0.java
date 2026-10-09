class Solution {
    public int climbStairs(int n) {
        if (n<=2) {
            return n;
        }

        int[] dp = new int[]{1, 2};
        int i = 3;

        while (i<=n) {
            int temp = dp[1];
            dp[1] = dp[0] + dp[1];

            dp[0] = temp;
            i++;
        }

        return dp[1];
    }
}
