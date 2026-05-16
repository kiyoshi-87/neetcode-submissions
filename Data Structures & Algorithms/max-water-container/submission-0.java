class Solution {
    public int maxArea(int[] heights) {
        int area = 0;
        int left = 0;
        int right = heights.length - 1;

        while (left<right) {
            int currHeight = Math.min(heights[left], heights[right]);
            int currBreadth = right - left;

            area = Math.max(area, currHeight*currBreadth);

            if (heights[left]>heights[right]) {
                right--;
            } else {
                left++;
            }
        }

        return area;
    }
}
