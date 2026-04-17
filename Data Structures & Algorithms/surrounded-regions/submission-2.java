class Solution {

    public void fill(char[][] board, int x, int y)
    {
        if(x == board.length || x < 0)
            return;
        if(y == board[x].length || y < 0)
            return;
        if(board[x][y] == 'X')
            return;

        board[x][y] = 'X';

        int[] directions = {-1, 1};

        for(int direct : directions) {
            fill(board, x + direct, y);
            fill(board, x, y + direct);
        }
    }

    public boolean isSurrounded(char[][] board, int[][] markedGrid, int x, int y)
    {
        if(x == board.length || x < 0)
            return false;
        if(y == board[x].length || y < 0)
            return false;
        if(board[x][y] == 'X' || markedGrid[x][y] == 1) 
            return true;

        markedGrid[x][y] = 1;

        if(x == board.length - 1 || x == 0) {
            return false;
        } if(y == board[x].length - 1 || y == 0){
            return false;
        }

        
        boolean isSurrounded = true;

        int[] directions = {-1, 1};

        for(int direct : directions)
        {
            isSurrounded = isSurrounded && isSurrounded(board, markedGrid, x + direct, y);
            isSurrounded = isSurrounded && isSurrounded(board, markedGrid, x, y + direct);
        }

        return isSurrounded;
    }

    public void solve(char[][] board) {
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[i].length; j++)
            {
                if(board[i][j] == 'X')
                    continue;

                if(isSurrounded(board, new int[board.length][board[0].length], i, j))
                    fill(board, i, j);
            }
        }
    }
}
