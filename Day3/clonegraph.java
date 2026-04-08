class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;

        HashMap<Node, Node> map = new HashMap<>();
        return dfs(node, map);
    }

    private Node dfs(Node node, HashMap<Node, Node> map) {
        // if already cloned
        if (map.containsKey(node)) {
            return map.get(node);
        }

        // create clone
        Node clone = new Node(node.val);
        map.put(node, clone);

        // clone neighbors
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(dfs(neighbor, map));
        }

        return clone;
    }
}