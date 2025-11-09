class Solution {
    public List<String> letterCombinations(String digits) {
        //2부터 9까지의 숫자를 포함한 String : digits 숫자로 정의할 수 있는 모든 가능한 문자 조합 반환
        // 정렬 상관 없음
        // 각 수마다 3개의 문자가 존재하는데, digits의 최대길이가 4임
        // 그러면 조합 가능 수는 백트래킹 문제인듯?..
        // * 먼저 각 숫자별로 캐릭터 배열 정의
        if (digits == null || digits.isEmpty()) return new ArrayList<>();

        List<String> result = new ArrayList<>();

        // 숫자별 문자 배열 초기화 (초기화 생각하는데 오래걸림) 근데 초기화알게아니라 그냥 하드코딩하면됨..
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        //조합된 문자를 담은 빌더 정의
        StringBuilder sb = new StringBuilder();

        //백트래킹
        dfs(digits, 0, map, sb, result);
        return result;
    }

    //매개정의부터 백트래킹 구현까지 하는방법이 아직도 익숙하지 않음
    private void dfs(String digits, int idx, Map<Character, String> map, StringBuilder sb, List<String> result) {
        //종료조건 : index가 digits의 길이까지 도달
        if (idx == digits.length()) {
            //쌓인 값, 결과로 추가
            result.add(sb.toString());
            return;
        }

        //현재 자리에 해당하는 문자 획득
        char digit = digits.charAt(idx);
        String letters = map.get(digit);

        //가능한 문자들을 하나씩 선택하면서 다음 자리로 진행
        for (int i = 0; i < letters.length(); i++) {
            char ch = letters.charAt(i);

            sb.append(ch);

            //다음 자리로 이동
            dfs(digits, idx + 1, map, sb, result);

            //끝자리 선택을 취소하여 백트래킹
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}