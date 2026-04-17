class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = left + ((right - left) / 2);

        while(nums[mid] != target && left < right) {
            if(target > nums[mid])
                left = mid + 1;
            else
                right = mid - 1;
            
            mid = left + ((right - left) / 2);
        }

        if(nums[mid] != target)
            return -1;
        
        return mid;
    }
}
