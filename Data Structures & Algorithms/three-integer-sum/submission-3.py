class Solution:
    def threeSum(self, nums: list[int]) -> list[list[int]]:
        nums.sort()
        res = []
        pairs = {}

        for i in range(len(nums)):
            target = 0 - nums[i]
            sumMap = {}
            for j in range(i+1, len(nums)):
                if nums[j] in sumMap:
                    new = [nums[i], sumMap[nums[j]], nums[j]]
                    if new not in res:
                        res.append(new)
                sumMap[target - nums[j]] = nums[j]
                


        return res
        