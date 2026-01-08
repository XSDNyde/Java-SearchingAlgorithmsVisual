package org.xsdn.search.algorithm;

import org.xsdn.search.Grid;

import java.util.*;
import java.util.stream.Collectors;


public
class Dijkstra extends BaseSearchAlgorithm
{
    final List<Node> frontier = new LinkedList<>();
    final Set<Node> closedList = new HashSet<>();
    Grid.Cell target;
    int currentCost;


    public
    Dijkstra( Grid grid, int startX, int startY, int targetX, int targetY )
    {
        super( grid, startX, startY, targetX, targetY );
    }


    @Override
    public
    void step()
    {
        if( stepCount == 0 )
        {
            Node start = new Node( grid.getStart(), Node.Status.OPEN, null, 0 );
            frontier.add( start );
            target = grid.getTarget();
            currentCost = 0;
        }

        // Find the lowest cost node in frontier
        // sort frontier by cost using TimSort
        frontier.sort( (a, b) -> Float.compare( a.cost, b.cost ) );
        Node currentNode = frontier.getFirst();
        final List<Grid.Cell> ns = grid.getNeighbors( currentNode.cell );
        for( Grid.Cell n : ns )
        {
            ;
        }

        stepCount++;
    }


    @Override
    public
    String getName()
    {
        return "Dijkstra's Algorithm";
    }
}
