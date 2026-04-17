class Solution {
    public double findDistanceFromOrigin(int[] point)
    {
        return Math.sqrt((point[0] * point[0]) + (point[1] * point[1]));
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Double> distanceHeap = new PriorityQueue<Double>();
        HashMap<Double, List<Integer>> distanceMap = new HashMap<>();

        for(int i = 0; i < points.length; i++)
        {
            double distance = findDistanceFromOrigin(points[i]);

            distanceHeap.add(distance);
            List<Integer> indexList;
            if(!distanceMap.containsKey(distance))
                indexList = new LinkedList<Integer>();
            else
                indexList = distanceMap.get(distance);
            indexList.add(i);
            distanceMap.put(distance, indexList);
        }

        int[][] resultGrid = new int[k][2];

        for(int i = 0; i < k; i++)
        {
            double smallestDistance = distanceHeap.poll();

            List<Integer> indexes = distanceMap.get(smallestDistance);

            int index = indexes.remove(0);

            if(indexes.isEmpty())
                distanceMap.remove(smallestDistance);
            else
                distanceMap.put(smallestDistance, indexes);

            int[] point = points[index];

            resultGrid[i][0] = point[0];
            resultGrid[i][1] = point[1];
        }

        return resultGrid;
    }
}
