class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        # Store width and length of grid for easy access

        n = len(grid)
        m = len(grid[0])

        # Initialize DP grid
        dp = [[0] * m for i in range(n)]

        # Store very last element of grid into DP grid
        dp[n-1][m-1] = grid[n-1][m-1]

        # Develop a prefix sum array in DP grid based on the last row of grid
        for i in range(m - 2, -1, -1):
            dp[n-1][i] = grid[n-1][i] + dp[n-1][i+1]

        # Develop a prefix sum array in DP grid based on the last column of grid 
        for i in range(n - 2, -1, -1):
            dp[i][m-1] = grid[i][m-1] + dp[i+1][m-1]

        # Set a value in each element in the DP grid
        # The value of dp[i][j] is based on the sum of grid[i][j] and the minimum value of the two elements below and right next to it
        for i in range(n - 2, -1, -1):
            for j in range(m - 2, -1, -1):
                dp[i][j] = grid[i][j] + min(dp[i+1][j], dp[i][j+1])

        # The answer is guaranteed to be in the very first element of the DP grid 
        return dp[0][0]