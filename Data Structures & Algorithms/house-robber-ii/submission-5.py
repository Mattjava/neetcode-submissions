class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) < 2: 
            return nums[0]
        elif len(nums) < 3: 
            return max(nums[0], nums[1])

        def find(arr: List[int]):
            n = len(arr)
            
            dp = [0] * n

            dp[n-1] = arr[n-1]
            dp[n-2] = arr[n-2]

            bi = n-1
            best = dp[bi]

            for i in range(n-3, -1, -1):
                dp[i] = arr[i] + best
                bi -= 1
                best = max(best, dp[bi])

            return max(dp[0], dp[1])
        return max(find(nums[1:]), find(nums[:-1]))