class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i=0; i<position.length; i++) {
            hm.put(position[i], speed[i]);
        }

        position = Arrays.stream(position)
                .boxed() // Sort by position descending (closest to target first)
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();

        int i=0;
        int[] dist = new int[position.length];
        for (int pos : position) {
            speed[i] = hm.get(pos);
            dist[i] = target - pos;
            i++;
        }

        double[] time = new double[position.length];

        for (i =0; i<position.length; i++) {
            time[i] = (double) dist[i]/speed[i];
        }

        int count=1;
        double max = time[0];

        for (i=1; i< position.length; i++) {
            if (time[i] > max) {
                count++;
                max = time[i];
            }
        }

        return count;
    }
}