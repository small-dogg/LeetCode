class Solution {
    public int[] twoSum(int[] numbers, int target) {
        //numbers라는 정수형 1차원 배열. 오름차순 정렬되어있음
        //2수를 더했을때 지정된 target이 되는, 1<= index1 < index2 <=number.length 를 만족하는 int[] 반환

        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            if(numbers[left] + numbers[right] >target) right--;
            else if(numbers[left] + numbers[right] <target) left++;
            else break;
        }


        //1-based
        return new int[]{left + 1, right + 1};
    }
}