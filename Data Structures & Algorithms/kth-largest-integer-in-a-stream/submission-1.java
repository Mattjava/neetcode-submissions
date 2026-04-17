class KthLargest {
    private int kthLargestInt;
    private int k;
    private PriorityQueue<Integer> stream;

    public KthLargest(int k, int[] nums) {
        stream = new PriorityQueue<Integer>(Collections.reverseOrder());
        this.k = k - 1;

        for(int num : nums)
            stream.add(num);
        
        findKthLargestInt();
    }
    
    public int add(int val) {
        stream.add(val);
        findKthLargestInt();
        return kthLargestInt;
    }

    private void findKthLargestInt()
    {
        if(stream.size() < k + 1)
            return;

        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(stream);

        for(int i = 0; i < k; i++)
            heap.poll();
        
        kthLargestInt = heap.poll();
    }
}
