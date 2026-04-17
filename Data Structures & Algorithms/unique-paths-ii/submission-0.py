class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid: List[List[int]]) -> int:
        m = len(obstacleGrid)
        n = len(obstacleGrid[0])

        dp = [[0] * n for i in range(m)]

        dp[m-1][n-1] = 1

        if obstacleGrid[m-1][n-1] == 1:
            return 0

        for i in range(m-2, -1, -1):
            if obstacleGrid[i][n-1] == 1:
                break
            dp[i][n-1] = 1
        
        for i in range(n-2, -1, -1):
            if obstacleGrid[m-1][i] == 1:
                break
            dp[m-1][i] = 1

        for i in range(m-2, -1, -1):
            for j in range(n-2, -1, -1):
                if obstacleGrid[i][j] == 1:
                    dp[i][j] = 0
                    continue

                paths = 0

                if dp[i+1][j] != 0:
                    paths += dp[i+1][j]
                if dp[i][j+1] != 0:
                    paths += dp[i][j+1]

                dp[i][j] = paths


        print(dp)

        return dp[0][0]
        
        