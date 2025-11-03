//다시풀어보기
//풀이수준 : B-, 각 i값에 대해 늘려가면서 구하면 될 것이라는 짐작이 안됐음..
class Solution {
    public String longestPalindrome(String s) {
        //문자열의 모든 위치를 중심(center)로 잡고, 양쪽으로 확장(expand)하면서 펠린드롭이 유지되는 최대 길이를 구함.
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len = Math.max(expand(s, i, i + 1), expand(s, i, i));
            if (len > end - start + 1) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}