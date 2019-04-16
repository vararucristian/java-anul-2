package com.company;

public class Tree   {
    int n;
    int matrix[][];
    Tree(int n) {
        this.n = n;
        matrix = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                matrix[i][j] = 0;
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
}