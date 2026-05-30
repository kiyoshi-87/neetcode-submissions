class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<List<Integer>> squareCheckerIndex = List.of(
                List.of(0, 0), List.of(0, 3), List.of(0, 6),
                List.of(3, 0), List.of(3, 3), List.of(3, 6),
                List.of(6, 0), List.of(6, 3), List.of(6, 6)
        );

        boolean isValid = true;

        for (int i=0; i<9; i++) {
            for (int j=0; j<board[0].length; j++) {
                List<Integer> cord = Arrays.asList(i, j);

                if (squareCheckerIndex.contains(cord)) {
                    isValid = helper(i, j, board, true);
                } else {
                    isValid = helper(i, j, board, false);
                }
                if (!isValid) return false;
            }
        }

        return isValid;
    }

    private boolean helper(int row, int col, char[][] board, boolean boxChecker) {
        boolean isValid = true;
        boolean first = false;

        if (boxChecker) {
            isValid = box(row, col, board);

            if (!isValid) {
                return false;
            }
        }

        if (row == 0) {
            first = true;
        }

        isValid = rowChecker(row, col, board, first);

        return isValid;
    }

    private boolean box(int ROW, int COL, char[][] board) {
        Set<Character> hs = new HashSet<>();

        for (int i= ROW; i<ROW+3; i++) {
            for (int j= COL; j<COL+3; j++) {
                char ch = board[i][j];
                if (ch == '.') continue;

                if (hs.contains(ch)) {
                    return false;
                }

                hs.add(ch);
            }
        }

        return true;
    }

    private boolean rowChecker(int ROW, int COL, char[][] board, boolean isFirst) {
        char[] colList = board[ROW];
        Set<Character> hs = new HashSet<>();

        if (COL == 0) {
            for (char ch : colList) {
                if (ch == '.') continue;
                if (hs.contains(ch)) {
                    return false;
                }
                hs.add(ch);
            }
        }
        
        if (isFirst) {
            hs = new HashSet<>();

            for (char[] chars : board) {
                char ch = chars[COL];
                if (ch == '.') continue;

                if (hs.contains(ch)) {
                    return false;
                }

                hs.add(ch);
            }
        }
        
        return true;
    }
}