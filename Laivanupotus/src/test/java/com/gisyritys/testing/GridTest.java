/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gisyritys.testing;

import com.gisyritys.logic.Grid;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jussi
 */
public class GridTest {
    
    Grid grid;
    Grid grid2;
    
    @Before
    public void setUp() {
        grid = new Grid(10,10);
        grid2 = new Grid(5,5);
    }
    @Test
    public void gridSizeRight(){
        int size1 = 10*10;
        int gridSize1 = grid.getXSize() * grid.getYSize();
        assertEquals(size1, gridSize1);
        int size2 = 5*5;
        int gridSize2 = grid2.getXSize() * grid2.getYSize();
        assertEquals(size2, gridSize2);
        size1 = grid.getGrid().length * grid.getGrid()[1].length;
        assertEquals(size1, gridSize1);
        size2 = grid2.getGrid().length * grid2.getGrid()[1].length;
        assertEquals(size2, gridSize2);
        
    }
    @Test
    public void addingShipToGridWorks(){
        grid.addShip(2, 3);
        assertEquals(grid.getLocation(2, 3).hasShip(), true);
        grid.addShip(4, 8);
        assertEquals(grid.getLocation(4, 8).hasShip(),true);
        grid.addShip(4, 8);
        assertEquals(grid.getLocation(4, 8).hasShip(),true);
        
    }
    @Test
    public void removingShipToGridWorks(){
        grid.addShip(6, 8);
        assertEquals(grid.getLocation(6, 8).hasShip(), true);
        grid.removeShip(6, 8);
        assertEquals(grid.getLocation(6, 8).hasShip(), false);
    }
    @Test
    public void gridEmptyBeforeAdding(){
        for(int i=0; i<grid.getGrid().length; i++) {
            for(int j=0; j<grid.getGrid()[i].length; j++) {
                assertEquals(grid.getLocation(i, j).hasShip(),false);
                 
            }
        
        }
    }
    @Test
    public void gridRandomizerAddsShips(){
        grid.randomGrid();
        int amount = 0;
        for(int i=0; i<grid.getGrid().length; i++) {
            for(int j=0; j<grid.getGrid()[i].length; j++) {
               if(grid.getLocation(i, j).hasShip()){
                   amount ++;
               }
                 
            }
        
        }
        assertEquals(amount, 15);
    }
    
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
