
/*
This implementation of Breadth-First Search Algorithm was done by: Omar Farag
 */


package com.davidriad.se.project.se_project_grp8;


import java.util.ArrayList;

public class BFS {
    int start;
    int end;
    int vertices;
    ArrayList<Boolean> vis= new ArrayList<Boolean>();
    ArrayList<ArrayList<Integer>> adj;
    ArrayList<Integer> pre = new ArrayList<Integer>();
    ArrayList<Integer> path= new ArrayList<Integer>();

    public ArrayList<Integer> getPath() {
        return path;
    }
    boolean checkEdgeExists(int a, int b){
        if(b < adj.get(a).size())
            for(int i=0; i<adj.get(a).size(); i++){
                if(adj.get(a).get(i)== b)
                    return true;
            }
        return false;
    }

    public void addEdge(int a, int b){
        if(!checkEdgeExists(a,b)) {
            adj.get(a).add(b);
            //adj.get(b).add(a);
        }
    }

    public BFS(int s, int e, int v){
        start = s;
        end = e;
        vertices =v;
        adj = new ArrayList<ArrayList<Integer>>(vertices+1);
        for (int i=0; i < vertices; i++)
            adj.add(new ArrayList<Integer>());
    }

    boolean doBFS(int s, int e) {
        for (int i = 0; i<vertices; i++){
            vis.add(false);
            pre.add(-1);
        }
        ArrayList<Integer> q = new ArrayList<Integer>();
        vis.set(s,true);
        q.add(s);


        while(!q.isEmpty()){
            int u =q.get(0);
            q.remove(0);

            int size=adj.get(u).size();

            for(int i =0; i <size; i++ ){
                if( !vis.get(adj.get(u).get(i))){
                    vis.set(adj.get(u).get(i),true);
                    pre.set(adj.get(u).get(i) , u );
                    q.add(adj.get(u).get(i));

                    if(adj.get(u).get(i)== e){
                        return true;
                    }

                }
            }
        }
        return false;
    }

    public void makePath(int s, int e){
        start=s;
        end=e;
        path.clear();
        if(!doBFS(s,e)){
            pre.clear();
            vis.clear();
            return;}
        int crawl = e;
        path.add(crawl);
        while(pre.get(crawl) != -1){
            path.add(pre.get(crawl));
            crawl= pre.get(crawl);
        }
        pre.clear();
        vis.clear();
    }
}
