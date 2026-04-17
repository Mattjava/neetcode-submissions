class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 1)
            return nums[0];

        int[] amount = new int[n];

        amount[n-1] = nums[n-1];
        amount[n-2] = nums[n-2];

        int houseIndex = n - 1;
        int bestAmount = amount[houseIndex];

        for(int i = n - 3; i > -1; i--)
        {
            amount[i] = nums[i] + bestAmount;

            houseIndex--;

            bestAmount = Math.max(bestAmount, amount[houseIndex]);
        }


        return Math.max(amount[0], amount[1]);
    }
}
