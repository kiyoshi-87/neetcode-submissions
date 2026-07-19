class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // # Second impression: More optimal
        // We can do the opposite and from the pacific and atlanitic border
        // We will do DFS from the borders and check which cells reach atlantic or pacific
        // and the intersection of these two sets would give us resultant answer

        Set<String> pacVisited = new HashSet<>();
        Set<String> atlVisited = new HashSet<>();

        // keep row fixed
        for (int i = 0; i < heights[0].length; i++) {
            // String key = 0 + ":" + i;

            dfs(heights, pacVisited, 0, i);
        }

        // key col fixed
        for (int i = 0; i < heights.length; i++) {
            // String key = 0 + ":" + i;

            dfs(heights, pacVisited, i, 0);
        }

        // keep row fixed
        for (int i = 0; i < heights[0].length; i++) {
            // String key = 0 + ":" + i;

            dfs(heights, atlVisited, heights.length - 1, i);
        }

        // key col fixed
        for (int i = 0; i < heights.length; i++) {
            // String key = 0 + ":" + i;

            dfs(heights, atlVisited, i, heights[0].length - 1);
        }

        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                String key = i + ":" + j;

                if (pacVisited.contains(key) && atlVisited.contains(key)) {
                    ans.add(List.of(i, j));
                }
            }
        }

        return ans;
    }

    private void dfs(int[][] heights, Set<String> visited, int row, int col) {
        String key = row + ":" + col;

        if (visited.contains(key)) {
            return;
        }

        visited.add(key);

        int[][] neighbours = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int[] neighbour : neighbours) {
            int nr = row + neighbour[0];
            int nc = col + neighbour[1];

            if (nr >= 0 && nr < heights.length && nc >= 0 && nc < heights[0].length
                && heights[nr][nc] >= heights[row][col]) {
                dfs(heights, visited, nr, nc);
            }
        }
    }
}
