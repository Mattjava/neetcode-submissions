class Solution {
    public int findSum(int[] nums, int target, int index, int sum) {
        if(index == nums.length) {
            if(sum == target)
                return 1;
            return 0;
        }
        int value = nums[index];

        int positiveWay = findSum(nums, target, index + 1, sum + value);
        int negativeWay = findSum(nums, target, index + 1, sum + value * -1);

        return positiveWay + negativeWay;
    }

    public int findTargetSumWays(int[] nums, int target) {
        return findSum(nums, target, 0, 0);
    }
}
