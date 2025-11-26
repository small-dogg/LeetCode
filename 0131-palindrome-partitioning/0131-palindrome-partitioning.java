class Solution {
    public List<List<String>> partition(String s) {
        //문자열 s. 팔린드롬파티션 가능한 모든 경우의 수 반환

        //문자열 s 로 만들 수 있는 경우의 수를 모두 만들어야해.

        List<List<String>> result = new ArrayList<>();
        backtrack(0, s, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(int start, String s, List<String> path, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<>(path));
        }

        for (int end = start; end < s.length(); end++) {
            String substring = s.substring(start, end + 1);
            if (isPalindrome(substring)) {
                path.add(substring);
                backtrack(end + 1, s, path, result);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String substring) {
        return new StringBuilder(substring).reverse().toString().equals(substring);
    }
}