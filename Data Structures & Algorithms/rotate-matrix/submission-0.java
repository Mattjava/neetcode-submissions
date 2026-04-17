class Solution {
    public void rotate(int[][] matrix) {
        reverse(matrix);

        int start = 0;

        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = start; j < matrix[i].length; j++)
            {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
            start++;
        }
    }


    public void reverse(int[][] matrix) {
        int len = matrix.length;

        for(int i = 0; i < len / 2; i++)
        {
            for(int j = 0; j < matrix[i].length; j++)
            {
                int temp = matrix[len - i - 1][j];
                matrix[len - i - 1][j] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }
}
