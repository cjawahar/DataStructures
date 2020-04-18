package Questions;
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
        for (int i = 0; i < n.length; i++) {
            System.out.println(n[i]);
        }

        // Pick two nodes and determine if there is a route between them.
        for (int i = 0; i < n.length; i++) {
            for (int j = 0; j < n.length; j++) {
                System.out.printf("%s to %s: %b\n", n[i].getName(), n[j].getName(), routeAvailable(graph, n[i], n[j]));
            }
        }
    }

    public static Graph createNewGraph() {
        Graph g = new Graph(5);

        GraphNode sfo = g.addNode("SFO");
        GraphNode sjc = g.addNode("SJC");
        GraphNode oak = g.addNode("OAK");
        GraphNode lax = g.addNode("LAX");
        GraphNode sdg = g.addNode("SDG");

        // Only sfo, lax, and sdg have adjacent nodes.
        sfo.addAdjacent(sjc);
        sfo.addAdjacent(oak);
        lax.addAdjacent(sdg);
        sdg.addAdjacent(lax);

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
                    if (i == null) {
                        break;
                    }
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
    private GraphNode vertices[];
    private int count;
    private int size;

    public Graph(int size) {
        this.size = size;
        vertices = new GraphNode[size];
        count = 0;
    }

    public GraphNode[] getNodes() {
        return vertices;
    }

    public GraphNode addNode(String name) {
        if (count < size) {
            return vertices[count++] = new GraphNode(name);
        } else {
            System.out.print("Questions.Graph full");
            return null;
        }
    }
}


class GraphNode {
    /*
        The Questions.Graph instance will be made in the main.
        adjacent: array to hold number of adjacent nodes
        adjacentCount: simple int to hold the count.
     */
    private GraphNode adjacent[];
    public int adjacentCount;
    private String name;
    public Question4_2.State state;
    final int MAX_ADJ = 10;
     

    //Method to add nodes
    public GraphNode(String name) {
        this.name = name;
        adjacentCount = 0;
        // use length to set length of adjacent array.
        // need to fill out which nodes are adjacent still
        adjacent = new GraphNode[MAX_ADJ];
    }

    public void addAdjacent(GraphNode x) {
        // count starts at 0
        // add adjacent graphNodes to array starting at index 0.
        if (adjacentCount < MAX_ADJ) {
            this.adjacent[adjacentCount] = x;
            adjacentCount++;
        } else {
            System.out.print("No more adjacent can be added");
        }
    }

    public GraphNode[] getAdjacent() {
        return adjacent;
    }
    public String getName() {
        return name;
    }

    public String toString() {
        return name + " with " + adjacentCount + " adj";
    }
}
