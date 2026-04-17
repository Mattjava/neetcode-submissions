class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> numbers = new Stack<String>();

        for(int i = 0; i < tokens.length; i++)
        {
            String operator = tokens[i];

            if(operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/")) 
            {
                int secondNum = Integer.parseInt(numbers.pop());
                int firstNum = Integer.parseInt(numbers.pop());

                int result;

                if(operator.equals("+"))
                    result = firstNum + secondNum;
                else if(operator.equals("-"))
                    result = firstNum - secondNum;
                else if(operator.equals("*"))
                    result = firstNum * secondNum;
                else
                    result = firstNum / secondNum;



                numbers.push("" + result);
            } else {
                numbers.push(operator);
            }
        }

        return Integer.parseInt(numbers.pop());
    }
}
