package com.company;

public class Main {

    public static void main(String[] args) {
        long start = System.nanoTime();
        int n = Integer.parseInt(args[0]);
        if (n % 2 != 1)
            System.out.println("Numarul este par!");
        else {
            Graph graph = new Graph(n);
            if (args[1].equals( "circuite")) {
                graph.buildCircuite();
                System.out.println("This is a circuite!");
            }
            if (args[1].equals("random")) {
                graph.buildRandom();
                System.out.println("This is a random graph!");
            }
            if (args[1].equals( "complete")) {
                graph.buildComplet();
                System.out.println("This is a complete graph!");
            }
            if (args[1].equals("tree")) {
                graph.buildTree();
                System.out.println("This is a random tree");
            }

            graph.displayMatrix();
            System.out.println("number of edges="+graph.getNumberOfEdges());
            System.out.println("\u0394(G)=" + graph.getMaximDegree());
            System.out.println("\u03B4(G)=" + graph.getMinimDegree());
            graph.isRegular();
            if (graph.sumDegrees() == 1)
                System.out.println("Sum of the degrees equals the value 2 * m ");
            long finish = System.nanoTime();
            long totalTime = finish - start;
            System.out.println(totalTime);
            int visit[]=new int[n];
            if(graph.isConnectedGraph(0,n-1,visit)==1)
                System.out.println("The graph is connected!");
            else
                System.out.println("The graph is not connected!");
            System.out.println("Nr of conex components is: "+ graph.getNrOfConexComponents());
        }

    }
}
