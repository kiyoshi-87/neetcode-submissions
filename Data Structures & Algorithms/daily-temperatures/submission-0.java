class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];

        for (int i=0; i<n; i++) {
            ans[i] = calculateWarmerTempDay(i, temperatures);
        }

        return ans;
    }

    private int calculateWarmerTempDay(int i, int[] temp) {
        int count = 0;
        int dDayTemp = temp[i];
        while(i<temp.length-1) {
            i++;

            if (temp[i]>dDayTemp) {
                return count+1;
            }

            count++;
        }
        return 0;
    }
}
