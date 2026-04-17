class Solution {
    public int count(int[][] grid, int i, int j)
    {
        if(i < 0 || i >= grid.length)
            return 0;
        else if(j < 0 || j >= grid[i].length)
            return 0;
        else if(grid[i][j] == 0)
            return 0;
        
        int islandCount = 1;
        grid[i][j] = 0;

        islandCount += count(grid, i+1, j);
        islandCount += count(grid, i-1, j);
        islandCount += count(grid, i, j+1);
        islandCount += count(grid, i, j-1);


        return islandCount;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[i].length; j++)
            {
                if(grid[i][j] == 1) {
                    int area = count(grid, i, j);
                    maxArea = Math.max(area, maxArea);
                }

            }
        }


        return maxArea;
    }
}
