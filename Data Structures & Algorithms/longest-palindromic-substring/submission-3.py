class Solution:
    def longestPalindrome(self, s: str) -> str:
        n = len(s)

        res = s[0]
        resLen = 1

        for i in range(n+1):
            point1 = i - 1
            point2 = i + 1

            while point1 > -1 and point2 < n and s[point1] == s[point2]:
                length = (point2 - point1) + 1

                if length > resLen:
                    resLen = length
                    res = s[point1:point2+1]

                point1 -= 1
                point2 += 1

            point1 = i
            point2 = i + 1

            while point1 > -1 and point2 < n and s[point1] == s[point2]:
                length = (point2 - point1) + 1

                if length > resLen:
                    resLen = length
                    res = s[point1:point2+1]

                point1 -= 1
                point2 += 1
        
        return res