class Solution {
    public int maxProfit(int[] prices) {
        int buyDate = 0;
        int sellDate = 0;

        int maxProfit = 0;

        for(int i = 0; i < prices.length; i++)
        {
            if(prices[i] < prices[buyDate])
            {
                maxProfit = Math.max(maxProfit, prices[sellDate] - prices[buyDate]);
                buyDate = i;
                sellDate = i;
            } else if(prices[i] > prices[sellDate]) {
                sellDate = i;
            }
        }


        return Math.max(maxProfit, prices[sellDate] - prices[buyDate]);
    }
}
