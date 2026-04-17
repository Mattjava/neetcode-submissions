class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int n = nums.length;
        
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(0, 1);

        int total = 0;

        for(int i = 0; i < nums.length; i++)
        {
            total += nums[i];
            int difference = total - k;
            count += sumMap.getOrDefault(difference, 0);
            sumMap.put(total, sumMap.getOrDefault(total, 0) + 1);
        }

        System.out.println(sumMap);

        return count;
    }
}