class Solution {
    public void generateSubset(List<List<Integer>> subsets, List<Integer> subset, int[] nums, int listIndex, int arrIndex) {
        if(arrIndex == nums.length) 
            return;
        
        subset.add(nums[arrIndex]);

        if(subsets.contains(subset))
            return;
        
        subsets.add(new LinkedList<Integer>(subset));

        generateSubset(subsets, subset, nums, listIndex + 1, arrIndex + 1);

        subset.remove(listIndex);

        generateSubset(subsets, subset, nums, listIndex, arrIndex + 1);
    }


    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new LinkedList<List<Integer>>();
        subsets.add(new LinkedList<Integer>());
        generateSubset(subsets, new LinkedList<Integer>(), nums, 0, 0);
        return subsets;

    }
}
