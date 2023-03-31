package chap28_PrimAlgorithm;

import com.sun.tools.javac.Main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Prim {
    public ArrayList<Edge> primFunc(String startNode, ArrayList<Edge> edges) {

        Edge currentEdge, poppedEdge, adjacentEdgeNode;
        PriorityQueue<Edge> priorityQueue;
        // 모든 간선 정보를 저장
        ArrayList<String> connectedNodes = new ArrayList<>();
        ArrayList<Edge> currentEdgeList, candidateEdgeList, adjacentEdgeNodes;
        //최소 신장 트리
        ArrayList<Edge> mst = new ArrayList<>();

        HashMap<String, ArrayList<Edge>> adjacentEdges = new HashMap<>();

        // edges 에있는 정보를 초기화하기
        for (int i = 0; i < edges.size(); i++) {
            //edges 에 있는 정보를 agjacentEdges에 넣기 위헤서
            //HashMap -> adjacentEdges를 통해 인접한 노드를 쉽게 알기 위해서
            currentEdge = edges.get(i);

            //edges에 있는 정보를 adjacentEdges에 초기화 할 때 중복되는 값이 없게 하기 위해서
            //node1, node2 검사
            if (!adjacentEdges.containsKey(currentEdge.node1)) {
                adjacentEdges.put(currentEdge.node1, new ArrayList<Edge>());
            }
            if (!adjacentEdges.containsKey(currentEdge.node2)) {
                adjacentEdges.put(currentEdge.node2, new ArrayList<Edge>());
            }
        }
        // 각각의 노드마다 연결리스트를 추가해야 한다. HashMap<String, ArrayList<Edge>>
        for (int i = 0; i < edges.size(); i++) {
            currentEdge = edges.get(i);
            currentEdgeList = adjacentEdges.get(currentEdge.node1);
            currentEdgeList.add(new Edge(currentEdge.weight, currentEdge.node1, currentEdge.node2));
            currentEdgeList = adjacentEdges.get(currentEdge.node2);
            currentEdgeList.add(new Edge(currentEdge.weight, currentEdge.node2, currentEdge.node1));
        }

        connectedNodes.add(startNode); //node1이 들어가있다?
        candidateEdgeList = adjacentEdges.getOrDefault(startNode, new ArrayList<Edge>());
        priorityQueue = new PriorityQueue<Edge>();
        for (int i = 0; i < candidateEdgeList.size(); i++) {
            priorityQueue.add(candidateEdgeList.get(i));
        }

        while (priorityQueue.size() > 0) {
            poppedEdge = priorityQueue.poll();
            if (!connectedNodes.contains(poppedEdge.node2)) {
                // 해당 edge 를 mst 에 추가
                connectedNodes.add(poppedEdge.node2);
                mst.add(new Edge(poppedEdge.weight, poppedEdge.node1, poppedEdge.node2));

                adjacentEdgeNodes = adjacentEdges.getOrDefault(poppedEdge.node2, new ArrayList<>());
                for (int i = 0; i < adjacentEdgeNodes.size(); i++) {
                    adjacentEdgeNode = adjacentEdgeNodes.get(i);

                    if (!connectedNodes.contains(adjacentEdgeNode.node2)) {
                        priorityQueue.add(adjacentEdgeNode);
                    }
                }
            }
        }
        return mst;
    }

    public static void main(String[] args) {
        ArrayList<Edge> myedges = new ArrayList<Edge>();
        myedges.add(new Edge(7, "A", "B"));
        myedges.add(new Edge(5, "A", "D"));
        myedges.add(new Edge(8, "B", "C"));
        myedges.add(new Edge(9, "B", "D"));
        myedges.add(new Edge(7, "D", "E"));
        myedges.add(new Edge(5, "C", "E"));
        myedges.add(new Edge(7, "B", "E"));
        myedges.add(new Edge(6, "D", "F"));
        myedges.add(new Edge(8, "E", "F"));
        myedges.add(new Edge(9, "E", "G"));
        myedges.add(new Edge(11, "F", "G"));

        Prim pObject = new Prim();
        System.out.println(pObject.primFunc("A", myedges));
    }
}
