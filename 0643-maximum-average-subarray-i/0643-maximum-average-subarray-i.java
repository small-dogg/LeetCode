//풀이수준 : B, 슬라이딩 윈도우 기초
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        //nums 내 k길이의 원소 합이 가장 큰 값을 구하라.
        int windowsSum = 0;
        for (int i = 0; i < k; i++) {
            windowsSum += nums[i];
        }

        int max = windowsSum;
        for (int i = k; i < nums.length; i++) {
            windowsSum = windowsSum - nums[i - k] + nums[i];
            max = Math.max(windowsSum, max);
        }
        return (double) max / k;
    }
}