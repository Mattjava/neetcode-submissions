class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int limit = n / 2;

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++)
        {
            int count = map.getOrDefault(nums[i], 0);

            if(++count > limit)
                return nums[i];

            map.put(nums[i], count);
        }

        return -1;
    }
}