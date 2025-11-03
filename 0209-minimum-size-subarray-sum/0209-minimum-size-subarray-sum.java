//풀이 수준 : B, 슬라이딩 윈도우
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        //슬라이딩 윈도우를 진행하면서, 윈도우 안에서의 합이 target을 만족하는지. 그리고 이 요소의 길이를 가장 짧게해서 그 길이를 반환
        int left = 0;
        int sum = 0;

        int minLen = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            //왼쪽을 줄여가며 최소길이 확인
            while (sum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left++];
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}