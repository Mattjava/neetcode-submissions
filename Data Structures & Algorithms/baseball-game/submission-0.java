class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> scores = new Stack<>();

        for(int i = 0; i < operations.length; i++)
        {
            String operation = operations[i];

            if(operation.equals("C")) {
                scores.pop();
                continue;
            }

            if(operation.equals("+")) {
                int first = scores.pop();
                int second = scores.pop();

                scores.push(second);
                scores.push(first);
                scores.push(first + second);

                continue;
            }

            if(operation.equals("D")) {
                int num = scores.pop();

                scores.push(num);
                scores.push(num * 2);

                continue;
            }

            scores.push(Integer.parseInt(operation));
        }

        int sum = 0;

        while(!scores.isEmpty())
            sum += scores.pop();

        return sum;
    }
}