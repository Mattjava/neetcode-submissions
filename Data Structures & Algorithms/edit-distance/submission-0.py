class Solution:
    def minDistance(self, word1: str, word2: str) -> int:
        m = len(word1)
        n = len(word2)
        dp = [[0] * (n + 1) for i in range(m + 1)]

        for i in range(m):
            dp[i][n] = m - i
        
        for i in range(n):
            dp[m][i] = n - i

        for i in range(m - 1, -1, -1):
            for j in range(n - 1, -1, -1):
                if word1[i] == word2[j]:
                    dp[i][j] = dp[i+1][j+1]
                else:
                    insert = dp[i][j+1]
                    delete = dp[i+1][j]
                    replace = dp[i+1][j+1]

                    best = min(insert, min(delete, replace))

                    dp[i][j] = best + 1

        return dp[0][0]