class Solution {

    public String encode(List<String> strs) {
        String result = "";
        int size = strs.size();

        for(int i = 0; i < size; i++)
        {
            String part = strs.get(i);
            int strSize = part.length();
            result += (strSize + "#") + part;
        }
        System.out.println(result);
        return result;
    }

    public List<String> decode(String str) {
        int totalSize = str.length();
        List<String> listOfStrings = new LinkedList<String>();
        int start = 0;
        int parser = start;

        while(parser < totalSize) {
            if(str.charAt(parser) == '#') {
                int partSize = Integer.parseInt(str.substring(start, parser));
                String part = str.substring(parser+1, parser+partSize+1);
                listOfStrings.add(part);
                System.out.println(listOfStrings);
                start = parser + partSize + 1;
                parser = start;
            }

            parser++;
        }


        return listOfStrings;
    }
}
