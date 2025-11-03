class Solution {
    public int myAtoi(String s) {
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)!= ' ') {
                start = i;
                break;
            }
        }

        if (s.isEmpty()) return 0;

        boolean isMinus = false;

        if (s.charAt(start) == '+') {
            start++;
        } else if (s.charAt(start) == '-') {
            isMinus = true;
            start++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = start; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                sb.append(s.charAt(i) - '0');
            } else {
                break;
            }
        }

        String string = sb.toString();
        if(string.isEmpty()) return 0;
        try {
            return isMinus ? -Integer.parseInt(string) : Integer.parseInt(string);
        } catch (Exception e) {
            return isMinus ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        //공백 무시
        //부호 판별 - 또는 +
        //
    }
}