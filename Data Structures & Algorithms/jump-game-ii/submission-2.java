class Solution {
    public int jump(int[] nums) {
        int frog = 0;
        int count = 0;
        while(frog != nums.length - 1) {
            int limit = frog + nums[frog] + 1;

            if(limit >= nums.length) {
                count++;
                break;
            }

            int bestPosition = limit - 1;
            int bestJump = nums[bestPosition];

            for(int i = frog + 1; i < limit; i++)
            {
                if(nums[i] >= nums[frog])
                {
                    bestPosition = i;
                    bestJump = nums[i];
                }
            }

            frog = bestPosition;
            count++;
        }

        return count;
    }
}
