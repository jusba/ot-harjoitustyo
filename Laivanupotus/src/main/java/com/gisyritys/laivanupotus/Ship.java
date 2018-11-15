/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gisyritys.laivanupotus;

/**
 *
 * @author Jussi
 */
public class Ship {
    private String tyyppi;
    
    public Ship(){
        this.tyyppi = "Laiva";
    }
    public String getTyyppi(){
        return this.tyyppi;
    }
    @Override
    public String toString(){
        return this.tyyppi;
    }
}
