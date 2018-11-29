/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gisyritys.testing;

import com.gisyritys.graphics.Board;
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
        grid = new Grid(10, 10);
        grid2 = new Grid(5, 5);
    }

    @Test
    public void gridSizeRight() {
        int size1 = 10 * 10;
        int gridSize1 = grid.getXSize() * grid.getYSize();
        assertEquals(size1, gridSize1);
        int size2 = 5 * 5;
        int gridSize2 = grid2.getXSize() * grid2.getYSize();
        assertEquals(size2, gridSize2);
        size1 = grid.getGrid().length * grid.getGrid()[1].length;
        assertEquals(size1, gridSize1);
        size2 = grid2.getGrid().length * grid2.getGrid()[1].length;
        assertEquals(size2, gridSize2);

    }

    @Test
    public void addingShipToGridWorks() {
        grid.addShip(2, 3);
        assertEquals(grid.getLocation(2, 3).hasShip(), true);
        grid.addShip(4, 8);
        assertEquals(grid.getLocation(4, 8).hasShip(), true);
        grid.addShip(4, 8);
        assertEquals(grid.getLocation(4, 8).hasShip(), true);

    }

    @Test
    public void removingShipToGridWorks() {
        grid.addShip(6, 8);
        assertEquals(grid.getLocation(6, 8).hasShip(), true);
        grid.removeShip(6, 8);
        assertEquals(grid.getLocation(6, 8).hasShip(), false);
    }

    @Test
    public void gridEmptyBeforeAdding() {
        for (int i = 0; i < grid.getGrid().length; i++) {
            for (int j = 0; j < grid.getGrid()[i].length; j++) {
                assertEquals(grid.getLocation(i, j).hasShip(), false);

            }

        }
    }

    @Test
    public void gridRandomizerAddsShips() {
        grid.randomGrid();
        int amount = 0;
        for (int i = 0; i < grid.getGrid().length; i++) {
            for (int j = 0; j < grid.getGrid()[i].length; j++) {
                if (grid.getLocation(i, j).hasShip()) {
                    amount++;
                }

            }

        }
        grid2 = new Grid(15,15);
        grid2.randomGrid();
        int amount2 = 0;
        for (int i = 0; i < grid2.getGrid().length; i++) {
            for (int j = 0; j < grid2.getGrid()[i].length; j++) {
                if (grid2.getLocation(i, j).hasShip()) {
                    amount2++;
                }

            }

        }
        assertEquals(amount2, 15);
        grid = new Grid(20,20);
        grid.randomGrid();
        int amount3 = 0;
        for (int i = 0; i < grid.getGrid().length; i++) {
            for (int j = 0; j < grid.getGrid()[i].length; j++) {
                if (grid.getLocation(i, j).hasShip()) {
                    amount3++;
                }

            }

        }
        assertEquals(amount3, 15);
        grid = new Grid(20,20);
        grid.randomGrid();
        int amount4 = 0;
        for (int i = 0; i < grid.getGrid().length; i++) {
            for (int j = 0; j < grid.getGrid()[i].length; j++) {
                if (grid.getLocation(i, j).hasShip()) {
                    amount4++;
                }

            }

        }
        assertEquals(amount4, 15);
        
        grid = new Grid(30,30);
        grid.randomGrid();
        int amount5 = 0;
        for (int i = 0; i < grid.getGrid().length; i++) {
            for (int j = 0; j < grid.getGrid()[i].length; j++) {
                if (grid.getLocation(i, j).hasShip()) {
                    amount5++;
                }

            }

        }
        assertEquals(amount5, 15);
        grid = new Grid(50,50);
        grid.randomGrid();
        int amount6 = 0;
        for (int i = 0; i < grid.getGrid().length; i++) {
            for (int j = 0; j < grid.getGrid()[i].length; j++) {
                if (grid.getLocation(i, j).hasShip()) {
                    amount6++;
                }

            }

        }
        assertEquals(amount6, 15);
        grid = new Grid(100,100);
        grid.randomGrid();
        int amount7 = 0;
        for (int i = 0; i < grid.getGrid().length; i++) {
            for (int j = 0; j < grid.getGrid()[i].length; j++) {
                if (grid.getLocation(i, j).hasShip()) {
                    amount7++;
                }

            }

        }
        assertEquals(amount7, 15);
        grid = new Grid(8,8);
        grid.randomGrid();
        int amount8 = 0;
        for (int i = 0; i < grid.getGrid().length; i++) {
            for (int j = 0; j < grid.getGrid()[i].length; j++) {
                if (grid.getLocation(i, j).hasShip()) {
                    amount8++;
                }

            }

        }
        assertEquals(amount8, 15);
    }
    @Test
    public void checkingGridWorks(){
        grid.addShip(5, 5);
        grid.addShip(3,3);
        assertEquals(grid.checkGrid(), true);
        assertEquals(grid2.checkGrid(), false);
        grid.removeShip(5, 5);
        assertEquals(grid.checkGrid(), true);
        grid.removeShip(3, 3);
        assertEquals(grid.checkGrid(), false);
    }
    @Test
    public void checkingGridStatsWorks(){
        grid.addShip(5, 5);
        grid.addShip(4, 4);
        grid.addShip(3, 3);
        grid.getLocation(5, 5).setGuessed();
        grid.getLocation(5, 5).getShip().sinkShip();
        grid.getLocation(8, 8).setGuessed();
        assertEquals((grid.gridCheckerStats() instanceof int[]), true);
        int[] list = grid.gridCheckerStats();
        assertEquals(list[0], 3);
        assertEquals(list[1], 2);
        assertEquals(list[2], 97);
        assertEquals(list[3], 2);
        grid.addShip(2, 2);
        grid.getLocation(7, 8).setGuessed();
        list = grid.gridCheckerStats();
        assertEquals(list[0], 4);
        assertEquals(list[1], 3);
        assertEquals(list[2], 96);
        assertEquals(list[3], 3);
        
    }
       

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
