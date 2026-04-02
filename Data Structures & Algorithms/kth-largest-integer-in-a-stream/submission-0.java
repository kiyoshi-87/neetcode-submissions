class KthLargest {
    private PriorityQueue<Integer> pq;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.pq = new PriorityQueue<>(Comparator.reverseOrder());
        this.k = k;
        insertIntoHeap(nums);
    }
    
    public int add(int val) {
        pq.offer(val);

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i<k-1; i++) {
            list.add(pq.poll());
        }

        int ans = pq.peek();
        if (!list.isEmpty()) {
            insertIntoHeap(list);
        }

        return ans;
    }

    private void insertIntoHeap(int[] nums) {
        for (int num: nums) {
            pq.offer(num);
        }
    }

    private void insertIntoHeap(List<Integer> nums) {
        nums.forEach(num -> pq.offer(num));
    }
}
