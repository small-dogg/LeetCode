class Solution {
    public void moveZeroes(int[] nums) {
        //0을 무조건 뒤로보내버려.
        int slow = 0;

        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                nums[slow++] = nums[fast];
            }
        }

        for (int i = slow; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}