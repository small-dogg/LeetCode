// 풀이수준 : B, 그리디
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        if(s.length == 0) return 0;
        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0;
        int j = 0;
        int result = 0;
        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) {
                i++;
                j++;
                result++;
            } else {
                j++;
            }
        }
        return result;
    }
}