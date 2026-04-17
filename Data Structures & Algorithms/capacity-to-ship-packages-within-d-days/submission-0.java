class Solution {
    public boolean countDays(int[] weights, int capacity, int within) {
        int days = 1;
        int currentWeight = 0;

        for(int weight : weights) {
            if(currentWeight + weight > capacity) {
                days++;
                if(days > within)
                    return false;
                currentWeight = 0;
            }
            currentWeight += weight;
        }

        return true;
    }

    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;

        for(int weight : weights) {
            left = Math.max(left, weight);
            right += weight;
        }

        int res = right;
        
        while(left <= right) {
            int mid = (right + left) / 2;

            if(!countDays(weights, mid, days)) {
                left = mid + 1;
            } else {
                res = Math.min(mid, res);
                right = mid - 1;
            }
        }

        return res;
    }
}