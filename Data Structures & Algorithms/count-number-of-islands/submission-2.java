class Solution {
    public void mark(char[][] grid, int x, int y)
    {
        if(x < 0 || x >= grid.length)
            return;
        if(y < 0 || y >= grid[x].length)
            return;
        if(grid[x][y] == '0' || grid[x][y] == '!')
            return;

        grid[x][y] = '!';

        int iter = 1;

        mark(grid, x + iter, y);
        mark(grid, x, y + iter);

        iter *= -1;

        mark(grid, x + iter, y);
        mark(grid, x, y + iter);
    }

    public int numIslands(char[][] grid) {
        int num = 0;

        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[i].length; j++)
            {
                if(grid[i][j] == '1') {
                    num++;
                    mark(grid, i, j);
                    print(grid);
                }
            }
        }


        return num;
    }

    public void print(char[][] grid)
    {
        for(char[] row : grid)
        {
            for(char sym : row)
            {
                System.out.print(sym + " ");
            }
            System.out.println();
        }

        System.out.println();
    }
}
