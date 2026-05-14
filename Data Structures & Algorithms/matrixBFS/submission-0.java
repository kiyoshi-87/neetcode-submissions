class Solution {
    public int shortestPath(int[][] grid) {
        int rowLen = grid.length;
        int colLen = grid[0].length;

        if (grid[0][0] == 1 || grid[rowLen - 1][colLen - 1] == 1) {
            return -1;
        }

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.offer(0+":"+0);
        visited.add(0+":"+0);

        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                String rowCol = queue.poll();
                int lastIndex = rowCol.lastIndexOf(":");
                int row = Integer.parseInt(rowCol.substring(0, lastIndex));
                int col = Integer.parseInt(rowCol.substring(lastIndex+1));

                if (row == rowLen-1 && col == colLen-1) {
                    return ans;
                }

                int[][] neighbours = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
                
                for (int[] neighbour : neighbours) {
                    int dr= neighbour[0];
                    int dc = neighbour[1];
                    int nr = row + dr;
                    int nc = col + dc;
                    String nextKey = nr + ":" + nc;

                    if (nr < 0 || nc < 0 ||
                            nr >= rowLen || nc >= colLen ||
                            visited.contains(nextKey) ||
                            grid[nr][nc] == 1) {
                        continue;
                    }

                    visited.add(nextKey);
                    queue.offer(nextKey);
                }
            }
            ans++;
        }
        return -1;
    }
}