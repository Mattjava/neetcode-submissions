class Solution {
    public int fill(int[][] grid, String text1, String text2, int index1, int index2)
    {
        if(index1 >= text1.length() || index2 >= text2.length())
            return 0;
        if(grid[index1][index2] != -1)
            return grid[index1][index2];

        int result = 0;

        if(text1.charAt(index1) == text2.charAt(index2))
            result = 1 + fill(grid, text1, text2, index1+1, index2+1);
        else
            result = Math.max(fill(grid, text1, text2, index1+1, index2), fill(grid, text1, text2, index1, index2+1));
        
        grid[index1][index2] = result;

        return result;
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int[][] grid = new int[text1.length()][text2.length()];

        for(int i = 0; i < text1.length(); i++)
        {
            for(int j = 0; j < text2.length(); j++)
            {
                grid[i][j] = -1;
            }
        }

        return fill(grid, text1, text2, 0, 0);
    }
}
