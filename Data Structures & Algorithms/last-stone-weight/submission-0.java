class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(Collections.reverseOrder());

        for(int stone : stones)
            heap.add(stone);
        
        while(heap.size() > 1)
        {
            int firstStone = heap.poll();
            int secondStone = heap.poll();

            if(firstStone == secondStone) 
                continue;
            
            if(firstStone < secondStone)
                heap.add(secondStone - firstStone);
            else
                heap.add(firstStone - secondStone);
        }

        if(!heap.isEmpty())
            return heap.poll();
        
        return 0;
    }
}
