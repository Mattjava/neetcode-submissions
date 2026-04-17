class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0)
            return 0;
        if(nums.length == 1)
            return 1;
        Arrays.sort(nums);

        int count = 1;
        int maxCount = 0;

        for(int i = 0; i < nums.length - 1; i++)
        {
            if(nums[i+1] == nums[i] + 1) {
                System.out.println(nums[i] + " -> " + nums[i+1] + "| " + count);
                count++;
           }  else if(nums[i+1] > nums[i]) {
                count = 1;
            }
            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }
}
