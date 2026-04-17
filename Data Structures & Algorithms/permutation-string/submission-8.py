class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        base = {}
        for char in s1:
            base[char] = base.get(char, 0) + 1

        left = 0
        right = len(s1)

        curr = None

        while right < len(s2) + 1:
            curr = {}

            for i in range(left, right):
                curr[s2[i]] = curr.get(s2[i], 0) + 1

            if curr == base:
                return True

            left += 1
            right += 1

        return False
            

        



        