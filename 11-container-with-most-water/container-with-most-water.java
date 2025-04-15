class Solution {
    public int maxArea(int[] height) {
        if(height.length == 0){
            return 0;
        }

        int max = 0;
        int left = 0;
        int right = height.length -1;

        while(left < right){
            // create width
            int width = right - left;
            // calculate area of to stre water
            int area = Math.min(height[left], height[right]) * width;

            // upadte our max value
            max = Math.max(max, area);

            // upadte pointer
            if(height[left] <= height[right]){
                left ++;
            }else{
                right --;
            }
        }

        return max;
    }
}