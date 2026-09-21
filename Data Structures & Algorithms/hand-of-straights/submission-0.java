class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }

        TreeMap<Integer, Integer> tm = new TreeMap<>();

        for (int i : hand) {
            tm.put(i, tm.getOrDefault(i, 0) + 1);
        }

        while (!tm.isEmpty()) {
            int smallestKey = tm.firstKey();

            for (int i = 0; i < groupSize; i++) {
                int key = smallestKey + i;

                if (!tm.containsKey(key)) {
                    return false;
                }

                getAndRemoveKey(tm, key);
            }
        }  

        return true;
    }

    public void getAndRemoveKey(Map<Integer, Integer> tm, int key) {
        tm.put(key, tm.get(key) - 1);

        if (tm.get(key) <= 0) {
            tm.remove(key);
        }
    }
}