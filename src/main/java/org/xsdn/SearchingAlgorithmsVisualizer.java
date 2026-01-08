package org.xsdn;

import org.xsdn.search.Grid;
import org.xsdn.search.algorithm.SearchAlgorithm;
import org.xsdn.search.algorithm.NoSearch;

import processing.core.PApplet;


public
class SearchingAlgorithmsVisualizer extends PApplet
{
    public static
    void main( String[] args )
    {
        System.out.println( "Running: Search Algorithm Visualizer!" );

        PApplet.main( "org.xsdn.SearchingAlgorithmsVisualizer" );
    }


    Grid            grid;
    SearchAlgorithm algorithm;

    @Override
    public
    void settings()
    {
        size( 800, 900 );
        noSmooth();
    }


    @Override
    public
    void setup()
    {
        surface.setTitle( "Search Algorithm Visualizer [ No Model Chosen ]" );
        surface.setLocation( 1100, 50 );
        surface.setResizable( false );
        surface.setAlwaysOnTop( true );
        surface.setVisible( true );

        grid = new Grid( width, height );

        int startX = 0;
        int startY = 0;
        int targetX = grid.getCellsX() - 1;
        int targetY = grid.getCellsY() - 1;

        algorithm = new NoSearch( grid, startX, startY, targetX, targetY );
//        algorithm = new AStar( grid, startX, startY, targetX, targetY );
//        algorithm = new Dijkstra( grid, startX, startY, targetX, targetY );
//        algorithm = new BreadthFirstSearch( grid, startX, startY, targetX, targetY );
    }


    @Override
    public
    void draw()
    {
        background( color( 31, 63, 63) );

        if ( algorithm.isRunning() )
        {
            // Einen Schritt ausführen oder den kompletten Algorithmus starten
        }

        grid.render( this.g );
    }
}