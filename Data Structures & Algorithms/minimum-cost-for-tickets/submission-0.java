class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;

        int[] total = new int[n + 1];
        

        for(int i = n - 1; i > -1; i--) {
            total[i] = Integer.MAX_VALUE;

            int idx = 0, j = 1;
            for(int d : new int[]{1, 7, 30}) {
                while(j < n && days[j] < days[i] + d) {
                    j++;
                }
                total[i] = Math.min(total[i], costs[idx] + total[j]);
                idx++;
            }
        }

        return total[0];
    }
}