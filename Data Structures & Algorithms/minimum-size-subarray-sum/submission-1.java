class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int start = 0;
        int size = Integer.MAX_VALUE;

        for(int end = 0; end < nums.length; end++)
        {
            sum += nums[end];

            if(sum >= target) {
                size = Math.min(size, end - start + 1);

                while(sum >= target) {
                    start++;
                    sum -= nums[start - 1];

                    if(sum >= target)
                        size = Math.min(size, end - start + 1);
                }
            }
        }

        if(size == Integer.MAX_VALUE)
            size = 0;

        return size;
    }
}