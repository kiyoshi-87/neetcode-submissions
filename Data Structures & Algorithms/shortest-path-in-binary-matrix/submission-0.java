class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int rowLen = grid.length;
        int colLen = grid[0].length;

        if (grid[0][0] == 1 || grid[rowLen - 1][colLen - 1] == 1) 
            return -1;

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.offer(0+":"+0);
        visited.add(0+":"+0);

        int ans = 1;
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

                int[][] neighbours = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
                for (int[] neighbour : neighbours) {
                    int r = row + neighbour[0];
                    int c = col + neighbour[1];

                    if (r < 0 || c < 0 || r >= rowLen || c >= colLen ||
                            visited.contains(r + ":" + c) ||
                            grid[r][c] == 1) {
                        continue;
                    }

                    visited.add(r+":"+c);
                    queue.offer(r+":"+c);
                }
            }
            ans++;
        }
        return -1;
    }
}