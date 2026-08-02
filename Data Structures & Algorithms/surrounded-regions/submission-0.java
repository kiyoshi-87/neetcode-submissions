class Solution {
    public void solve(char[][] board) {
        // Approach: Go through boundry O elements, traverse and find all connected
        // Os. So these O values are not covered by X so don't convery!
        
        int m = board.length;
        int n = board[0].length;

        int[][] graph = new int[m][n]; // Graph for pointing out which Os to convert!

        boolean[][] visited = new boolean[m][n]; // Matrix for DFS

        for (int i=0; i<m; i++) {
            if (board[i][0] == 'O' && !visited[i][0]) {
                graph = dfs(board, graph, visited, i, 0);
            }

            if (board[i][n-1] == 'O' && !visited[i][n-1]) {
                graph = dfs(board, graph, visited, i, n-1);
            }
        }

        for (int i=0; i<n; i++) {
            if (board[0][i] == 'O' && !visited[0][i]) {
                graph = dfs(board, graph, visited, 0, i);
            }

            if (board[m-1][i] == 'O' && !visited[m-1][i]) {
                graph = dfs(board, graph, visited, m-1, i);
            }
        }

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (graph[i][j] != 1) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private int[][] dfs(char[][] board, int[][] graph, boolean[][] visited, int row, int col) {
        if (Math.min(row, col) < 0
            || row >= board.length 
            || col >= board[0].length
            || board[row][col] != 'O' 
            || visited[row][col] == true) {
                return graph;
        }

        graph[row][col] = 1;
        visited[row][col] = true;

        graph = dfs(board, graph, visited, row+1, col);
        graph = dfs(board, graph, visited, row-1, col);
        graph = dfs(board, graph, visited, row, col+1);
        graph = dfs(board, graph, visited, row, col-1);

        return graph;
    }
}
