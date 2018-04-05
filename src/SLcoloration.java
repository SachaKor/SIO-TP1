import dlist.*;
import intlist.IntList;

public class SLcoloration {
    private Graph graph;
    private int degreeMin;
    private int degreeMax;
    IntList order; // order of the coloration
    int[] colors; // colors of the vertices

    public SLcoloration(Graph graph) {
        this.graph = graph;
        degreeMin = graph.V();
        degreeMax = -1;

        colorationOrder();
        colorate();
    }

    private void colorationOrder() {

        int nbVertices = graph.V();
        order = new IntList();
        // treated[v] is true if v vertex has been added to the order list
        boolean[] treated = new boolean[nbVertices];
        // contains the references to the elements of degrees
        Element[] references = new Element[nbVertices];
        // contains the current degrees of the vertices
        int[] currentDegrees = new int[nbVertices];

        for(int v = 0; v < nbVertices; ++v) {
            // define the minimum degree of the graph
            if(graph.degree(v) < degreeMin) {
                degreeMin = graph.degree(v);
            }

            // define the maximum degree of the graph
            if(graph.degree(v) > degreeMax) {
                degreeMax = graph.degree(v);
            }
            currentDegrees[v] = graph.degree(v);
        }

        // degree[k] will contain a DList of all vertices with the degree equal to k
        DList[] degrees = new DList[degreeMax+1];

        // initialize the degrees array
        for(int k = 0; k <= degreeMax; ++k) {
            degrees[k] = new DList();
        }

        for(int v  = 0; v < nbVertices; ++v) {
            Element vertex = new Element(v);
            degrees[graph.degree(v)].add(vertex);
            references[v] = degrees[graph.degree(v)].getHead();
        }


        for(int i = 0; i < nbVertices; ++i) {

            while(degrees[degreeMin].isEmpty()) {
                ++degreeMin;
            }

            Element vertexOfMinDegree = degrees[degreeMin].getHead();
            int v = vertexOfMinDegree.getData();
            degrees[degreeMin].remove(vertexOfMinDegree);
            order.add(vertexOfMinDegree.getData());
            treated[v] = true;

            graph.forEveryAdjacentVertex(v, new IVertexVisitor() {
                @Override
                public void visit(int w) {
                    if(!treated[w]) {
                        degrees[currentDegrees[w]].remove(references[w]);
                        --currentDegrees[w];
                        degrees[currentDegrees[w]].add(references[w]);

                        if(currentDegrees[w] < degreeMin) {
                            degreeMin = currentDegrees[w];
                        }

                    }
                }
            });

        }

    }

    private void colorate() {
        colors = new int[graph.V()];
        // isTaken[k] is true if the color k is used by at least one of the vertice adjacent to the current one
        boolean[] isTaken = new boolean[degreeMax+2];

        while (!order.isEmpty()) {
            int v = order.removeFirst();
            // mark all the colors used by the adjacent vertices
            graph.forEveryAdjacentVertex(v, new IVertexVisitor() {
                @Override
                public void visit(int w) {
                    if(colors[w] != 0) {
                        isTaken[colors[w]] = true;
                    }
                }
            });

            // find the first available color
            for(int c = 1; c <= graph.degree(v)+1; ++c) {
                if(!isTaken[c]) {
                    colors[v] = c;
                    break;
                }
            }

            // reset the isTaken flags
            graph.forEveryAdjacentVertex(v, new IVertexVisitor() {
                @Override
                public void visit(int w) {
                    isTaken[colors[w]] = false;
                }
            });
        }
    }

    public int[] getColors() {
        return colors;
    }
}
