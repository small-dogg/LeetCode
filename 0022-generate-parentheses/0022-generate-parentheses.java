class Solution {
    public List<String> generateParenthesis(int n) {
        //만들 수 잇는 괄호의 경우의 수를 모두 나열(틀린것 포함)
        //올바른 괄호 인지 검증해서, 올바르면 만들어진 괄호를 리스트에 담아 제출

        List<String> result = new ArrayList<>();

        generate(n, 0, 0, new StringBuilder(), result);

        return result;
    }

    private void generate(int n, int open, int close, StringBuilder now, List<String> result) {
        if (now.length() == n * 2) {
            if (isBracket(now)) result.add(now.toString());
            return;
        }

        if (open < n) {
            now.append('(');
            generate(n, open + 1, close, now, result);
            now.deleteCharAt(now.length() - 1);
        }

        if (close < open) {
            now.append(')');
            generate(n, open, close + 1, now, result);
            now.deleteCharAt(now.length() - 1);
        }
    }

    private boolean isBracket(StringBuilder now) {
        Stack<Character> stack = new Stack<>();
        for (char c : now.toString().toCharArray()) {
            if (c == '(' || c == '{' || c == '[') stack.push(c);
            else {
                if (stack.isEmpty()) return false;
                if ((c == ')' && stack.pop() != '(') ||
                        (c == '}' && stack.pop() != '{') ||
                        (c == ']' && stack.pop() != '[')) return false;
            }
        }
        return stack.isEmpty();
    }
}