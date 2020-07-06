package com.davidriad.se.project.se_project_grp8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Suggest {

    private ArrayList<String> plantsId ;
    private Map<String, ArrayList<String>> plantAdjacencyList;

    private int numVertices;
    private BFS bfs;

    public Suggest(ArrayList<String> plantsId, Map<String, ArrayList<String>> plantAdjacencyList) {
        this.plantsId = plantsId;
        this.plantAdjacencyList = plantAdjacencyList;

        this.numVertices = plantsId.size();
        this.bfs = new BFS(0,numVertices-1,numVertices);

        constructGraph();
    }

    private void constructGraph(){
       for (int i=0; i<plantsId.size();i++){
           String plantId = plantsId.get(i);
            for (int j=0; j< plantAdjacencyList.get(plantId).size(); j++){
                String adjacentId = plantAdjacencyList.get(plantId).get(j);
                bfs.addEdge(i,plantsId.indexOf(adjacentId));
           }
       }
   }

   public ArrayList<Integer>  suggest (String plant1, String plant2){
       int plant1Id = plantsId.indexOf(plant1.toLowerCase());
       int plant2Id = plantsId.indexOf(plant2.toLowerCase());
       bfs.makePath(plant1Id,plant2Id);
       ArrayList<Integer> path = bfs.getPath();
       return path;
   }


}
