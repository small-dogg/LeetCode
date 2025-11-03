//풀이수준 : B, 슬라이딩 윈도우
class Solution {
    public int longestOnes(int[] nums, int k) {
        //0을 k개만큼 1로 바꿔서, 가장 긴 연속된 1의 부분 배열길이를 구하라.
        int left = 0;
        int zeros = 0;
        int maxLen = 0;
        for (int right = 0; right < nums.length; right++) {
            if(nums[right] == 0) zeros++;

            while (zeros > k) {
                if (nums[left] == 0) zeros--;
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}