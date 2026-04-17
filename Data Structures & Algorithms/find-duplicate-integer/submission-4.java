class Solution {
    public int findDuplicate(int[] nums) {
        for(int num : nums)
        {
            nums[Math.abs(num) - 1] *= -1;

            if(nums[Math.abs(num) - 1] > 0)
                return Math.abs(num);
        }

        return 0;
    }
}
