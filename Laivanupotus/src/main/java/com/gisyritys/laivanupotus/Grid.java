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
public class Grid {
    private Location grid[][];
    
    
    public Grid(){
        this.grid = new Location[10][10];
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                grid[i][j] = new Location();  
            }
        
        }
    }
    public void addShip(int x, int y){
        if(!grid[x][y].hasShip()){
            grid[x][y].addShip();
        }
        
    }
    public void removeShip(int x, int y){
        if(grid[x][y].hasShip()){
            grid[x][y].removeShip();
            
        }
    }
    public Location[][] getGrid(){
        return this.grid;
    }
    public Location getLocation(int x, int y){
        return this.grid[x][y];
    }
         
    
    
            
}
