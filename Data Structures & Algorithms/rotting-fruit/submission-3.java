class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();

        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    Pair pair = new Pair(new int[]{i, j}, 0);
                    q.offer(pair);
                }
            }
        }

        int maxT = 0;

        int ROW = grid.length;
        int COL = grid[0].length;

        while(!q.isEmpty()) {
            Pair pair = q.poll();
            int row = pair.rowCol[0];
            int col = pair.rowCol[1];


            int[][] neighbours = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

            for (int[] neighbour : neighbours) {
                int nr = row + neighbour[0];
                int nc = col + neighbour[1];

                if (Math.min(nr, nc)<0 || nr>=ROW || nc>=COL || grid[nr][nc] == 0 || grid[nr][nc] == 2) {
                    continue;
                }

                grid[nr][nc] = 2;
                maxT = pair.time + 1;

                Pair temp = new Pair(new int[]{nr, nc}, maxT);
                q.offer(temp);
            }
        }

        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return maxT;
    }

    public class Pair {
        int[] rowCol;
        int time;

        Pair(int[] rowCol, int time) {
            this.rowCol = rowCol;
            this.time = time;
        }
    }    
}

