package org.xsdn;


import org.xsdn.search.Grid;

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


    Grid grid;


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
        grid.setStart( 0, 0 );
        grid.setTarget( 9, 9 );
    }


    @Override
    public
    void draw()
    {
        background( color( 31, 63, 63) );

        grid.render( this.g );
    }
}