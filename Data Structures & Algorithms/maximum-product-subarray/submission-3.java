class Solution {
    public int maxProduct(int[] nums) {
        int globalMax = nums[0];

        int max = 1;
        int min = 1;

        for(int i = 0; i < nums.length; i++)
        {
            int product = max * nums[i];

            max = Math.max(Math.max(product, nums[i] * min), nums[i]);
            min = Math.min(Math.min(product, nums[i] * min), nums[i]);

            globalMax = Math.max(globalMax, max);
        }

        return globalMax;
    }
}
