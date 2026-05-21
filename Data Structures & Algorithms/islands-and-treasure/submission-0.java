class Solution {
    public void islandsAndTreasure(int[][] grid) {
        final int INF = 2147483647;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == INF) {

                    Queue<int[]> queue = new LinkedList<>();
                    Set<String> visited = new HashSet<>();

                    queue.offer(new int[]{i, j});
                    visited.add(i + ":" + j);

                    grid[i][j] = findTreasure(grid, visited, queue);
                }
            }
        }
    }

    private int findTreasure(int[][] grid, Set<String> visited, Queue<int[]> queue) {

        final int ROWS = grid.length;
        final int COLS = grid[0].length;

        int distance = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                int[] rowCol = queue.poll();

                int row = rowCol[0];
                int col = rowCol[1];

                if (grid[row][col] == 0) {
                    return distance;
                }

                int[][] neighbours = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

                for (int[] neighbour : neighbours) {

                    int nr = row + neighbour[0];
                    int nc = col + neighbour[1];

                    String nextKey = nr + ":" + nc;

                    if (nr < 0 || nc < 0 || nr == ROWS || nc == COLS || visited.contains(nextKey) || grid[nr][nc] == -1) {
                        continue;
                    }

                    queue.offer(new int[]{nr, nc});
                    visited.add(nextKey);
                }
            }

            distance++;
        }

        return INF_VALUE();
    }

    private int INF_VALUE() {
        return 2147483647;
    }
}
