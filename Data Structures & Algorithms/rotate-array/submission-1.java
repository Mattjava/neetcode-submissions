class Solution {
    public void rotate(int[] nums, int k) {
        int end = k;

        if(k >= nums.length)
            end = k % nums.length;

        int[] copy = new int[nums.length];

        for(int i = 0; i < nums.length; i++)
        {
            copy[i] = nums[i];
        }

        for(int i = 0; i < nums.length; i++)
        {
            int val = copy[i];

            nums[end] = val;

            end++;

            if(end >= nums.length)
                end = 0;
        }
    }
}