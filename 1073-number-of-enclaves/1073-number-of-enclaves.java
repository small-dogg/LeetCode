class Solution {
    //문장 해석이 안됐음... 
    public int numEnclaves(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        //테두리에 인접한 섬 방문처리
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] == 1) {
                dfs(i, 0, grid, visited);
            }

            int bottom = grid[0].length - 1;
            if (grid[i][bottom] == 1) {
                dfs(i, bottom, grid, visited);
            }
        }
        for (int i = 0; i < grid[0].length; i++) {
            if (grid[0][i] == 1) {
                dfs(0, i, grid, visited);
            }

            int right = grid.length - 1;
            if (grid[right][i] == 1) {
                dfs(right, i, grid, visited);
            }
        }

        int result = 0;
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[i].length; j++) {
                if (!visited[i][j] && grid[i][j] == 1) result++;
            }
        }

        return result;
    }

    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    private void dfs(int x, int y, int[][] grid, boolean[][] visited) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + nowX;
                int ny = dy[i] + nowY;

                if (nx < 0 || nx >= m || ny < 0 || ny >= n || grid[nx][ny] == 0 || visited[nx][ny]) continue;
                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny});
            }
        }
    }
}