class PrefixTree {
    private class TreeNode {
        private char key;
        private int value;
        private List<TreeNode> children;
        private HashSet<Character> availableChildren;

        public TreeNode(char key) {
            this.key = key;
            value = 0;
            children = new LinkedList<>();
            availableChildren = new HashSet<>();
        }

        public TreeNode() {
            this(' ');
        }

        public TreeNode getNeighbor(char key)
        {
            for(int i = 0; i < children.size(); i++)
            {
                TreeNode neighbor = children.get(i);

                if(neighbor.key == key)
                    return neighbor;
            }

            return null;
        }
    }

    private TreeNode root;

    public PrefixTree() {
        root = new TreeNode();
    }

    public void insert(String word) {
        TreeNode iter = root;

        for(int i = 0; i < word.length(); i++)
        {
            char key = word.charAt(i);

            if(iter.availableChildren.contains(key)) {
                iter = iter.getNeighbor(key);
                continue;
            }

            TreeNode newNode = new TreeNode(key);
            iter.availableChildren.add(key);
            iter.children.add(newNode);

            iter = newNode;
        }

        iter.value = 1;
    }

    public boolean search(String word) {
        TreeNode iter = root;

        for(int i = 0; i < word.length(); i++)
        {
            char key = word.charAt(i);

            if(!iter.availableChildren.contains(key))
                return false;

            iter = iter.getNeighbor(key);
        }

        return iter.value == 1;
    }

    public boolean startsWith(String prefix) {
        TreeNode iter = root;

        for(int i = 0; i < prefix.length(); i++)
        {
            char key = prefix.charAt(i);

            if(!iter.availableChildren.contains(key))
                return false;

            iter = iter.getNeighbor(key);
        }

        return true;
    }
}
