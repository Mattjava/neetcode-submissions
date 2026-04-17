class Solution {
    public void findSubsets(List<List<Integer>> list, List<Integer> curr, int[] nums)
    {
        Collections.sort(curr);

        if(!list.contains(curr))
            list.add(new LinkedList<Integer>(curr));
        
        int index = curr.size();

        for(int i = 0; i < nums.length; i++)
        {
            int value = nums[i];

            if(curr.contains(value))
                continue;

            curr.add(value);
            findSubsets(list, new LinkedList<Integer>(curr), nums);
            curr.remove(index);
        }
    }


    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsetsList = new LinkedList<List<Integer>>();
        findSubsets(subsetsList, new LinkedList<Integer>(), nums);
        return subsetsList;
    }
}
