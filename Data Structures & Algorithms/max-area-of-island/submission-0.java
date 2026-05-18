class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        Set<String> visited = new HashSet<>();
        int ans = 0;

        for (int i=0; i< grid.length; i++) {
            for (int j=0; j<grid[i].length; j++) {
                if (grid[i][j] == 1 && !visited.contains(i +":" + j)) {
                    ans = Math.max(calculateArea(grid, i, j, visited), ans);
                }
            }
        }

        return ans;
    }

    private int calculateArea(int[][] grid, int row, int col, Set<String> visited) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        String nextKey = row + ":" + col;

        if (Math.min(row, col) < 0 || row == ROWS || col == COLS ||
                visited.contains(nextKey) || grid[row][col] == 0 ) {
            return 0;
        }

        visited.add(nextKey);

        int areaDown = calculateArea(grid, row+1, col, visited);
        int areaRight = calculateArea(grid, row, col+1, visited);
        int areaUp = calculateArea(grid, row-1, col, visited);
        int areaLeft = calculateArea(grid, row, col-1, visited);
        
        return areaRight + areaDown + areaUp + areaLeft + 1;
    }
}
