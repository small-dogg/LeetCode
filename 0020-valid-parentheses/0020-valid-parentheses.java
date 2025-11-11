class Solution {
    public boolean isValid(String s) {
        //주어진 괄호가 올바른지 확인
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') stack.push(c);
            else {
                if(stack.isEmpty()) return false;
                Character pop = stack.pop();
                switch (c) {
                    case(')') : if(pop != '(') return false; break;
                    case('}') : if(pop != '{') return false; break;
                    case(']') : if(pop != '[') return false; break;
                }
            }
        }

        return stack.isEmpty();   
    }
}