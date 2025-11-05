//풀이수준 : B-
//투포인터로 접근을 못했고 조합으로 접근했음.. 메모리 초과
//투포인터로 접근했을때도 값을 찾으면 왜 left right를 다 감산하는지몰랐음
//같은게 안나올때까지 while 돌리는 부분도.
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < 0) {
                    left++; // 합 키우기
                } else if (sum > 0) {
                    right--; // 합 줄이기
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while(left < right && nums[left] == nums[left +1]) left++;

                    while(left < right && nums[right] == nums[right-1]) right--;

                    left++;
                    right--;
                }
            }
        }

        return result;
    }
}