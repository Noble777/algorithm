package FB;

import java.util.*;

public class CloneGraph {
    static class Node {
        int val;
        List<Node> neighbors;
        public Node(int val, List<Node> neighbors) {
            this.val = val;
            this.neighbors = neighbors;
        }
    }
    // dfs
    private static HashMap<Integer, Node> map = new HashMap<>();
    public static Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        if (map.containsKey(node.val)) {
            return map.get(node.val);
        }
        Node newNode = new Node(node.val, new ArrayList<Node>());
        map.put(node.val, newNode);
        for (Node neighbor : node.neighbors) {
            newNode.neighbors.add(cloneGraph(neighbor));
        }
        return newNode;

    }

    //bfs
    public static Node cloneGraph2(Node node) {
        if (node == null) {
            return null;
        }

        // store the created newNode
        HashMap<Integer, Node> map = new HashMap<>();
        Node newNode = new Node(node.val, new ArrayList<Node>());

        // bfs using queue
        Queue<Node> queue = new LinkedList<>();
        queue.add(node); // cur node

        // bfs
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (Node neighbor : cur.neighbors) {
                if (map.containsKey(neighbor.val)) { // if not created, create firstly
                    map.put(neighbor.val, new Node(neighbor.val, new ArrayList<Node>()));
                    queue.add(neighbor);
                }
                map.get(cur.val).neighbors.add(map.get(neighbor.val));
            }
        }
        return newNode;
    }

}
