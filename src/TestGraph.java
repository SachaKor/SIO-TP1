import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class TestGraph {
    public static void main(String[] args) {
        Graph graph = null;
        try {
            graph = new Graph("graphFromLecture.txt");
        } catch (IOException ex) {
            System.out.println("wops");
        }

        System.out.println(graph);

        List<Integer> list = new LinkedList<>();

        for(int v = 0; v < graph.V(); ++v) {
            System.out.print("[" + (v+1) + "]: ");
            graph.forEveryAdjacentVertex(v, new IVertexVisitor() {
                @Override
                public void visit(int w) {
                    System.out.print((w+1) + " ");
                    list.add(w+1);
                }
            });
            System.out.println();
        }

        for(int v : list) {
            System.out.print(v + " ");
        }

    }
}
