class Solution {
    public int[] findBuildings(int[] heights) {
        int n = heights.length;

        int max = heights[n - 1];
        int count = 1;

        boolean[] canSeeOcean = new boolean[n];
        canSeeOcean[n-1] = true;

        for(int i = n - 2; i > -1; i--)
        {
            if(heights[i] > max) {
                count++;
                canSeeOcean[i] = true;
                max = heights[i];
            }
        }

        int[] result = new int[count];
        int iter = 0;

        for(int i = 0; i < n; i++)
        {
            if(canSeeOcean[i]) {
                result[iter] = i;
                iter++;
            }
        }

        return result;
    }
}