class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1)
            return nums[0];

        int[] money = new int[nums.length];

        money[money.length - 1] = nums[nums.length - 1];
        money[money.length - 2] = nums[nums.length - 2];

        int bestChoice = money[money.length - 1];
        int iter = 2;

        for(int i = nums.length - 3; i > -1; i--)
        {
            money[i] = nums[i] + bestChoice;
            bestChoice = Math.max(bestChoice, money[money.length - iter]);
            iter++;
        }

        return Math.max(money[0], money[1]);
    }
}
