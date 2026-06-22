class Solution {
    public boolean isHappy(int n) {
        Set<Integer> hs = new HashSet<>();
        int sum = n;

        while (true) {
            if (sum == 1) {
                return true;
            }

            else if (hs.contains(sum)) {
                return false;
            }

            else {
                hs.add(sum);
                sum = getSumOfAllDigits(sum);
            }
        }

    }

    private int getSumOfAllDigits(int num) {
        int sum=0, first=0, next=0;


        while (num != 0) {
            int digit = num % 10;
            sum += digit * digit;
            num = num / 10;
            sum += first*first;
            next = num/10;
        }

        return sum;
    }
}
