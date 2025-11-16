class Solution {
    public int uniquePaths(int m, int n) {
        //mx그리드에 로봇이
        //로봇은 항상 0,0에 위치
        //무조건 오른쪽 아래로만 이동할 수 있음
        //m, n이 주어졌을때 m-1,n-1로 갈 수 있는 경우의수 구하기

        //백트래킹 필요하고, 방향은 2개

        boolean[][] visited = new boolean[m][n];
        int[][] memo = new int[m][n];
        visited[0][0] = true;
        return dfs(0, 0, visited, memo);
    }

    private int dfs(int x, int y, boolean[][] visited, int[][] memo) {
        //우측 하단에 도달하면 반환
        if (x == visited.length - 1 && y == visited[0].length - 1) return 1;

        //이동불가면 반환
        if (x > visited.length - 1 || y > visited[0].length - 1) return 0;

        if(memo[x][y] !=0) return memo[x][y];

        visited[x][y] = true;
        int dfs = dfs(x + 1, y, visited, memo);
        int dfs1 = dfs(x, y + 1, visited, memo);
        visited[x][y] = false;

        memo[x][y] = dfs+dfs1;

        return memo[x][y];
    }
}