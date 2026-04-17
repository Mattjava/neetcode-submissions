class Solution {
    public int findDuplicate(int[] nums) {
        int[] numsCopy = new int[nums.length - 1];

        for(int num : nums) {
            numsCopy[num-1]++;
            if(numsCopy[num-1] > 1)
                return num;
        }

        return -1;
    }
}
