package org.xsdn.search.algorithm;


import org.xsdn.search.Grid;


public
class NoSearch extends BaseSearchAlgorithm
{
    public
    NoSearch( Grid grid, int startX, int startY, int targetX, int targetY )
    {
        super( grid, startX, startY, targetX, targetY );
    }


    @Override
    public
    void step()
    {

    }


    @Override
    public
    String getName()
    {
        return "No Search Algorithm";
    }
}
