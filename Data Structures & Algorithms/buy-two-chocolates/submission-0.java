class Solution {
    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);

        int total = prices[0] + prices[1];

        int remaining = money - total;

        return remaining < 0 ? money : remaining;
    }
}