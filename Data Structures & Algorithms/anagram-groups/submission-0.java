class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        LinkedList<Integer> base = new LinkedList<Integer>();

        for(int i = 0; i < 27; i++)
            base.add(0);

        HashMap<List<Integer>, List<String>> groups = new HashMap<>();

        for(int i = 0; i < strs.length; i++)
        {
            List<Integer> countList = new LinkedList<Integer>(base);

            String currentStr = strs[i];
            for(int j = 0; j < currentStr.length(); j++)
            {
                char letter = currentStr.charAt(j);
                int index = letter - 97;
                countList.set(index, countList.get(index) + 1);
            }
            List<String> stringList;

            if(!groups.containsKey(countList)) 
                stringList = new LinkedList<String>();
            else 
                stringList = groups.get(countList);
            
            stringList.add(currentStr);
            groups.put(countList, stringList);
        }

        List<List<String>> result = new LinkedList<List<String>>();
        for(List<String> list : groups.values()) {
            result.add(list);
        }

        return result;
    }
}
