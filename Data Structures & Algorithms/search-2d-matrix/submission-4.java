class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix[0].length;

        int left = 0;
        int right = matrix.length - 1;
        int midpoint = left + ((right - left) / 2);

        while(left < right) {
            if(target <= matrix[midpoint][n-1] && target >= matrix[midpoint][0])
                break;
            else if(target > matrix[midpoint][n-1])
                left = midpoint + 1;
            else
                right = midpoint - 1;


            
            midpoint = left + ((right - left) / 2);
        }

        return Arrays.binarySearch(matrix[midpoint], target) >= 0;
            
    }
}
