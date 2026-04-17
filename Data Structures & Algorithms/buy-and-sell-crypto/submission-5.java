class Solution {
    public int maxProfit(int[] prices) {
        int buyDate = 0;

        int earned = 0;

        for(int sellDate = 1; sellDate < prices.length; sellDate++)
        {
            if(prices[sellDate] - prices[buyDate] < 1) {
                buyDate = sellDate;
                continue;
            }

            earned = Math.max(prices[sellDate] - prices[buyDate], earned);
        }

        return earned;
    }
}
