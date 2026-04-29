class Solution {
    public boolean exist(char[][] board, String word) {
        char firstCh = word.charAt(0);

        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                if (board[i][j] == firstCh) {
                    char temp = board[i][j];
                    board[i][j] = '#';
                    if (helper(board, i, j, word, new StringBuilder().append(temp), 1)) {
                        return true;
                    }
                    board[i][j] = temp;
                }
            }
        }

        return false;
    }


    private boolean helper(char[][] board, int i, int j, String word, StringBuilder partial, int index) {
        if (word.equals(partial.toString())) {
            return true;
        }

        if (partial.length() == word.length()) {
            return false;
        }

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] d : dirs) {
            int ni = i + d[0], nj = j + d[1];
            if (ni >= 0 && ni < board.length && nj >= 0 && nj < board[0].length && board[ni][nj] != '#' && board[ni][nj] == word.charAt(index)) {
                char temp = board[ni][nj];
                board[ni][nj] = '#';
                partial.append(temp);
                if (helper(board, ni, nj, word, partial, index + 1)) return true;
                partial.setLength(partial.length() - 1);
                board[ni][nj] = temp;
            }
        }

        return false;
    }
}