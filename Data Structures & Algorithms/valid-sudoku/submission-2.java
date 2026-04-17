class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, HashSet<Character>> rowMap = new HashMap<>();
        HashMap<Integer, HashSet<Character>> colMap = new HashMap<>();
        HashMap<Integer, HashSet<Character>> squareMap = new HashMap<>();

        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board.length; j++)
            {
                char value = board[i][j];

                if(value == '.')
                    continue;

                int currentSquare = ((i) / 3) * 3 + ((j) / 3);

                HashSet<Character> row = rowMap.getOrDefault(i, new HashSet<>());
                HashSet<Character> col = colMap.getOrDefault(j, new HashSet<>());
                HashSet<Character> square = squareMap.getOrDefault(currentSquare, new HashSet<>());

                if(row.contains(value) || col.contains(value) || square.contains(value)) 
                    return false;
                

                row.add(value);
                col.add(value);
                square.add(value);

                rowMap.put(i, row);
                colMap.put(j, col);
                squareMap.put(currentSquare, square);
            }
        }

        return true;
    }
}
