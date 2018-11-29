/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gisyritys.testing;

import com.gisyritys.logic.Location;
import com.gisyritys.logic.Ship;
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
public class LocationTest {

    Location loc;

    @Before
    public void setUp() {
        loc = new Location();
    }

    @Test
    public void addingShipsWorks() {
        assertEquals(loc.hasShip(), false);
        assertEquals(loc.addShip(), true);
        assertEquals(loc.hasShip(), true);
        assertEquals(loc.addShip(), false);

    }

    @Test
    public void removingShipsWorks() {
        assertEquals(loc.hasShip(), false);
        assertEquals(loc.removeShip(), false);
        assertEquals(loc.addShip(), true);
        assertEquals(loc.hasShip(), true);
        assertEquals(loc.removeShip(), true);
        assertEquals(loc.hasShip(), false);

    }
    @Test
    public void settersAndGettersWorks() {
        loc.setGuessed();
        assertEquals(loc.getGuessed(), true);
        loc.setStatus();
        assertEquals(loc.getStatus(), true);
        loc.addShip();
        assertEquals((loc.getShip() instanceof Ship), true);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
