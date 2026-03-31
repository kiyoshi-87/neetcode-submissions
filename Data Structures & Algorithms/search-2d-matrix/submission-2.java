class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int first = matrix[0][0];
        int last = matrix[n - 1][m - 1];

        if (target < first || target > last) {
            return false;
        }

        for (int i = 0; i < n; i++) {
            if (target <= matrix[i][m - 1]) {
                return binarySearchFound(matrix, target, i);
            }
        }

        return false;
    }

    private boolean binarySearchFound(int[][] arr, int target, int i) {
        int l = 0;
        int r = arr[i].length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (target == arr[i][mid]) {
                return true;
            } else if (target > arr[i][mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return false;
    }
}