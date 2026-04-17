class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;

        int maxArea = 0;

        while(left < right)
        {
            int height = Math.min(heights[left], heights[right]);

            int area = height * (right - left);

            maxArea = Math.max(maxArea, area);

            System.out.println(area);

            if(height == heights[left])
                left++;
            else 
                right--;
            
        }


        return maxArea;
    }
}
