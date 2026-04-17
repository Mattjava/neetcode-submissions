class Solution {
    public int removeElement(int[] nums, int val) {
        int end = nums.length;
        int count = 0;

        for(int i = 0; i < end; i++) {
            if(nums[i] == val)
                count++;
        }

        int stopPoint = end - count;


        int pointer = stopPoint;

        for(int i = 0; i < stopPoint; i++) 
        {
            while(pointer < end && nums[pointer] == val)
                pointer++;

            if(pointer == end)
                break;
            
            if(nums[i] == val) {
                nums[i] = nums[pointer];
                nums[pointer] = val;
                pointer++;
            }
        }

        return stopPoint;
    }
}