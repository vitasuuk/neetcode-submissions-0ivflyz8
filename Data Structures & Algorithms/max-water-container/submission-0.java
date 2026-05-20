class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int biggestArea = 0;

        while(left < right) {
            int currArea = Math.min(heights[left], heights[right]) * (right - left);
            
            if (currArea > biggestArea) {
                biggestArea = currArea;
            }

            if(heights[left] < heights[right]) {
                left++;
            } else { 
                right--;
            }

        }

        return biggestArea;
    }
}
