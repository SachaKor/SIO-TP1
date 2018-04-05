import java.io.IOException;

public class TestSLcoloration {
    public static void main(String[] args) {
        Graph graph = null;
        try {
            graph = new Graph("graphFromLecture.txt");
        } catch (IOException e) {
            System.out.println(e);
        }
        SLcoloration coloration = new SLcoloration(graph);
        int[] colors = coloration.colors;

        for(int c : colors) {
            System.out.print(c + " ");
        }
    }
}
