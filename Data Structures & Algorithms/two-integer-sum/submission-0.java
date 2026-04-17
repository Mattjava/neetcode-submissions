class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> sums = new HashMap<>();
        

        for(int i = 0; i < nums.length; i++) {
            if(sums.containsKey(target - nums[i])) {
                int[] pair = new int[2];
                pair[0] = sums.get(target - nums[i]);
                pair[1] = i;
                return pair;
            }

            sums.put(nums[i], i);
        }

        return new int[2];
    }
}
