package org.xsdn.search.algorithm;


import org.xsdn.search.Grid;


public abstract class BaseSearchAlgorithm implements SearchAlgorithm
{
    protected Grid    grid;
    protected int     startX;
    protected int     startY;
    protected int     targetX;
    protected int     targetY;
    protected int     currentX;
    protected int     currentY;
    protected boolean running = false;


    public BaseSearchAlgorithm( Grid grid, int startX, int startY, int targetX, int targetY )
    {
        this.grid = grid;
        this.grid.setStart( startX, startY );
        this.grid.setTarget( targetX, targetY );
        this.startX = startX;
        this.startY = startY;
        this.targetX = targetX;
        this.targetY = targetY;
        this.currentX = startX;
        this.currentY = startY;
    }


    @Override
    public
    void run()
    {
        running = true;
    }

    @Override
    public
    void pause()
    {
        running = false;
    }


    @Override
    public
    boolean isRunning()
    {
        return running;
    }
}
