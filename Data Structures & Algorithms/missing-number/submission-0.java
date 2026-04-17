class Solution {
    public int missingNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int num : nums)
            set.add(num);

        for(int i = 0; i < set.size() + 1; i++) {
            if(!set.contains(i))
                return i;
        }

        return -1;
    }
}
