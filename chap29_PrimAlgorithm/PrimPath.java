package chap29_PrimAlgorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class PrimPath {
    public ArrayList<Path> improvedPrimFunc(HashMap<String, HashMap<String,Integer>>graph,String startNode){
        ArrayList<Path>mst = new ArrayList<>();

        PriorityQueue<Edge>keys = new PriorityQueue<>();

        for (String key: graph.keySet()){
            if(key == startNode){

            }else{

            }
        }
        return mst;
    }
}
