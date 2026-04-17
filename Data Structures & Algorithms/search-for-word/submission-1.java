class Solution {
    public boolean backtrack(char[][] board, String word, int i, int j)
    {
        if(word.equals(""))
            return true;
        else if(i < 0 || i == board.length)
            return false;
        else if(j < 0 || j == board[i].length)
            return false;
        else if(board[i][j] == ' ' || word.charAt(0) != board[i][j])
            return false;
        
        board[i][j] = ' ';
        String newWord = word.substring(1);

        boolean right = backtrack(board, newWord, i, j+1);
        boolean left = backtrack(board, newWord, i, j-1);
        boolean up = backtrack(board, newWord, i-1, j);
        boolean down = backtrack(board, newWord, i+1, j);

        board[i][j] = word.charAt(0);

        return right || left || up || down;

    }

    public boolean exist(char[][] board, String word) {
        boolean isExist = false;
        char firstLetter = word.charAt(0);

        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[i].length; j++)
            {
                if(backtrack(board, word, i, j)) return true;
            }
        }

        return false;
    }
}
