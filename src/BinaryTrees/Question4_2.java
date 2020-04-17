import java.util.LinkedList;

/*
    Given a directed graph, design an algorithm to find out if there
    is a route between two nodes.
 */
public class Question4_2 {
    public enum State {
        Unvisited, Visiting, Visited;
    }

    public static void main(String[] args) {
        Graph graph = createNewGraph();
        GraphNode[] n = graph.getNodes();

        // Pick two nodes here and determine if there is a route between them.
        GraphNode start = n[3];
        GraphNode end = n[4];

        System.out.println(routeAvailable(graph, start, end));
    }

    public static Graph createNewGraph() {
        Graph g = new Graph();

        g.vertices[0] = new GraphNode("a", 2);
        g.vertices[1] = new GraphNode("b", 0);
        g.vertices[2] = new GraphNode("c", 0);
        g.vertices[3] = new GraphNode("d", 1);
        g.vertices[4] = new GraphNode("e", 1);

        //Only 0, 3, and 4 have adjacent nodes.
        g.vertices[0].addAdjacent(g.vertices[1]);
        g.vertices[0].addAdjacent(g.vertices[2]);
        g.vertices[3].addAdjacent(g.vertices[4]);
        g.vertices[4].addAdjacent(g.vertices[3]);

        for (int i = 0; i < 5; i++) {
            g.addNode(g.vertices[i]);
        }
        return g;
    }

    public static boolean routeAvailable(Graph g, GraphNode start, GraphNode end) {
        LinkedList<GraphNode> list = new LinkedList<>();

        for (GraphNode node : g.getNodes()) {
            node.state = State.Unvisited;
        }
        start.state = State.Visiting;
        list.add(start);

        GraphNode iter;

        while (!list.isEmpty()) {
            iter = list.removeFirst();
            if (iter != null) {
                for (GraphNode i : iter.getAdjacent()) {
                    if (i.state == State.Unvisited) {
                        if (i == end) {
                            return true;
                        } else {
                            i.state = State.Visiting;
                            list.add(i);
                        }
                    }
                }
                iter.state = State.Visited;
            }
        }
        return false;
    }
}

class Graph {
    public GraphNode vertices[];
    public int count;

    public Graph() {
        vertices = new GraphNode[5];
        count = 0;
    }

    public GraphNode[] getNodes() {
        return vertices;
    }

    public void addNode(GraphNode x) {
        if (count < 10) {
            vertices[count] = x;
            count++;
        } else {
            System.out.print("Graph full");
        }
    }
}

class GraphNode {
    /*
        The Graph instance will be made in the main.
        adjacent: array to hold number of adjacent nodes
        adjacentCount: simple int to hold the count.
     */
    private GraphNode adjacent[];
    public int adjacentCount;
    private String name;
    public Question4_2.State state;

    //Method to add nodes
    public GraphNode(String name, int adjacentLength) {
        this.name = name;
        adjacentCount = 0;
        // use length to set length of adjacent array.
        // need to fill out which nodes are adjacent still
        adjacent = new GraphNode[adjacentLength];
    }

    public void addAdjacent(GraphNode x) {
        // count starts at 0
        // add adjacent graphNodes to array starting at index 0.
        if (adjacentCount < 10) {
            this.adjacent[adjacentCount] = x;
            adjacentCount++;
        } else {
            System.out.print("No more adjacent can be added");
        }
    }

    public GraphNode[] getAdjacent() {
        return adjacent;
    }
}