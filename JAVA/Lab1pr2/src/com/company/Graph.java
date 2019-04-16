package com.company;

public class Graph {
    public
    int matrix[][];
    int n;

    Graph(int n) {
        this.n = n;
        matrix = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                matrix[i][j] = 0;
    }

    void buildComplet() {
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                matrix[i][j] = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (i != j)
                    matrix[i][j] = 1;
    }

    void buildCircuite() {
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                matrix[i][j] = 0;
        for (int i = 0; i < n; i++)
            if (i != 0 && i != n - 1) {
                matrix[i][i - 1] = 1;
                matrix[i][i + 1] = 1;
            }
        matrix[0][1] = 1;
        matrix[0][n - 1] = 1;
        matrix[n - 1][0] = 1;
        matrix[n - 1][n - 2] = 1;
    }

    void buildRandom() {
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                matrix[i][j] = 0;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++) {
                matrix[i][j] = (int) Math.round(Math.random());
                matrix[j][i] = matrix[i][j];
            }
    }

    void displayMatrix() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0)
                    System.out.print("\u2654");
                else
                    System.out.print("\u265B");
            }
            System.out.println("");
        }
    }

    int getNumberOfEdges() {
        int edges = 0;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++) {
                if (matrix[i][j] == 1)
                    edges++;
            }
        return edges;
    }

    int getMaximDegree() {
        int degree = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1)
                    degree++;
            }
            if (degree > max)
                max = degree;
            degree = 0;
        }
        return max;
    }

    int getMinimDegree() {
        int degree = 0;
        int min = n;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1)
                    degree++;
            }
            if (degree < min)
                min = degree;
            degree = 0;
        }
        return min;
    }


    void isRegular() {
        if (this.getMaximDegree() == this.getMinimDegree())
            System.out.println("This is a regular Graph!");
        else
            System.out.println("This is not a regular Graph!");
    }


    int sumDegrees() {
        int degree = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (matrix[i][j] == 1)
                    degree++;
        if (degree==2*this.getNumberOfEdges())
            return 1;
    return 0;
    }
    int isConnectedGraph( int start, int end, int visited[])
    {
        DFS(start, visited);
        for ( int i=0; i<n ; i++)
            if (visited[i]==0)
                return 0;
        return 1;
    }


    int getNrOfConexComponents() {
        int visited[]= new int[n];
        int nrOfConex=0;
        for (int i=0;i<n ; i++)
            if (visited[i]==0) {
                DFS(i, visited);
                nrOfConex++;
            }
        return nrOfConex;
    }

    void DFS (int node, int visit[])
    {
        visit[node]=1;
        for (int i=0;i<n ; i++)
            if (matrix[node][i] == 1 && visit[i] == 0) {
                visit[i] =1;
                DFS(i, visit);
            }
    }

    void createEdges(int root ,int used[])
    {   int ok=1;
        while(ok==1){
            ok=0;

            for(int i=0;i<n;i++)
            {
                if(used[i]!=1)
                {
                    used[i]=(int) Math.round(Math.random());
                    matrix[i][root]=used[i];
                    matrix[root][i]=used[i];
                    if(used[i]==1) {
                        createEdges(i, used);
                        ok=1;
                    }
                }

            }}

    }
    void buildTree() {
        int used[]= new int[n];

        int root = (int) (Math.random() * (n - 1));
        used[root] = 1;
        createEdges(root,used);

    }

}
