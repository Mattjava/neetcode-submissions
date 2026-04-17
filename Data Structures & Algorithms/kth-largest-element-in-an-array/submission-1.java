class Solution {
    public int findKthLargest(int[] nums, int k) {
        int iter = 1;

        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(Collections.reverseOrder());

        for(int num : nums)
            heap.add(num);
        
        while(iter < k)
        {
            heap.poll();
            iter++;
        }

        return heap.poll();
    }
}
