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
    private int xsize;
    private int ysize;
    
    
    public Grid(int x, int y){
        this.xsize = x;
        this.ysize = y;
        this.grid = new Location[this.xsize][this.ysize];
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
    public int getXSize(){
        return this.xsize;
    }
    public int getYSize(){
        return this.ysize;
    }
    public Location[][] getGrid(){
        return this.grid;
    }
    public Location getLocation(int x, int y){
        return this.grid[x][y];
    }
         
    
    
            
}
