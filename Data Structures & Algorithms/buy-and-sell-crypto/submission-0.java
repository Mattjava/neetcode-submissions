class Solution {
    public int maxProfit(int[] prices) {
        int buyDate = 0;
        int sellDate = 0;

        int maxProfit = 0;

        for(int i = 1; i < prices.length; i++) {
            if(prices[i] < prices[buyDate]) {
                buyDate = i;
                sellDate = buyDate;
                continue;
            }

            if(prices[i] > prices[sellDate]) {
                sellDate = i;
            }

            maxProfit = Math.max(maxProfit, prices[sellDate] - prices[buyDate]);
        }

        return maxProfit;
    }
}
