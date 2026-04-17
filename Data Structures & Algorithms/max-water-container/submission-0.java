class Solution {
    public int maxArea(int[] heights) {
        int start = 0;
        int end = heights.length - 1;

        int maxArea = Integer.MIN_VALUE;

        while(start != end) {
            int height = Math.min(heights[start], heights[end]);
            int width = end - start;

            maxArea = Math.max(maxArea, height * width);

            if(heights[start] < heights[end])
                start++;
            else
                end--;
        }

        return maxArea;
    }
}
