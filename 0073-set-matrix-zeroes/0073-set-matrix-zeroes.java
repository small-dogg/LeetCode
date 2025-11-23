class Solution {
    private static final int[] dx = new int[]{0, 1, 0, -1};
    private static final int[] dy = new int[]{1, 0, -1, 0};

    public static void main(String[] args) {
        new Solution().setZeroes(new int[][]{{1,2,3,4},{5,0,7,8},{0,10,11,12},{13,14,15,0}});
    }

    public void setZeroes(int[][] matrix) {
        //모든 1의 위치에서 dx,dy 확장하여 1 채우기
        //방문 배열 필요

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    for (int d = 0; d < 4; d++) {
                        q.offer(new int[]{i, j, d});
                    }
                }
            }
        }

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            int d = now[2];

            int nx = dx[d] + x;
            int ny = dy[d] + y;

            if (nx < 0 || nx >= matrix.length || ny < 0 || ny >= matrix[0].length) continue;
            matrix[nx][ny] = 0;
            q.offer(new int[]{nx, ny, d});
        }
    }
}