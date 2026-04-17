/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    private HashMap<Integer, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null)
            return node;
        if(map.containsKey(node.val))
            return map.get(node.val);
        System.out.println("Creating new node! " + node.val);
        Node newNode = new Node(node.val);
        map.put(node.val, newNode);

        List<Node> nearbyNodes = node.neighbors;
        List<Node> newNeighbors = new LinkedList<Node>();

        for(int i = 0; i < nearbyNodes.size(); i++)
        {
            Node neighbor = cloneGraph(nearbyNodes.get(i));
            newNeighbors.add(neighbor);
        }

        newNode.neighbors = newNeighbors;

        return newNode;
    }
}