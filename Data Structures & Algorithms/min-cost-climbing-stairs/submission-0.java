class Solution {
    public int findPath(int start, int[] cost, int total)
    {
        if(start >= cost.length)
            return total;
        total += cost[start];
        int firstWay = findPath(start + 1, cost, total);
        int secondWay = findPath(start + 2, cost, total);

        return Math.min(firstWay, secondWay);

    }

    public int minCostClimbingStairs(int[] cost) {
        int zeroStart = findPath(0, cost, 0);
        int oneStart = findPath(1, cost, 0);

        return Math.min(zeroStart, oneStart);
    }
}
