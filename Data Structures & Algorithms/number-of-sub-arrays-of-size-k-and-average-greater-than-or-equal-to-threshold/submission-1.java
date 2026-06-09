class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int l = 0;
        int count = 0;
        int sum = 0;

        for (int r = 0; r < arr.length; r++) {
            sum += arr[r];
            if (r-l+1 > k) {
                sum -= arr[l];
                l++;
            }

            if (r-l+1 == k) {
                if (sum >= (long)threshold * k) {
                    count++;
                }
            }
        }
        
        return count;
    }
}