package org.xsdn.search.algorithm;


import org.xsdn.search.Grid;


public interface SearchAlgorithm
{
    void step();

    void reset();

    void run();
    void pause();
    boolean isRunning();

    String getName();

    int getStep();


    class Node
    {
        Grid.Cell cell;
        Node      parent;
        float     cost;
        Status    status;


        Node( Grid.Cell cell, Status status, Node parent, float cost )
        {
            this.cell = cell;
            this.status = status;
            this.parent = parent;
            this.cost = cost;
        }


        enum Status
        {
            NONE,
            OPEN,
            CLOSED,
            VISITED,
            DISMISSED,
            UNKNOWN;
        }
    }
}
