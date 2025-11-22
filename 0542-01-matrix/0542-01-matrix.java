class Solution {
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public int[][] updateMatrix(int[][] mat) {
        //mxn 매트릭스 mat, 각 cell에서 0과 가장 가까운 거리를 배열 반환.
        //각 위치에서 0에 가장 가깝게 도달하는 거리를 채워서 반환.
        Queue<int[]> q = new LinkedList<>();

        int[][] dist = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0) {
                    dist[i][j] = 0;
                    q.offer(new int[]{i, j});
                } else {
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + nowX;
                int ny = dy[i] + nowY;
                if (nx < 0 || nx >= mat.length || ny < 0 || ny >= mat[0].length) continue;

                if (dist[nx][ny] > dist[nowX][nowY] + 1) {
                    dist[nx][ny] = dist[nowX][nowY] + 1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        return dist;
    }
}