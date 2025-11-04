//풀이수준 : A-, 투포인터
class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int area = (right - left) * Math.min(height[right], height[left]);
            max = Math.max(max, area);
            if (height[right] < height[left]) {
                right--;
            } else {
                left++;
            }
        }
        
        return max;
    }
}