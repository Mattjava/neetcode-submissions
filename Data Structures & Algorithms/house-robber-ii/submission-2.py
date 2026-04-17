class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)

        if n == 1:
            return nums[0]

        def dfs(arr):
            m = len(arr)

            if m == 1:
                return arr[0]

            dp = [0] * m

            print(arr)

            dp[m-1] = arr[m-1]
            dp[m-2] = max(arr[m-1], arr[m-2])

            for i in range(m - 3, -1, -1):
                dp[i] = max(arr[i] + dp[i+2], dp[i+1])

            return dp[0]

        return max(dfs(nums[1:]), dfs(nums[:n-1]))
            
            
        