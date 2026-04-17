class MedianFinder {
    private PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<Integer>();
    }
    
    public void addNum(int num) {
        minHeap.add(num);
    }
    
    public double findMedian() {
        int[] arr = new int[minHeap.size()];

        PriorityQueue<Integer> copy = new PriorityQueue<Integer>(minHeap);
        int iter = 0;
        while(!copy.isEmpty())
        {
            arr[iter] = copy.poll();
            iter++;
        }

        int half = minHeap.size() / 2;

        if(minHeap.size() % 2 == 0)
            return (double) (arr[half] + arr[half-1]) / 2;
        return (double) arr[half];
    }
}
