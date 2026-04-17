class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] left = new int[n];
        left[0] = nums[0];

        int[] right = new int[n];
        right[n-1] = nums[n-1];

        int[] result = new int[n];

        for(int i = 1; i < n; i++)
            left[i] = nums[i] * left[i-1];

        for(int i = n - 2; i > -1; i--)
            right[i] = nums[i] * right[i+1];

        result[0] = right[1];
        result[n-1] = left[n-2];

        for(int i = 1; i < n - 1; i++)
            result[i] = left[i-1] * right[i+1];

        return result;
    }
}  
