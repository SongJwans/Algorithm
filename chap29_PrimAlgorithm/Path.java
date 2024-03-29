package chap29_PrimAlgorithm;
//경로를 별도로 표시하기 위한 클래스
public class Path{
    public String node1;
    public String node2;
    public int weight;

    public Path(String node1, String node2, int weight) {
        this.node1 = node1;
        this.node2 = node2;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Path{" +
                "node1='" + node1 + '\'' +
                ", node2='" + node2 + '\'' +
                ", weight=" + weight +
                '}';
    }
}
