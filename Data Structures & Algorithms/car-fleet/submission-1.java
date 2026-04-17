class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] cars = new int[position.length][2];

        for(int i = 0; i < cars.length; i++)
        {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (a, b) -> Integer.compare(b[0], a[0]));
        Stack<Double> timeStack = new Stack<Double>();

        for(int i = 0; i < cars.length; i++)
        {
            double time = (double) (target - cars[i][0]) / cars[i][1];
            System.out.println("Position: " + cars[i][0] + "| Speed: " + cars[i][1] + "| Time: " + time);
            if(timeStack.isEmpty() || time > timeStack.peek())
                timeStack.push(time);
        }

        return timeStack.size();
    }
}
