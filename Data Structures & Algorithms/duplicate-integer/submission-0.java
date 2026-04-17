class Solution {
    public boolean hasDuplicate(int[] nums) {
        LinkedList<Integer> numsSeen = new LinkedList<Integer>();

        for(int i = 0; i < nums.length; i++) {
            int value = nums[i];

            if(numsSeen.contains(value))
                return true;
            
            numsSeen.add(value);
        }

        return false;
    }
}