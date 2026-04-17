class Solution {
    public String simplifyPath(String path) {
        Stack<String> dir = new Stack<>();
        String current = "";

        String[] parts = path.split("/");

        for(String part : parts)
        {
            if(part.equals("") || part.equals("."))
                continue;
            if(part.equals("..")) {
                if(!dir.isEmpty()) {
                    dir.pop();

                    if(dir.isEmpty())
                        current = "";
                    else
                        current = dir.peek();

                }
                continue;
            }

            dir.push(part);
            current = part;
        }

        String simp = "/";

        for(int i = 0; i < dir.size() - 1; i++)
            simp += (dir.get(i) + "/");

        return simp + current;
    }
}