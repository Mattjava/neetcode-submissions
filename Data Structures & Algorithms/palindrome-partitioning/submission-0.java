class Solution {
    public boolean isPalindrome(String str)
    {
        if(str.length() == 1)
            return true;

        StringBuilder builder = new StringBuilder(str);
        builder.reverse();
        String reversed = builder.toString();


        return reversed.equals(str);
    }

    public void generatePalindromes(List<List<String>> list, List<String> curr, String str)
    {
        if(str.length() == 0 && curr.size() > 0) {
            List<String> newEntry = new LinkedList<String>(curr);
            list.add(newEntry);
        }

        for(int i = 1; i <= str.length(); i++)
        {
            String sub = str.substring(0, i);

            if(isPalindrome(sub)) {
                int index = curr.size();
                curr.add(sub);
                generatePalindromes(list, curr, str.substring(i));
                curr.remove(index);
            }
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> list = new LinkedList<List<String>>();
        generatePalindromes(list, new LinkedList<String>(), s);
        return list;
    }
}
