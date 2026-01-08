package org.xsdn.search;


import processing.core.PGraphics;

import static processing.core.PConstants.CORNER;


public
class Grid
{
    final private int dimensionX, dimensionY;
    final private float cellWidth = 50f;
    final private float cellHeight = 50f;
    final private float cellCornerRadius = 10f;

    final private Cell[][] cells2D;


    public
    Grid( int dimensionX, int dimensionY )
    {
        this.dimensionX = dimensionX;
        this.dimensionY = dimensionY;

        this.cells2D = new Cell[ (int) Math.ceil( dimensionY / cellHeight ) ][ (int) Math.ceil( dimensionX / cellWidth )  ];
        this.initializeCells();
    }


    private
    void initializeCells()
    {
        for( int y = 0; y < cells2D.length; y++ )
            for( int x = 0; x < cells2D[y].length; x++ )
                cells2D[ y ][ x ] = new Cell( x, y );
    }


    public void setStart( int indexX, int indexY )
    {
        assert indexY >= 0 && indexY < cells2D.length && indexX >= 0 && indexX < cells2D[0].length : "Index out of bounds: " + indexX + ", " + indexY;

        cells2D[indexY][indexX].setStatus( Cell.Status.START );
    }


    public void setTarget( int indexX, int indexY )
    {
        assert indexY >= 0 && indexY < cells2D.length && indexX >= 0 && indexX < cells2D[0].length : "Index out of bounds: " + indexX + ", " + indexY;

        cells2D[indexY][indexX].setStatus( Cell.Status.TARGET );
    }


    public void render ( PGraphics pG )
    {
        pG.push();
        pG.rectMode( CORNER );
        for( int y = 0; y < cells2D.length; y++ )
        {
            pG.pushMatrix();
            for( int x = 0; x < cells2D[ y ].length; x++ )
            {
                int color;
                switch (  cells2D[ y ][ x ].getStatus() )
                {
                    case OPEN -> color = pG.color( 244f, 241f, 222f );
                    case VISITED -> color = pG.color( 61, 64, 91 );
                    case CLOSED, TARGET -> color = pG.color( 224, 122, 95 );
                    case DISMISSED -> color = pG.color( 242, 204, 143 );
                    case START -> color = pG.color( 129, 178, 154 );
                    default -> color = pG.color( 255f, 0f, 255f );
                }
                pG.fill( color );
                pG.noStroke();
                pG.rect( 0, 0, cellWidth, cellHeight, cellCornerRadius );
//                cells2D[ y ][ x ].render();
                pG.translate( cellWidth, 0f );
            }
            pG.popMatrix();
            pG.translate( 0f, cellHeight );
        }
        pG.pop();
    }


    private static class Cell
    {
        final private int indexX, indexY;

        private Status status = Status.OPEN;


        private
        Cell( int indexX, int indexY )
        {
            this.indexX = indexX;
            this.indexY = indexY;
        }


        private
        Status getStatus()
        {
            return status;
        }


        private
        void setStatus( Status status )
        {
            this.status = status;
        }


        private enum Status
        {
            OPEN,
            VISITED,
            CLOSED,
            DISMISSED,
            START,
            TARGET
        }
    }
}
