class Solution {
    private static int[] dx = new int[]{-1, 1, 0, 0};
    private static int[] dy = new int[]{0, 0, -1, 1};

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j]) {
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    visited[i][j] = true;
                    if (dfs(0, i, j, board, word, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(int now, int x, int y, char[][] board, String word, boolean[][] visited) {
        if (now == word.length() - 1) return true;

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (nx < 0 || nx >= board.length || ny < 0 || ny >= board[0].length || visited[nx][ny]) continue;

            if (board[nx][ny] == word.charAt(now + 1)) {
                visited[nx][ny] = true;
                if(dfs(now + 1, nx, ny, board, word, visited)){
                    return true;
                }
                visited[nx][ny] = false;
            }
        }

        return false;
    }
}