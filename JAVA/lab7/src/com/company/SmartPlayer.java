package com.company;

import java.util.ArrayList;
import java.util.List;

public class SmartPlayer extends Player {

    public SmartPlayer(String name) {
        super(name);
    }

    @Override
    protected void playIndividual() {
        List<Integer> nodes = new ArrayList<Integer>();
        for (Edge edge : graph.edges)
        { nodes.add(edge.node2);
        nodes.add(edge.node1);
        }
        List<Edge> posibleEdges=new ArrayList<Edge>();
        for (Edge edge:game.board.complete.edges)
        {if(nodes.contains(edge.node1)&&!nodes.contains(edge.node2))
            posibleEdges.add(edge);
        if(nodes.contains(edge.node2)&&!nodes.contains(edge.node1))
            posibleEdges.add(edge);
        }
        int[] nodesGrade=new int[game.board.complete.nrOfNodes+1];
        for (int i=0;i<graph.nrOfNodes;i++)
            nodesGrade[i]=0;
        for(Edge edge:game.board.complete.edges) {
            nodesGrade[edge.node1]++;
            nodesGrade[edge.node2]++;
        }
        int min=game.board.complete.nrOfNodes;
        for (Edge edge:posibleEdges)
        {
            if(!nodes.contains(edge.node1)&& nodesGrade[edge.node1]<min)
                min=nodesGrade[edge.node1];
            if(!nodes.contains(edge.node2)&& nodesGrade[edge.node2]<min)
                min=nodesGrade[edge.node2];
        }
        for (Edge edge:posibleEdges)
        {
            if(!nodes.contains(edge.node1)&& nodesGrade[edge.node1]==min)
            {
                graph.add(edge);
                game.board.complete.edges.remove(edge);
                System.out.println( toString(edge));
                break;
            }
            if(!nodes.contains(edge.node2)&& nodesGrade[edge.node2]==min)
            {
                graph.add(edge);
                game.board.complete.edges.remove(edge);
                System.out.println( toString(edge));
                break;
            }
        }

    }
}