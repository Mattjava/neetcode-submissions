class Solution {
    public void generate(int left, int right, int n, String current, List<String> list)
    {
        if(left == n && right == n) {
            list.add(current);
            return;
        }

        if(left < n)
            generate(left + 1, right, n, current + "(", list);
        if(right < n && right < left)
            generate(left, right + 1, n, current + ")", list);
    }

    public List<String> generateParenthesis(int n) {
        List<String> parenthesisList = new LinkedList<String>();
        generate(0, 0, n, "", parenthesisList);
        return parenthesisList;
    }
}
