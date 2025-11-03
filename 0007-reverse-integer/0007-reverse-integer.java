class Solution {
    public int reverse(int x) {
        boolean minus = x < 0;
        x = Math.abs(x);
        try {
            int i = Integer.parseInt(new StringBuilder(String.valueOf(x)).reverse().toString());
            return minus ? -i : i;
        } catch (Exception e) {
            return 0;
        }
    }
}