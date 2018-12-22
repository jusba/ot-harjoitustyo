/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gisyritys.logic;

/**
 *
 * Kuvaa ruudussa olevaa laivaa
 */
public class Ship {

    private String tyyppi;
    private Boolean status; //sink or not sink

    public Ship() {
        this.tyyppi = "Laiva";
        this.status = true;
    }

    public String getTyyppi() {
        return this.tyyppi;
    }

    public void sinkShip() {
        this.status = false;
    }

    public boolean getStatus() {
        return this.status;
    }

    @Override
    public String toString() {
        return this.tyyppi;
    }
}
