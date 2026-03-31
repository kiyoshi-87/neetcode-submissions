class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length-1;

        int i=0;
        int j = n;
        int ans = numbers[i] + numbers[j];

        while (ans!=target) {
            if(ans>target) {
                j --;
            } else {
                i++;
            }
            ans = numbers[i] + numbers[j];
        }
        return new int[]{i + 1, j + 1};
    }
}