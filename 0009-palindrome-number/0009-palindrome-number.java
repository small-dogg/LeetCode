class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        String s = String.valueOf(x);
        return new StringBuilder(s).reverse().toString().equals(s);
    }
}