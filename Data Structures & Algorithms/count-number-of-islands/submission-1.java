class Solution {
    public void fill(int x, int y, char[][] grid)
    {
        if(x >= grid.length || x < 0)
            return;
        if(y >= grid[x].length || y < 0)
            return;
        if(grid[x][y] == '0')
            return;
        
        grid[x][y] = '0';

        fill(x+1, y, grid);
        fill(x-1, y, grid);
        fill(x, y+1, grid);
        fill(x, y-1, grid);
    }

    public int numIslands(char[][] grid) {
        int num = 0;

        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[i].length; j++)
            {
                if(grid[i][j] == '1') {
                    num++;
                    fill(i, j, grid);
                }
            }
        }

        return num;
    }
}
