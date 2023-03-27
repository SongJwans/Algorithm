package chap25_GreedyAlgorithm;

import java.util.Arrays;
import java.util.Comparator;

public class Edge implements Comparable<Edge> {
    public Integer distance;
    public String vertex;

    public Edge(Integer distance, String vertex) {
        this.distance = distance;
        this.vertex = vertex;
    }

    @Override
    public int compareTo(Edge e) {
        return this.distance - e.distance;
    }

    public static void main(String[] args) {
        Edge ed1 = new Edge(12, "A");
        Edge ed2 = new Edge(10, "A");
        Edge ed3 = new Edge(15, "A");

        Edge[] edges = new Edge[]{ed1, ed2, ed3};
        Arrays.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o2.distance - o1.distance;
            }
        });

        for (int i = 0; i < edges.length; i++) {
            System.out.println(edges[i].distance);
        }
    }


}
