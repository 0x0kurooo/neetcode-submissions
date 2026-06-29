class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // Sort the amount of each pile as ascending
        Arrays.sort(piles);
        
        int minRate = piles[piles.length-1];
        int l = 1, r = piles[piles.length-1];
        while (l <= r) {
            int mid = (l + r) / 2;
            int reqHourToEat = 0;

            for (int i = 0; i < piles.length; i ++) {
                reqHourToEat += (int) Math.ceil((double) piles[i] / mid);
            }

            if (reqHourToEat > h) {
                l = mid + 1;
            } else {
                minRate = Math.min(minRate, mid);
                r = mid - 1;
            }
        }

        return minRate;
    }
}
