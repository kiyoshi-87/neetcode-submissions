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
    private Map<Integer, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        
        return dfsCreate(node);
    }

    private Node dfsCreate(Node node) {
        if (map.containsKey(node.val)) {
            return map.get(node.val);
        }

        Node clone = new Node(node.val);
        map.put(node.val, clone);

        for (Node n : node.neighbors) {
            clone.neighbors.add(dfsCreate(n));
        }

        return clone;
    }
}