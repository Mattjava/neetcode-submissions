class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;
        int sum = numbers[start] + numbers[end];

        while(sum != target) {
            if(sum > target)
                end--;
            else if(sum < target)
                start++;
            
            sum = numbers[start] + numbers[end];
        }

        int[] result = {start + 1, end + 1};

        return result;
    }
}
