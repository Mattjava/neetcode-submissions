class Solution {
    public int summation(List<Integer> list)
    {
        int sum = 0;

        for(int num : list)
            sum += num;
        
        return sum;
    }

    public void backtrack(List<List<Integer>> result, List<Integer> path, int[] nums, int target)
    {
        int sum = summation(path);
        if(sum >= target)
        {
            if(sum == target) {
                System.out.println(path + "| " + sum);
                Integer[] pathArr = new Integer[path.size()];
                pathArr = path.toArray(pathArr);
                Arrays.sort(pathArr);
                
                List<Integer> truePath = Arrays.asList(pathArr);

                if(!result.contains(truePath))
                    result.add(truePath);
            }
            return;
        }

        for(int i = 0; i < nums.length; i++)
        {
            int value = nums[i];
            int index = path.size();

            path.add(value);
            backtrack(result, path, nums, target);
            path.remove(index);
        }
        
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        backtrack(result, new LinkedList<Integer>(), nums, target);
        return result;
    }
}
