class Solution {
    public int threeSumClosest(int[] nums, int target) {
        //n 길이의 정수 배열 nums와 정수 target이 주어짐
        // 3개의 정수를 nums에서 찾는데, 3개의 정수 합이 target과 가장 근접한 합의 값을 반환

        // 문제유형 유추 : 3개 모두 더해봐서 target과 가장 근접한 합을 구하는 문제로 조합문제로 유추할 수 있으나, nums의 길이가 최대 2001이므로 조합은 불가능.
        // 정렬 이후, 중심축을 잡고 투포인터로 합하여 target과 근접해지는지를 확인하여 풀이.

        //1. 정렬
        Arrays.sort(nums);

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            //투포인터 대상을 i+1부터 nums의 마지막 원소 지점으로 정의
            int a = nums[i];
            int left = i + 1;
            int right = nums.length - 1;

            //left와 right를 더이상 좁힐 수 없을때까지 반복
            while (left < right) {
                int sum = a + nums[left] + nums[right];

                //target과의 크기차이 비교하여 최소값 획득
                if (Math.abs(target - sum) < Math.abs(target - min)) min = sum;
                //target보다 크면 right을 줄이고,
                if (target < sum) {
                    right--;
                } else if (target > sum) {
                    left++;
                } else {
                    return sum;
                }
                //target보다 작으면 left를 늘려
            }
        }

        return min;
    }
}