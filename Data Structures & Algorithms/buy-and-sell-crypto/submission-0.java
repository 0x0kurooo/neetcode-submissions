class Solution {
    public int maxProfit(int[] prices) {
        int[] minPrice = new int[prices.length];
        int[] maxPrice = new  int[prices.length];

        int min = prices[0];
        int max = prices[prices.length-1];
        int n = prices.length - 1;
        for (int i = 0; i < prices.length; i ++) {
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[n - i]);
            minPrice[i] = min;
            maxPrice[n-i] = max;
        }

        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            int profit = maxPrice[i] - minPrice[i];
            maxProfit = Math.max(maxProfit, profit);
        }

        return maxProfit;
    }
}
