class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] rightBoundaries = new int[heights.length];
        int[] leftBoundaries = new int[heights.length];
        Stack<Integer> boundStack = new Stack<Integer>();

        for(int i = heights.length - 1; i > -1; i--)
        {
            rightBoundaries[i] = heights.length;
            while(!boundStack.isEmpty() && heights[boundStack.peek()] >= heights[i])
                boundStack.pop();

            if(!boundStack.isEmpty())
                rightBoundaries[i] = boundStack.peek();
            
            boundStack.push(i);
        }

        boundStack.clear();

        for(int i = 0; i < heights.length; i++)
        {
            leftBoundaries[i] = -1;
            while(!boundStack.isEmpty() && heights[boundStack.peek()] >= heights[i])
                boundStack.pop();

            if(!boundStack.isEmpty())
                leftBoundaries[i] = boundStack.peek();
            
            boundStack.push(i);
        }

        int maxArea = -1;
        for(int i = 0; i < heights.length; i++) {
            int area = heights[i] * ((rightBoundaries[i] - 1) - (leftBoundaries[i] + 1) + 1);
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }
}
