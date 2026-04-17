class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        cur = nums[0]
        res = cur
        for i in range(1, len(nums)):
            if cur < 0:
                cur = 0
            cur += nums[i]
            res = max(cur, res)
        return res
        