class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> decreasingStack = new Stack<Integer>();
        decreasingStack.push(0);
        for(int i = 1; i < temperatures.length; i++) {
            while(!decreasingStack.isEmpty() && temperatures[i] > temperatures[decreasingStack.peek()]) {
                int j = decreasingStack.pop();
                result[j] = i - j;
            } 
            decreasingStack.push(i);
            
        }

        return result;
    }
}
