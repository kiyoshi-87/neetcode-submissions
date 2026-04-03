class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> hm = new HashMap<>();
        for (char task : tasks) {
            hm.put(task, hm.getOrDefault(task, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        Set<Character> keySet = hm.keySet();
        for (char ch: keySet) {
            pq.offer(hm.get(ch));
        }
        
        int time = 0;
        
        Queue<List<Integer>> q = new LinkedList<>();

        while (!pq.isEmpty() || !q.isEmpty()) {
            time++;
            if (!q.isEmpty() && q.peek().get(1) == time) {
                pq.offer(q.poll().get(0));
            }

            if (!pq.isEmpty()) {
                int task = pq.poll();
                task--;
                if (task > 0) {
                    q.offer(List.of(task, time + n + 1));
                }
            }
        }
        return time;
    }
}