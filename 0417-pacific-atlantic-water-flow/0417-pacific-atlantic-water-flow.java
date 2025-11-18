class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        //pacific 해안과 atlantic 해안으로 둘러싸진 m*n 사각형 섬이 있음. pacific 해변은 좌상단에 위치, atlantic 해변은 우하단에 위치
        //heights는 각 섬의 좌표별 높이임.
        //섬에 비가 너무많이 내렸고, 빗물은  현재 위치한 셀의 인접한 동서남북방향이 낮거나 같으면 빗물이 그쪽으로 흐를 수 있음
        //그리고 그 빗물은 모서리에있는 그 어떠한 cell에서든지 바다로 흐를 수 있음

        // 바깥쪽으로 물이 흐를 수 있는 상황일때, 그 위치를 각각 반환.
        // 동서남북 방향 각각을 검증하며 바다가아니면 계속 흘러가기

        List<List<Integer>> target = new ArrayList<>();
        boolean[][] pacific = new boolean[heights.length][heights[0].length];
        //Pacific Ocean에서 거슬러 올라가는 BFS
        for (int x = 0; x < heights.length; x++) {
            int y = 0;
            int prev = heights[x][y];
            dfs(x, y, heights, pacific, prev);
        }
        for (int y = 0; y < heights[0].length; y++) {
            int x = 0;
            int prev = heights[x][y];
            dfs(x, y, heights, pacific, prev);
        }

        boolean[][] atlantic = new boolean[heights.length][heights[0].length];
        //Atlantic Ocean에서 거슬러 올라가는 BFS
        for (int x = 0; x < heights.length; x++) {
            int y = heights[0].length - 1;
            int prev = heights[x][y];
            dfs(x, y, heights, atlantic, prev);
        }
        for (int y = 0; y < heights[0].length; y++) {
            int x = heights.length - 1;
            int prev = heights[x][y];
            dfs(x, y, heights, atlantic, prev);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < pacific.length; i++) {
            for (int j = 0; j < pacific[i].length; j++) {
                if (pacific[i][j] && atlantic[i][j]) result.add(List.of(i, j));
            }
        }

        return result;
    }

    private static final int[] dx = new int[]{-1, 1, 0, 0};
    private static final int[] dy = new int[]{0, 0, -1, 1};

    private void dfs(int x, int y, int[][] heights, boolean[][] visited, int prev) {
        if (x < 0 || x >= heights.length || y < 0 || y >= heights[0].length) return;
        if (visited[x][y]) return;
        if (heights[x][y] < prev) return;

        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            dfs(nx, ny, heights, visited, heights[x][y]);
        }
    }
}