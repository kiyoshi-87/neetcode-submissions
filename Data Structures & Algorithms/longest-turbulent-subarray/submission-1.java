class Solution {
    public int maxTurbulenceSize(int[] arr) {
        // My approach, doing it two times, 1st set of condition and 2nd set of conditions

        // arr[odd] > arr[odd+1]
        // arr[even] < arr[even + 1]
        int l = 0, length = 0;

        for (int r = 0; r<arr.length-1; r++) {
            if (isEven(r)) {
                int num1 = arr[r];
                int num2 = arr[r+1];

                if (num1 >= num2) {
                    length = Math.max(length, r-l+1);
                    l = r+1;
                }
            }

            if (!isEven(r)) {
                int num1 = arr[r];
                int num2 = arr[r+1];

                if (num1 <= num2) {
                    length = Math.max(length, r-l+1);
                    l = r+1;
                }
            }
        }
        length = Math.max(length, arr.length - l);

        l = 0;
        for (int r = 0; r<arr.length-1; r++) {
            if (isEven(r)) {
                int num1 = arr[r];
                int num2 = arr[r+1];

                if (num1 <= num2) {
                    length = Math.max(length, r-l+1);
                    l = r+1;
                }
            }

            if (!isEven(r)) {
                int num1 = arr[r];
                int num2 = arr[r+1];

                if (num1 >= num2) {
                    length = Math.max(length, r-l+1);
                    l = r+1;
                }
            }
        }
        length = Math.max(length, arr.length - l);

        return length;
    }

    private boolean isEven(int num) {
        return num % 2 == 0;
    }
}