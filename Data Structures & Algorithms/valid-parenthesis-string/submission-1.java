class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> leftStack = new Stack<Integer>();
        Stack<Integer> starStack = new Stack<Integer>();

        for(int i = 0; i < s.length(); i++)
        {
            char symbol = s.charAt(i);

            if(symbol == '(')
                leftStack.push(i);
            else if(symbol == '*')
                starStack.push(i);
            else {
                if(leftStack.isEmpty() && starStack.isEmpty())
                    return false;
                else if(leftStack.isEmpty())
                    starStack.pop();
                else
                    leftStack.pop();
            }
        }

        while(!leftStack.isEmpty() && !starStack.isEmpty()) {
            int leftIndex = leftStack.pop();
            int starIndex = starStack.pop();

            if(leftIndex >= starIndex)
                return false;
        }

        return leftStack.isEmpty();
    }
}
