class Solution {
    private static final int[] dx = new int[]{0, 1, 0, -1};
    private static final int[] dy = new int[]{1, 0, -1, 0};

    public List<Integer> spiralOrder(int[][] matrix) {
        //m*n ㅓmatrix
        // spiral 정렬안에서 매트릭스 모든 요소를 반환
        // spiral 은 아마도 달팽이를 의미하는 듯. 우,하, 좌,상

        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        List<Integer> resultList = new ArrayList<>();
        int x = 0;
        int y = 0;
        int d = 0;

        int count = 0;
        while (count < matrix.length * matrix[0].length) {
            resultList.add(matrix[x][y]);
            count++;
            visited[x][y] = true;

            int nx = x + dx[d];
            int ny = y + dy[d];

            boolean out = nx < 0 || nx >= matrix.length || ny < 0 || ny >= matrix[0].length;
            if (out || visited[nx][ny]) {
                d = (d + 1) % 4;
                nx = x + dx[d];
                ny = y + dy[d];
            }
            x = nx;
            y = ny;
        }

        return resultList;
    }
}