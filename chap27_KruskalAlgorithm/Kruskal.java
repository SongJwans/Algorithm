package chap27_KruskalAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Kruskal {
    // Node -> 부모 노드를 알수있는 HashMap
    HashMap<String, String> parent = new HashMap<>();
    // 랭크 정보를 알수 있는 HashMap
    HashMap<String, Integer> rank = new HashMap<>();

    public String find(String node) {
        // path compresion 기법 ->
        // 탐색하는 모든 노드의 부모 노드가 루트 노드가 될수 있게

        // parent.get 은 부모 노드를 알수 있다.
        if (this.parent.get(node) != node) {
            this.parent.put(node, this.find(this.parent.get(node)));
        }
        return this.parent.get(node);
    }

    // 두 노드를 받아 합치는 것

    public void union(String nodeV, String nodeU) {
        String root1 = this.find(nodeV);
        String root2 = this.find(nodeU);


        // union-by-rank 기법
        if (this.rank.get(root1) > this.rank.get(root2)) {
            this.parent.put(root2, root1);
        } else {
            this.parent.put(root1, root2);
            //만약 두개의 노드의 rank가 같다면 둘 중 하나의 랭크를 올려 합친다.
            if (this.rank.get(root1) == this.rank.get(root2)) {
                this.rank.put(root2, this.rank.get(root2) + 1);
            }
        }
    }

    // 초기화를 위한 makeSet
    public void makeSet(String node) {
        this.parent.put(node, node);
        this.rank.put(node, 0);
    }

    public ArrayList<Edge> kruskalFunc(ArrayList<String> vertices, ArrayList<Edge> edges) {
        ArrayList<Edge> mst = new ArrayList<>();
        Edge currentEdge;

        // 1.초기화
        for (int i = 0; i < vertices.size(); i++) {
            this.makeSet(vertices.get(i));
        }

        // 2. 간선 weight 기반 sorting -> GreedyAlgorithm을 사용하기 위해서
        Collections.sort(edges);

        for (int i = 0; i < edges.size(); i++) {
            currentEdge = edges.get(i);
            //사이클이 있는 지 확인하기
            if (this.find(currentEdge.nodeV) != this.find(currentEdge.nodeU)) {
                this.union(currentEdge.nodeV, currentEdge.nodeU);
                mst.add(currentEdge);
            }
        }

        return mst;
    }

    public static void main(String[] args) {
        {
            ArrayList<String> vertices = new ArrayList<String>(Arrays.asList("A", "B", "C", "D", "E", "F", "G"));
            ArrayList<Edge> edges = new ArrayList<Edge>();

            edges.add(new Edge(7, "A", "B"));
            edges.add(new Edge(5, "A", "D"));
            edges.add(new Edge(7, "B", "A"));
            edges.add(new Edge(8, "B", "C"));
            edges.add(new Edge(9, "B", "D"));
            edges.add(new Edge(7, "B", "E"));
            edges.add(new Edge(8, "C", "B"));
            edges.add(new Edge(5, "C", "E"));
            edges.add(new Edge(5, "D", "A"));
            edges.add(new Edge(9, "D", "B"));
            edges.add(new Edge(7, "D", "E"));
            edges.add(new Edge(6, "D", "F"));
            edges.add(new Edge(7, "E", "B"));
            edges.add(new Edge(5, "E", "C"));
            edges.add(new Edge(7, "E", "D"));
            edges.add(new Edge(8, "E", "F"));
            edges.add(new Edge(9, "E", "G"));
            edges.add(new Edge(6, "F", "D"));
            edges.add(new Edge(8, "F", "E"));
            edges.add(new Edge(11, "F", "G"));
            edges.add(new Edge(9, "G", "E"));
            edges.add(new Edge(11, "G", "F"));

            Kruskal kObject = new Kruskal();
            System.out.println(kObject.kruskalFunc(vertices, edges));
        }
    }
}
