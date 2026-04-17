class Solution {
    public void backtrack(List<List<Integer>> subsets, List<Integer> subset, List<Integer> nums)
    {
        Integer[] subsetCopy = new Integer[subset.size()];
        subsetCopy = subset.toArray(subsetCopy);

        Arrays.sort(subsetCopy);
        List<Integer> sortedSubset = Arrays.asList(subsetCopy);

        if(!subsets.contains(sortedSubset)) {
            subsets.add(new LinkedList<Integer>(sortedSubset));
        } else 
            return;

        for(int i = 0; i < nums.size(); i++)
        {
            int value = nums.remove(i);
            int index = subset.size();
            subset.add(value);

            backtrack(subsets, subset, nums);

            subset.remove(index);
            nums.add(i, value);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> subsets = new LinkedList<List<Integer>>();
        List<Integer> numsList = new LinkedList<Integer>();

        for(int num : nums)
            numsList.add(num);

        backtrack(subsets, new LinkedList<Integer>(), numsList);

        return subsets;
    }
}
