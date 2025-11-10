class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        //n개 정수를 담고있는 nums 배열, 유니크한 4쌍을 반환
        //반환하는 4쌍은
        // 0 <= a,b,c,d <n
        //a,b,c,d는 중복되지 않음(동일한 인덱스를 사용하지 않음)
        // nums[a]+nums[b]+nums[c]+nums[d] == target

        //이중 반복문 + 투포인터 문제 (i,j 를 고정하고 투포인터 진행

        //#1. 정렬
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        //i와 j가 이전 인덱스와 동일 값인 경우, 중복 연산을 피하기 위해 스킵해야함.
        for (int i = 0; i < nums.length - 3; i++) {
            //i 이전인덱스 동일값 스킵(첫번째때는 스킵)
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                //j 이전인덱스 동일값 스킵(첫번째때는 스킵)
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int left = j + 1;
                int right = nums.length - 1;

                //투포인터 진행
                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    

                    if (sum > target) { //right를 왼쪽으로 이동하여 sum값 감소
                        right--;

                    } else if (sum < target) { //left를 오른쪽으로 이동하여 sum값 증가
                        left++;
                    } else { //조건에 일치, 결과값 추가
                        //현재의 포인터 위치 값이 그다음 포인터 위치값과 동일하면 가장 말단에있는 위치값으로 이동시킴(더이상 다음 요소와 같은게 없을때 계산)
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        
                        result.add(List.of(nums[i], nums[j], nums[left], nums[right]));
                        
                        left += 1;
                        right -= 1;
                    }
                }
            }
        }
        return result;
    }
}