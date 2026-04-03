class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (int stone: stones) {
            pq.offer(stone);
        }

        if (pq.size() == 1) {
            return pq.poll();
        }

        while (pq.size() > 1) {
            int x = pq.poll();
            int y = pq.poll();

            int diff = Math.abs(x - y);

            if (diff != 0) {
                pq.offer(diff);
            }
        }

        return pq.size() == 1 ? pq.poll() : 0;
    }
}
