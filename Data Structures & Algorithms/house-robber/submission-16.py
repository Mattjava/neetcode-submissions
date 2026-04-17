class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)

        if n == 1:
            return nums[0]

        dp = [0] * n

        dp[n-1] = nums[n-1]
        dp[n-2] = nums[n-2]

        best = dp[n-1]
        index = n - 1

        for i in range(n - 3, -1, -1):
            dp[i] = nums[i] + best
            index -= 1
            best = max(dp[index], best)

        return max(dp[0], dp[1])
        