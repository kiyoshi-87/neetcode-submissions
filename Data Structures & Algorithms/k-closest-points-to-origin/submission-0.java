class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Double> pq = new PriorityQueue<>();
        Map<Double, List<List<Integer>>> hm = new HashMap<>();

        for (int[] point : points) {
            int a = point[0];
            int b = point[1];

            double dist = Math.sqrt(a*a + b*b);
            pq.offer(dist);

            List<Integer> pointList = new ArrayList<>();
            pointList.add(a);
            pointList.add(b);

            if (hm.containsKey(dist)) {
                List<List<Integer>> list = hm.get(dist);
                list.add(pointList);
                hm.put(dist, list);
            } else {
                List<List<Integer>> mainList = new ArrayList<>();
                mainList.add(pointList);

                hm.put(dist, mainList);
            }
        }

        List<List<Integer>> ans = new ArrayList<>();

        while (k!=0) {
            Double dist = pq.poll();
            List<List<Integer>> list = hm.get(dist);

            while (!list.isEmpty() && k!=0) {
                ans.add(list.remove(0));
                k--;
            }
        }

        return ans.stream() 
            .map(inner -> inner.stream().mapToInt(Integer::intValue).toArray())
            .toArray(int[][]::new);
    }
}