package org.xsdn.search.algorithm;

public interface SearchAlgorithm
{
    void step();

    void run();
    void pause();
    boolean isRunning();
}
