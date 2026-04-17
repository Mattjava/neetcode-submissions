class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;

        int[] ans = new int[n * 2];

        int midIter = n;

        for(int i = 0; i < n; i++)
        {
            int value = nums[i];
            ans[i] = value;
            ans[midIter] = value;

            midIter++;
        }

        return ans;
    }
}