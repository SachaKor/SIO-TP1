import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import intlist.IntList;
import intlist.IntListIterator;

public class Graph {

    private IntList[] adjecncyLists;

    private int nbVertices;
    private int nbEdges;
    private int[] degrees;

    public Graph(String filename) throws IOException {
        BufferedReader is = null;

        try {
            is = new BufferedReader(new FileReader(filename));
            String l;

            // Read |V| and |E|
            if((l = is.readLine()) != null) {
                String[] splitted = l.split(" ");
                nbVertices = Integer.parseInt(splitted[0]);
                nbEdges = Integer.parseInt(splitted[1]);

                adjecncyLists = new IntList[nbVertices];
                degrees = new int[nbVertices];
            }

            // Read |E| edges
            for (int i = 0; i < nbEdges; ++i) {
                if((l = is.readLine()) != null) {
                    String[] vertices = l.split(" ");
                    int v = Integer.parseInt(vertices[0])-1;
                    int w = Integer.parseInt(vertices[1])-1;

                    // Initialize the adjacency lists if it's needed
                    if (adjecncyLists[v] == null) {
                        adjecncyLists[v] = new IntList();
                    }
                    if(adjecncyLists[w] == null)  {
                        adjecncyLists[w] = new IntList();
                    }

                    addEdge(v, w);
                } else {
                    System.out.println("More edges needed");
                    break;
                }
            }
        } finally {
            if (is != null) {
                is.close();
            }
        }

    }

    public int V() {
        return nbVertices;
    }

    public int E() {
        return nbEdges;
    }

    public void addEdge(int v, int w) {
        adjecncyLists[v].add(w);
        degrees[v]++;
        if(w != v) {
            adjecncyLists[w].add(v);
            degrees[w]++;
        }
    }

    public IntList adjacent(int v) {
        return adjecncyLists[v];
    }

    public String toString() {
        String graph = nbVertices + " " + nbEdges + "\n";

        for(int v = 0; v < nbVertices; ++v) {
            graph += v + "[" + degrees[v] + "]: ";
            IntListIterator li = adjecncyLists[v].iterator();
            while (li.hasNext()) {
                Integer w = li.next();
                graph += w + "--" + new Integer(v) + " ";
            }
            graph += "\n";
        }
        return graph;
    }

    public void forEveryAdjacentVertex(int v, IVertexVisitor visitor) {
        IntListIterator it = adjecncyLists[v].iterator();
        while (it.hasNext()) {
            int w = it.next();
            visitor.visit(w);
        }
    }

    public int degree(int v) {
        return degrees[v];
    }

}
