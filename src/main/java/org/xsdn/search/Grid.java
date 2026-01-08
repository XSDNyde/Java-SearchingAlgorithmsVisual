package org.xsdn.search;


import processing.core.PGraphics;

import static processing.core.PConstants.CORNER;


public
class Grid
{
    private static final float CELL_WIDTH = 50f;
    private static final float CELL_HEIGHT = 50f;
    private static final float CELL_CORNER_RADIUS = 10f;


    final private Cell[][] cells2D;
    private Cell start;
    private Cell target;


    public
    Grid( int dimensionX, int dimensionY )
    {
        this.cells2D = new Cell[ (int) Math.ceil( dimensionY / CELL_HEIGHT ) ][ (int) Math.ceil( dimensionX / CELL_WIDTH )  ];
        this.initializeCells();
    }


    private
    void initializeCells()
    {
        for( int y = 0; y < cells2D.length; y++ )
            for( int x = 0; x < cells2D[y].length; x++ )
                cells2D[ y ][ x ] = new Cell( x, y, Cell.Status.WALKABLE );
    }


    private void validateBounds( int indexX, int indexY )
    {
        if ( indexY < 0 || indexY >= cells2D.length || indexX < 0 || indexX >= cells2D[0].length )
            throw new IndexOutOfBoundsException( "Index out of bounds: " + indexX + ", " + indexY );
    }


    public void setStart( int indexX, int indexY )
    {
        validateBounds( indexX, indexY );
        cells2D[indexY][indexX].setStatus( Cell.Status.START );
        start = cells2D[indexY][indexX];
    }


    public void setTarget( int indexX, int indexY )
    {
        validateBounds( indexX, indexY );
        cells2D[indexY][indexX].setStatus( Cell.Status.TARGET );
    }


    public void setWalkable( int indexX, int indexY )
    {
        validateBounds( indexX, indexY );
        cells2D[indexY][indexX].setStatus( Cell.Status.WALKABLE );
    }


    public void setBlocked( int indexX, int indexY )
    {
        validateBounds( indexX, indexY );
        cells2D[indexY][indexX].setStatus( Cell.Status.BLOCKED );
    }


    public void render ( PGraphics pG )
    {
        pG.push();
        pG.rectMode( CORNER );
        for( Cell[] cells : cells2D )
        {
            pG.pushMatrix();
            for( Cell cell : cells )
            {
                pG.fill( cell.getStatus().getColor() );
                pG.noStroke();
                pG.rect( 0, 0, CELL_WIDTH, CELL_HEIGHT, CELL_CORNER_RADIUS );
//                cells2D[ y ][ x ].render();
                pG.translate( CELL_WIDTH, 0f );
            }
            pG.popMatrix();
            pG.translate( 0f, CELL_HEIGHT );
        }
        pG.pop();
    }


    public
    int getCellsX() { return cells2D[0].length; }


    public
    int getCellsY() { return cells2D.length; }


    public
    Cell getStart() { return start; }


    public
    Cell getTarget() { return target; }


    public static
    class Cell
    {
        final private int indexX, indexY;

        private Status status;


        Cell( int indexX, int indexY, Status status )
        {
            this.indexX = indexX;
            this.indexY = indexY;
            this.status = status;
        }


        Status getStatus()
        {
            return status;
        }


        public
        void setStatus( Status status )
        {
            this.status = status;
        }


        enum Status
        {
            NONE( 0x00000000 ),
            WALKABLE( 0xFFEEEEEE ),
            BLOCKED( 0xFFE07A5F ),
            START( 0xFF81B29A ),
            TARGET( 0xFFE07A5F );

            final private int color;


            Status( int color )
            {
                this.color = color;
            }


            public
            int getColor()
            {
                return color;
            }
        }
    }
}
