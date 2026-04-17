class Solution {
    public int removeDuplicates(int[] nums) {
        int uniqueSpot = 0;

        HashSet<Integer> set = new HashSet<>();

        for(int i : nums)
            set.add(i);

        int point = set.size();
        HashSet<Integer> seen = new HashSet<>();

        for(int i = 0; i < nums.length; i++)
        {
            if((i == 0 || nums[i] != nums[i-1]) && !seen.contains(nums[i])) {
                int temp = nums[i];
                nums[i] = nums[uniqueSpot];
                nums[uniqueSpot] = temp;

                seen.add(temp);
                uniqueSpot++;
            }
            if(uniqueSpot == point)
                break;
        }


        return uniqueSpot;
    }
}