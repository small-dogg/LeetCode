class Solution {
    public int search(int[] nums, int target) {
        //오름차순 nums 배열. nums로부터 target을 참는 함수 작성. 만약 target이 존재하면, index를 반환 아니면 -1 O(log n)으로 짤 것.

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right =  mid - 1;
            }
        }
        return -1;
    }
}