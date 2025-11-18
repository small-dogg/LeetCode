class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        // mn 배열.
        // 땅을의미하는 1
        // 4방향으로 연결되어있음
        // 최대 크기의 섬 반환

        int maxCnt = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    int area = bfs(i,j,grid,visited);
                    maxCnt = Math.max(maxCnt, area);
                }
            }
        }
        return maxCnt;
    }



    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    private int bfs(int x, int y, int[][] grid, boolean[][] visited) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;

        int area = 1;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + nowX;
                int ny = dy[i] + nowY;

                if (nx <0 || nx >= m || ny <0 || ny >= n) continue;

                if (grid[nx][ny] == 1 && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                    area ++;
                }
            }
        }
        return area;
    }
}