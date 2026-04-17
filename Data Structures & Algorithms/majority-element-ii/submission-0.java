class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int size = nums.length;
        int limit = size / 3;

        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new LinkedList<Integer>();

        for(int i = 0; i < size; i++)
        {
            int val = nums[i];
            map.put(val, map.getOrDefault(val, 0) + 1);

            if(!result.contains(val) && map.get(val) > limit)
                result.add(val);
        }

        return result;
    }
}