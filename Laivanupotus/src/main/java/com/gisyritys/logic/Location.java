/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gisyritys.logic;

/**
 *
 * @author Jussi
 */
public class Location {

    private boolean status;
    private Ship ship;

    public Location() {
        this.status = false;
        this.ship = null;
    }

    public boolean addShip() {
        if (this.ship == null) {
            this.ship = new Ship();
            this.status = true;
            return true;

        }
        return false;
    }

    public boolean removeShip() {
        if (this.status) {
            this.ship = null;
            this.status = false;
            return true;

        }
        return false;

    }

    public Ship getShip() {
        return this.ship;
    }

    public boolean hasShip() {
        return this.status;
    }

    public void setStatus() {
        this.status = true;
    }
}
