class Solution {
    public boolean isValid(String s) {
        Stack<Character> openStack = new Stack<Character>();

        for(int i = 0; i < s.length(); i++)
        {
            char parenthese = s.charAt(i);
            if(parenthese == '(' || parenthese == '{' || parenthese == '[') {
                openStack.push(parenthese);
            } else {
                if(openStack.isEmpty())
                    return false;
                char openParenthese = openStack.pop();
                if((openParenthese == '(' && parenthese != ')') || (openParenthese == '{' && parenthese != '}') || (openParenthese == '[' && parenthese != ']'))
                    return false;
            }
        }

        return openStack.isEmpty();
    }
}
