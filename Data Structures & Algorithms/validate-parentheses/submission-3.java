class Solution {
    public boolean isValid(String s) {
        Stack<Integer> charStack = new Stack<>();

        for(int i = 0; i < s.length(); i++)
        {
            int sym = (int) s.charAt(i);

            if(sym == 40 || sym == 91 || sym == 123) {
                charStack.push(sym);
                continue;
            }

            if(charStack.isEmpty())
                return false;

            int top = charStack.pop();

            if(sym != top + 1 && sym !=  top + 2)
                return false;

        }

        return charStack.isEmpty();
    }
}
