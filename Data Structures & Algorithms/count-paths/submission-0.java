class Solution {
    public void findPaths(int[][] grid, int startX, int startY)
    {
        if(startX == grid.length - 1 || startY == grid[0].length - 1) {
            grid[startX][startY] = 1;
            return;
        }

        if(grid[startX + 1][startY] == 0)
            findPaths(grid, startX + 1, startY);
        
        if(grid[startX][startY+1] == 0)
            findPaths(grid, startX, startY + 1);
        
        grid[startX][startY] = grid[startX + 1][startY] + grid[startX][startY + 1];
    }

    public int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];
        findPaths(grid, 0, 0);
        return grid[0][0];
    }
}
