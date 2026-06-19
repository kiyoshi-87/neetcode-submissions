class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;

        for (int pile : piles) {
            max = Math.max(max, pile);
        }

        // So this max is the maximum rate of bananas per hour eating speed (Upper bound for the search)
        // h>=piles.length always, so the worse case scenario we need to eat with this max rate for completing it within h hours

        int left = 1;
        int right = max;
        int ans = max;

        while (left<=right) {
            int mid = left + (right-left)/2;

            long hours = calculateHours(piles, mid);

            if (hours <= h) {
                ans = mid;
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        
        return ans;
    }

    private long calculateHours(int[] piles, int speed) {
        long hours = 0;

        for (int pile : piles) {
            hours += Math.ceilDiv(pile, speed);
        }

        return hours;
    }
}
