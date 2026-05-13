class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int elem = image[sr][sc];

        return dfsFF(image, sr, sc, color, new HashSet<>(), elem);
    }

    private int[][] dfsFF(int[][] grid, int row, int col, int color, Set<String> visited, int elem) {
        int rowLength = grid.length;
        int colLength = grid[0].length;
        String visit = row + ":" + col;

        if (Math.min(row, col) < 0 ||
                row == rowLength || col == colLength || visited.contains(visit) || elem!=grid[row][col]
        ) {
            return grid;
        }
        
        grid[row][col] = color;
        visited.add(visit);
        
        dfsFF(grid, row+1, col, color, visited, elem);
        dfsFF(grid, row, col+1, color, visited, elem);
        dfsFF(grid, row-1, col, color, visited, elem);
        dfsFF(grid, row, col-1, color, visited, elem);
        
        return grid;
    }
}