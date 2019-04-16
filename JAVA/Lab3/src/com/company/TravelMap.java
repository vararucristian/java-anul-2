package com.company;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Stream;

import static javafx.application.Platform.exit;

public class TravelMap {
    List<Node> nodes;
    List<Edge> edges;

    public String getNodes() {
        StringBuilder result = new StringBuilder();
        nodes.sort(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.compareTo(o2);
            }
        });
        for (Node node : nodes)
            result.append(node.name + " ");

        return result.toString();

    }


    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

    public TravelMap() {
        nodes = new ArrayList<Node>();
        edges = new ArrayList<Edge>();

    }

    public void addNode(Node node) {
        nodes.add(node);
    }

    public void addEdge(Node node1, Node node2, int cost) {
        if (nodes.contains(node1) && nodes.contains(node2)) {
            Edge edge = new Edge(node1, node2, cost);
            edges.add(edge);
            Edge edge2 = new Edge(node2, node1, cost);
            edges.add(edge2);
        } else {
            System.err.println("One of those location is not on the map.");
            exit();
        }
    }

    public void addEdge(Node node1, Node node2, int cost, boolean twoWays) {
        if (nodes.contains(node1) && nodes.contains(node2)) {
            Edge edge = new Edge(node1, node2, cost);
            edges.add(edge);
            if (twoWays) {
                Edge edge2 = new Edge(node2, node1, cost);
                edges.add(edge2);
            }
        } else {
            System.err.println("One of those location is not on the map.");
            exit();
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        List<Edge> usedEdges = new ArrayList<Edge>();
        int ok = 0;
        for (Edge edge1 : edges) {
            ok = 0;
            for (Edge edge2 : edges)
                if (edge1.start.equals(edge2.finish) && edge1.finish.equals(edge2.start)) {
                    usedEdges.add(edge2);
                    ok = 1;
                }
            if (ok == 1) {
                if (!usedEdges.contains(edge1)) {
                    result.append(edge1.start.name + "\u2194" + edge1.finish.name + " " + edge1.cost + "\n");
                    usedEdges.add(edge1);
                }
            } else
                result.append(edge1.start.name + "\u2192" + edge1.finish.name + " " + edge1.cost + "\n");
        }
        return result.toString();
    }

    public void display1() {
        this.nodes.stream()
                .filter(p -> p instanceof Visitable)
                .filter(p -> p instanceof Payable == false)
                .sorted((new Comparator<Node>() {
                    @Override
                    public int compare(Node o1, Node o2) {
                        return ((Visitable)o1).getOpeningHour().compareTo(((Visitable)o2).getOpeningHour());
                    }
                }))
                .forEach(p -> System.out.println(p.name));
    }

    public void display2() {
        OptionalDouble optionalAverage = this.nodes.stream()
                .filter(p -> p instanceof Payable)
                .mapToDouble(p -> ((Payable) p).getPriceOfTicket())
                .average();

        if (optionalAverage.isPresent()) {
            double average = optionalAverage.getAsDouble();
            System.out.println(average);
        }
    }

    public List<Edge> greedyPath(Node n1,Node n2,List<Node> block,List<Edge> path){
        int min=1000;
        for (Edge edge:edges)
        {
            if (edge.start.equals(n1))
            {
              if (edge.finish.equals(n2))
              {
                  path.add(edge);
                  return path;
              }
              if(edge.cost<min && !block.contains(edge.finish))
                  min=edge.cost;

            }
                     }
        for (Edge edge:edges)
            if(edge.cost==min)
            {   path.add(edge);
                return (greedyPath(edge.finish,n2,block,path));
            }
        block.add(path.get(path.size()-1).finish);
        path.remove(path.size()-1);
        return greedyPath(path.get(path.size()-1).start,n2,block,path);
    }
}




