package practice;

public class RouteBetweenTrees {
    public static void main(String[] args) {
        Graph graph= new Graph();
        Node node = new Node();
        node.name = "1";
        node.children = null;
//        graph.nodes[0] = node;

//        new RouteBetweenTrees().search();
    }

    public boolean search(Graph g, Node start, Node end) {
return true;
    }

    static class Node {
        public String name;
        public Node[] children;
    }
}

class Graph {
    public Node[] nodes;
}

