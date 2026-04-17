class Solution {
    public int maxProduct(int[] nums) {
        int globalMax = nums[0];

        int min = 1;
        int max = 1;

        for(int i = 0; i < nums.length; i++)
        {
            int product = nums[i] * max;

            max = Math.max(Math.max(product, nums[i] * min), nums[i]);
            min = Math.min(Math.min(product, nums[i] * min), nums[i]);

            globalMax = Math.max(globalMax, max);
        }

        return globalMax;
    }
}
