class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        uniSet = set()

        for num in nums:
            if num in uniSet:
                return True
            uniSet.add(num)

        return False
        