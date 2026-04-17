class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] maxes = new int[nums.length - (k - 1)];

        int start = 0;

        int max = Integer.MIN_VALUE;

        for(int i = 0; i < k; i++)
            max = Math.max(nums[i], max);
        
        maxes[start] = max;

        for(int i = k; i < nums.length; i++)
        {
            start++;
            if(nums[start - 1] == max) {
                max = Integer.MIN_VALUE;
                for(int j = start; j < i; j++) 
                    max = Math.max(nums[j], max);
            }

            if(nums[i] > max) 
                max = nums[i];
            

            maxes[start] = max;
        }

        return maxes;
    }
}
