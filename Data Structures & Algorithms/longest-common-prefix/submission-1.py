class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        if len(strs) == 1:
            return strs[0]

        prefix = ""
        index = 0

        while index < len(strs[0]) and index < len(strs[1]) and strs[0][index] == strs[1][index]:
            prefix += strs[0][index]
            index += 1
        
        print(prefix)
        
        for i in range(2, len(strs)):
            while strs[i][:index+1] != prefix and len(prefix) > 0:
                prefix = prefix[:index]
                index -= 1
        
        return prefix

        