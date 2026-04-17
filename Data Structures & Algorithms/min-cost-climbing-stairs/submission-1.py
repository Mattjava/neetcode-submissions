class Solution:
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        n = len(cost)

        if n == 1:
            return cost[0]
        elif n == 2:
            return min(cost[0], cost[1])

        dp = [0] * (n + 1)

        dp[n-1] = cost[n-1]

        for i in range(n-2, -1, -1):
            dp[i] = cost[i] + min(dp[i+1], dp[i+2])

        return min(dp[0], dp[1])