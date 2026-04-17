class Solution {
    static HashMap<Character, String> keyboard;

    public HashMap<Character, String> setUpKeyboard()
    {
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        return map;
    }

    public void combine(StringBuilder current, String digits, int index, List<String> combinations)
    {
        if(index == digits.length()) {
            String currentCopy = current.toString();
            combinations.add(currentCopy);
            return;
        }

        int originalSize = current.length();

        char digit = digits.charAt(index);
        String letters = keyboard.get(digit);
        int letterLength = letters.length();

        for(int i = 0; i < letterLength; i++) {
            current.append(letters.charAt(i));
            combine(current, digits, index + 1, combinations);
            current.deleteCharAt(originalSize);
        }
    }

    public List<String> letterCombinations(String digits)
    {
        List<String> words = new LinkedList<String>();

        if(!digits.isEmpty()) {
            keyboard = setUpKeyboard();
            combine(new StringBuilder(), digits, 0, words);
        }

        return words;
    }
}