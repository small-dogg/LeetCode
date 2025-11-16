class Solution {
    public int numIslands(char[][] grid) {
        //주어진 m x n  2차원 배열( 1은 땅 0은 물)
        //땅의 갯수 반환

        //방문배열 생성
        boolean[][] visited = new boolean[grid.length][grid[0].length];


        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(i, j, grid, visited);
                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(int r, int c, char[][] grid, boolean[][] visited) {
        if (r > grid.length - 1 || r < 0 || c > grid[0].length - 1 || c < 0) return;
        if (grid[r][c] == '0' || visited[r][c]) return;

        visited[r][c] = true;

        dfs(r - 1, c, grid, visited);
        dfs(r + 1, c, grid, visited);
        dfs(r, c - 1, grid, visited);
        dfs(r, c + 1, grid, visited);
    }
}