package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Graph {
    int nrOfNodes;
    List<Edge> edges;

    public Graph() {
        edges=new ArrayList<Edge>();
    }

    public Edge pollFirst() {
        Random random=new Random();
        int n=edges.size();
        return edges.get(random.nextInt(n)%n);

    }

    public void add(Edge extract) {
        this.edges.add(extract);
    }

    private boolean isCircuite(int startNode){
        List<Boolean> visited;
        List<Edge> usedEdges=new ArrayList<Edge>();
        visited=new ArrayList<Boolean>();
        for(int i=0;i<nrOfNodes;i++)
            visited.add(false);
        visited.set(startNode-1,true);
        boolean ok=true;
        while (ok)
        {   ok=false;
            for(Edge edge:edges)
        {
            if (usedEdges.contains(edge)==false)
            {
            if(edge.node1==startNode)
            { ok=true;
                startNode=edge.node2;
                if(visited.get(edge.node2-1)==true)
                    return true;
                visited.set(startNode-1,true);
                usedEdges.add(edge);
            }
            else
            if(edge.node2==startNode)
            {   ok=true;
                startNode=edge.node1;
                if(visited.get(edge.node1-1)==true)
                    return true;
                visited.set(startNode-1,true);
                usedEdges.add(edge);
            }
        }
        }
        }
        return false;
    }
    public boolean isSpanningTree() {
        for (int i =1;i<=this.nrOfNodes;i++)
            if(isCircuite(i))
                return false;

        List<Boolean> visited;
        visited=new ArrayList<Boolean>();
        for(int i=0;i<nrOfNodes;i++)
            visited.add(false);

        for(Edge edge:edges) {
            visited.set(edge.node1-1, true);
            visited.set(edge.node2-1, true);
        }
        for(Edge edge:edges){
            if(visited.get(edge.node1-1)==false)
                return false;
            if(visited.get(edge.node2-1)==false)
                return false;
        }
        if(edges.size()==nrOfNodes-1)
            return true;
        return false;
    }
}
