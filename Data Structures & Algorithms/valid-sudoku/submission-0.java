class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, HashSet<Character>> squares = new HashMap<>();

        // Row & Squares
        for(int row = 0; row < 9; row++)
        {
            HashSet<Character> rowSet = new HashSet<>();
            for(int i = 0; i < 9; i++) {
                char value = board[row][i];
                if(value != '.') {
                    if(rowSet.contains(value))
                        return false;
                    rowSet.add(value);

                    int squareIndex = (row / 3) * 3 + (i / 3);
                    HashSet<Character> foundDigit;

                    if(!squares.containsKey(squareIndex)) {
                        foundDigit = new HashSet<Character>();
                        foundDigit.add(value);
                    } else {
                        foundDigit = squares.get(squareIndex);
                        if(foundDigit.contains(value))
                            return false;
                        foundDigit.add(value);
                    }
                    squares.put(squareIndex, foundDigit);

                }
            }

            System.out.println();
        }

        // Column

        for(int column = 0; column < 9; column++)
        {
            HashSet<Character> columnSet = new HashSet<>();
            for(int i = 0; i < 9; i++) {
                char value = board[i][column];
                if(value != '.') {
                    if(columnSet.contains(value))
                        return false;
                    columnSet.add(value);
                }
            }
        }

        return true;
    }
}
