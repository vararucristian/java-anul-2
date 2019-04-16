package com.company;

import org.omg.CORBA.DynAnyPackage.Invalid;

import java.security.InvalidParameterException;
import java.util.Objects;

public class Edge {
    int node1;
    int node2;

    public Edge(int node1, int node2) {
        try {
            if (node1 == node2)
                throw new InvalidParameterException();
            this.node1 = node1;
            this.node2 = node2;

        } catch (Exception e) {
            System.out.println("Number are equals");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Edge)) return false;
        Edge edge = (Edge) o;
        return node1 == edge.node1 &&
                node2 == edge.node2;
    }

    @Override
    public int hashCode() {
        return Objects.hash(node1, node2);
    }
}
