import java.util.*;

class Solution {
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();

        String currStr = "";
        int currNum = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                currNum = currNum * 10 + c - '0';
            } else if (c == '[') {
                numStack.push(currNum);
                strStack.push(currStr);
                currNum = 0;
                currStr = "";

            } else if (c == ']') {
                Integer num = numStack.pop();
                String str = strStack.pop();

                String repeat = currStr.repeat(num);
                currStr = str + repeat;
            } else {
                currStr += c;
            }
        }

        return currStr;
    }

}
