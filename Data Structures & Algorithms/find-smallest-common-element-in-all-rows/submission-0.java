class Solution {
    public int smallestCommonElement(int[][] mat) {
        int[] arr = new int[1001];

        int n = mat.length;
        int m = mat[0].length;

        int min = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                arr[mat[i][j] - 1]++;

                if(arr[mat[i][j] - 1] == n)
                    min = Math.min(mat[i][j], min); 
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
