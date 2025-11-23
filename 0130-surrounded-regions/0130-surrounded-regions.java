class Solution {
    private static int[] dx = new int[]{-1, 1, 0, 0};
    private static int[] dy = new int[]{0, 0, -1, 1};

    public void solve(char[][] board) {
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') dfs(i, 0, board, visited);
            if (board[i][board[0].length - 1] == 'O') dfs(i, board[0].length - 1, board, visited);
        }
        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 'O') dfs(0, i, board, visited);
            if (board[board.length - 1][i] == 'O') dfs(board.length - 1, i, board, visited);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 'O' && !visited[i][j]) board[i][j] = 'X';
            }
        }
    }

    private void dfs(int x, int y, char[][] board, boolean[][] visited) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (nx < 0 || nx >= board.length || ny < 0 || ny >= board[0].length || visited[nx][ny]) continue;
            if (board[nx][ny] == 'O') {
                dfs(nx, ny, board, visited);
            }
        }
    }
}