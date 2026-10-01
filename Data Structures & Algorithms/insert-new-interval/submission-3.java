class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int newStart = newInterval[0];
        List<int[]> newList = new ArrayList<>();
        boolean inserted = false;

        // brute force
        for (int i=0; i<intervals.length; i++) {
            int start = intervals[i][0];

            if (start<newStart) {
                newList.add(intervals[i]);
                continue;
            }

            newList.add(newInterval);
            placeTheRest(i, newList, intervals);
            inserted = true;
            break;
        }

        if (!inserted) {
            newList.add(newInterval);
        }

        // normalize
        int i=0;
        int j=1;

        if (newList.size() == 1) {
            return newList.toArray(int[][]::new);
        }

        while (j<newList.size()) {
            int[] first = newList.get(i);
            int[] second = newList.get(j);

            if (first[1]>=second[0]) {
                newList.remove(j);
                first[1] = Math.max(first[1], second[1]);
                continue;
            }

            i++;
            j++;
        }

        return newList.toArray(int[][]::new);
    }

    private void placeTheRest(int index, List<int[]> newList, int[][] intervals) {
        if (index>= intervals.length) {
            return;
        }

        for (int i=index; i< intervals.length; i++) {
            newList.add(intervals[i]);
        }
    }
}