/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gisyritys.logic;

/**
 *
 * Kuvaa yhtä ruutua pelilaudalla
 */
public class Location {

    private boolean status;
    private Ship ship;
    private boolean guessed;

    public Location() {
        this.status = false;
        this.ship = null;
        this.guessed = false;
    }

    /**
     * Lisää tiettyyn ruudukon kohtaan laivan
     *
     * @param
     *
     * @return true jos onnistuu, false jos ei
     */

    public boolean addShip() {
        if (this.ship == null) {
            this.ship = new Ship();
            this.status = true;
            return true;

        }
        return false;
    }

    /**
     * Poistaa tietystä ruudukon kohdasta laivan
     *
     * @param
     *
     * @return true jos onnistuu, false jos ei
     */
    public boolean removeShip() {
        if (this.status) {
            this.ship = null;
            this.status = false;
            return true;

        }
        return false;

    }

    public void setGuessed() {
        this.guessed = true;
    }

    public boolean getGuessed() {
        return this.guessed;
    }

    public Ship getShip() {
        return this.ship;
    }

    public boolean getStatus() {
        return this.status;
    }

    public boolean hasShip() {
        return this.status;
    }

    public void setStatus() {
        this.status = true;
    }
}
