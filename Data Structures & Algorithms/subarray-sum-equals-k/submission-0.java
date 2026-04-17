class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int n = nums.length;
        int[] sums = new int[nums.length];

        for(int i = 0; i < n; i++)
        {
            for(int j = i; j > -1; j--)
            {
                sums[j] += nums[i];
                if(sums[j] == k)
                    count++;
            }
        }

        return count;
    }
}