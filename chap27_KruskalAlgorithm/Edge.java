package chap27_KruskalAlgorithm;

public class Edge implements Comparable<Edge> {
    // 객체 간 정렬! -> Comparable

    public int weight;
    public String nodeV;
    public String nodeU;

    public Edge(int weight, String nodeV, String nodeU) {
        this.weight = weight;
        this.nodeV = nodeV;
        this.nodeU = nodeU;
    }

    public String toString() {
        return "(" + this.weight + ", " + this.nodeV + ", " + this.nodeU + ")";
    }

    @Override
    public int compareTo(Edge edge) {
        return this.weight - edge.weight;
    }
}
