package Questions.Chapter4;
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
        for (GraphNode graphNode : n) {
            // For clarity, sout calls the overwritten toString method in this file.
            //System.out.println(graphNode);
            graphNode.printOut();
        }

        // Pick two nodes and determine if there is a route between them.
        for (int i = 0; i < n.length; i++) {
            for (int j = 0; j < n.length; j++) {
                System.out.println("=============================================");
                System.out.printf("%s to %s: %b\n", n[i].getName(), n[j].getName(), routeAvailableBreadth(graph, n[i], n[j]));
                System.out.printf("%s to %s: %b\n", n[i].getName(), n[j].getName(), routeAvailableDepth(graph, n[i], n[j]));
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

    // Depth-First Search
    public static boolean routeAvailableDepth(Graph g, GraphNode start, GraphNode end) {
        for (GraphNode i : start.getAdjacent()) {
            if (i == null) {
                break;
            }
            if (i == end) {
                return true;
            }
            if (i.state != State.Visited) {
                routeAvailableDepth(g, i, end);
            }
//            else {
//                routeAvailableDepth(g, i, end);
//            }
        }
        return false;
    }

    // Breadth-First Search
    public static boolean routeAvailableBreadth(Graph g, GraphNode start, GraphNode end) {
        LinkedList<GraphNode> list = new LinkedList<>(); // Operates as a queue for BFS

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
    // vertices refer to the nodes in the graph.
    private GraphNode[] vertices;
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
            System.out.print("Questions.Chapter4.Graph full");
            return null;
        }
    }
}


class GraphNode {
    /*
        The Questions.Chapter4.Graph instance will be made in the main.
        adjacent: array to hold number of adjacent nodes
     */
    private GraphNode[] adjacent;
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

    public void printOut() {
        System.out.println(name + " with " + adjacentCount + " adj");
    }
}
