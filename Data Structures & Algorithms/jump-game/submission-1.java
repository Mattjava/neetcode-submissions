class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;

        int[] jumpPotential = new int[n];

        for(int i = 0; i < n - 1; i++)
            jumpPotential[i] = -1;

        for(int i = n - 2; i > -1; i--)
        {
            for(int j = i + 1; j <= i + nums[i]; j++)
            {
                if(jumpPotential[j] == 0) {
                    jumpPotential[i] = 0;
                    break;
                } 
            }
        }


        return jumpPotential[0] == 0;
    }
}
