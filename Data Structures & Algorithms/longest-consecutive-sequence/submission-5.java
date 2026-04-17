class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0)
            return 0;

        Arrays.sort(nums);
        int count = 1;
        int iter = 0;
        int longestSequenceLength = 0;

        while(iter < nums.length) {
            if(iter != 0 && nums[iter] == nums[iter-1] + 1) {
                count++;
            } else if(iter == 0 || (nums[iter] != nums[iter-1] + 1 && nums[iter] != nums[iter-1])) {
                count = 1;
            }

            longestSequenceLength = Math.max(count, longestSequenceLength);
            iter++;
        }


        return longestSequenceLength;
    }
}
