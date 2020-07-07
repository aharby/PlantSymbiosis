package com.davidriad.se.project.se_project_grp8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Suggest {

    private static ArrayList<String> plantsNameList =new ArrayList<>() ;
    private static Map<String, ArrayList<String>> plantAdjacencyList = new HashMap<>();

    private static int numVertices;
    BFS bfs;

    public Suggest(ArrayList<String> names, Map<String, ArrayList<String>> adjacencyList) {
        plantsNameList = names;
        plantAdjacencyList = adjacencyList;
        numVertices = plantsNameList.size();
        bfs = new BFS(0,numVertices-1, numVertices);
        constructGraph();
    }



    public void constructGraph(){
       for (int i=0; i<plantsNameList.size();i++){
           String plantName = plantsNameList.get(i);
            for (int j=0; j< plantAdjacencyList.get(plantName).size(); j++){
                String adjacentPlant = plantAdjacencyList.get(plantName).get(j);
                if (plantsNameList.indexOf(adjacentPlant)!= -1)
                    bfs.addEdge(i,plantsNameList.indexOf(adjacentPlant));
           }
       }
   }



    public  ArrayList<String> suggest (String plant1, String plant2){
       int v1 = plantsNameList.indexOf(plant1.toLowerCase());
       int v2 = plantsNameList.indexOf(plant2.toLowerCase());
       bfs.makePath(v1,v2);
       ArrayList<Integer> path = bfs.getPath();
       ArrayList<String> pathByNames = new ArrayList<>();
       for(int i=0; i<path.size();i++){
           pathByNames.add(plantsNameList.get(path.get(i)));
       }
       return pathByNames;
   }


}
