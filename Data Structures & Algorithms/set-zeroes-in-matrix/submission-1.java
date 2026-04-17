class Solution {
    public void setColumnZeroes(int column, int[][] matrix, int[][] marker)
    {
        for(int i = 0; i < matrix.length; i++) {
            if(matrix[i][column] != 0)
                marker[i][column] = 1;

            matrix[i][column] = 0;
        }
        
    }

    public void setRowZeroes(int row, int[][] matrix, int[][] marker)
    {
        for(int i = 0; i < matrix[row].length; i++) {
            if(matrix[row][i] != 0)
                marker[row][i] = 1;

            matrix[row][i] = 0;
        }
    }

    public void setZeroes(int[][] matrix) {
        int[][] marker = new int[matrix.length][matrix[0].length];

        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[i].length; j++)
            {
                if(matrix[i][j] == 0 && marker[i][j] != 1) {
                    setColumnZeroes(j, matrix, marker);
                    setRowZeroes(i, matrix, marker);
                }
            }
        }
    }
}
