class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        firstMap = {}
        secondMap = {}

        for i in range(0, len(s)):
            if s[i] not in firstMap:
                firstMap[s[i]] = 1
                continue
            firstMap[s[i]] += 1
        
        for i in range(0, len(t)):
            if t[i] not in secondMap:
                secondMap[t[i]] = 1
                continue
            secondMap[t[i]] += 1


        return firstMap == secondMap
        