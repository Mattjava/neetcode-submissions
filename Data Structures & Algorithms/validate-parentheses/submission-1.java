class Solution {
    public boolean isValid(String s) {
        Stack<Character> openStack = new Stack<Character>();

        for(int i = 0; i < s.length(); i++)
        {
            char symbol = s.charAt(i);
            if(symbol == '(' || symbol == '{' || symbol == '[')
            {
                openStack.push(symbol);
                continue;
            }

            if(openStack.isEmpty())
                return false;
            
            char pair = openStack.pop();

            if(symbol == ')' && pair != '(')
                return false;
            
            if(symbol == '}' && pair != '{')
                return false;
            
            if(symbol == ']' && pair != '[')
                return false;
        }

        return openStack.isEmpty();
    }
}
