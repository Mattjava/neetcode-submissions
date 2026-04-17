class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int[] subLengths = new int[n];

        for(int i = n - 1; i > -1; i--)
        {
            int nextIndex = i;
            int highestLength = 0;

            for(int j = i; j < n; j++)
            {
                if(nums[j] > nums[i] && subLengths[j] > highestLength) {
                    nextIndex = j;
                    highestLength = subLengths[j];
                }
            }

            subLengths[i] = subLengths[nextIndex] + 1;
        }

        int max = 0;

        for(int length : subLengths) 
            max = Math.max(length, max);
        

        return max;
    }
}
