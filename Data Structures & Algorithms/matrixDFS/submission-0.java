class Solution {
    public int countPaths(int[][] grid) {
        return dfs(grid, 0, 0, new HashSet<>());
    }

    private int dfs(int[][] grid, int row, int col, Set<String> visited) {
        // Base Conditions:
        int rowLength = grid.length;
        int colLength = grid[0].length;
        String visit = row + ":" + col;
        if (Math.min(row, col) < 0 ||
                row == rowLength || col == colLength || grid[row][col] == 1 || visited.contains(visit)
        ) {
            return 0;
        }

        if (row == rowLength - 1 && col == colLength - 1) {
            return 1;
        }

        // Add the current element to visited
        visited.add(visit);

        // RECURSIVE CALLS: Count starts for each recursive calls and returns its own count to the upstream
        int count = 0;

        count += dfs(grid, row+1, col, visited);
        count += dfs(grid, row-1, col, visited);
        count += dfs(grid, row, col+1, visited);
        count += dfs(grid, row, col-1, visited);

        // Remove the current element from visited
        visited.remove(visit);

        return count;
    }
}
