class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        else if(nums.length == 2)
            return Math.max(nums[0], nums[1]);

        int n = nums.length;

        int[] money = new int[n];
        money[n-1] = nums[n-1];
        money[n-2] = nums[n-2];

        int bestChoice = nums[n-1];

        for(int i = n - 3; i > -1; i--)
        {
            money[i] = nums[i] + bestChoice;
            bestChoice = Math.max(bestChoice, money[i+1]);
        }

        return Math.max(money[0], money[1]);
    }
}
