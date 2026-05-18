class Solution {
    public int numIslands(char[][] grid) {
        Set<String> visited = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();

        int ans = 0;
        for (int i=0; i< grid.length; i++) {
            for (int j=0; j<grid[i].length; j++) {
                if (grid[i][j] == '1' && !visited.contains(i +":" + j)) {
                    visited.add(i + ":" + j);
                    queue.offer(new int[]{i, j});
                    ans++;
                    markAllLandAsVisited(grid, visited, queue);
                }
            }
        }

        return ans;
    }

    private void markAllLandAsVisited(char[][] grid, Set<String> visited, Queue<int[]> queue) {
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i=0; i<size; i++) {
                int[][] neighbours = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
                int[] rowCal = queue.poll();

                for (int[] neighbour : neighbours) {
                    int nr = rowCal[0] + neighbour[0];
                    int nc = rowCal[1] + neighbour[1];
                    String nextKey = nr + ":" + nc;

                    if (nr < 0 || nc < 0 || nr >= grid.length || nc >= grid[0].length || visited.contains(nextKey) || grid[nr][nc] == '0') {
                        continue;
                    }

                    queue.offer(new int[]{nr, nc});
                    visited.add(nextKey);
                }
            }
        }
    }
}
