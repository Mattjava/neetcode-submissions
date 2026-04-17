class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m + 1][n + 1];

        for(int i = m - 1; i > -1; i--) {
            char let1 = text1.charAt(i);

            for(int j = n - 1; j > -1; j--) {
                char let2 = text2.charAt(j);

                int result = Math.max(dp[i+1][j], dp[i][j+1]);

                if(let1 == let2)
                    result = dp[i+1][j+1] + 1;

                dp[i][j] = result;
            }
        }

        for(int[] arr : dp) {
            for(int num: arr)
                System.out.print(num + " ");
            System.out.println();
        }

        return dp[0][0];
    }
}
