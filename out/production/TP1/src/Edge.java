/**
 * Class Edge implements a non directed edge of a graph
 */
public class Edge {

    private int v1;
    private int v2;

    public Edge(int v1, int v2) {
        this.v1 = v1;
        this.v2 = v2;
    }

    /**
     * Returns a vertex index incident to an edge
     * @return one of incident vertex of an edge
     */
    public int Either() {
        return v1;
    }

    /**
     * Returns a vertex incident to an edge different from the one passed as an argument
     * @param v a vertex incident to an edge
     * @return a vertex incident to v different from v
     */
    public int Other(int v) {
        return (v == v1 ? v2 : v1);
    }

    public String toString() {
        return Integer.toString(v1) + "--" + Integer.toString(v2);
    }
}
