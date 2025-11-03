import java.util.*;
//풀이수준: B, 슬라이딩 윈도우와 Set을 활용한 문제풀이
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> window = new HashSet<>();
        //오른쪽 포인터를 늘려가며 새 원소를 윈도우에 추가

        int left = 0;
        for (int right = 0; right < nums.length; right++) {

            if (window.contains(nums[right])) {
                return true;
            }
            
            window.add(nums[right]);
            
            //윈도우의 크기가 k를 초과할 경우 왼쪽 값 제거
            if(right - left >= k){
                window.remove(nums[left++]);
            }
        }
        
        return false;
    }
}