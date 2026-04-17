class Solution {
    public int rob(int[] nums) {
        int size = nums.length;

        if(size == 1)
            return nums[0];
        else if(size == 2)
            return Math.max(nums[0], nums[1]);

        int[] maxMoney = new int[nums.length];

        maxMoney[size-1] = nums[size - 1];
        maxMoney[size-2] = nums[size - 2];

        int iter = size - 1;
        int bestCase = maxMoney[size-1];

        for(int i = size - 3; i > -1; i--)
        {
            maxMoney[i] = nums[i] + bestCase;
            iter--;
            bestCase = Math.max(maxMoney[iter], bestCase);
        }

        return Math.max(maxMoney[0], maxMoney[1]);
    }
}
