/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gisyritys.laivanupotus;

import java.util.Random;

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
    public Location[][] randomGrid(){
        int pieces = 3;
        
        Random random = new Random();
        int startX = random.nextInt(this.xsize - 1);
        int startY = random.nextInt(this.ysize - 1);
        int dir = random.nextInt(3);
        Boolean test = false;
        while(true){
            for(int i = 0; i<pieces; i++){
                
                if(dir == 0){
                    //north
                    if(startY - pieces < 0){
                        dir = random.nextInt(3);
                        startX = random.nextInt(this.xsize - 1);
                        startY = random.nextInt(this.ysize - 1);
                        i --;
                        continue;
                    }
                    for(int x = 0; x<pieces; x++){
                        if(this.grid[startX][startY].hasShip()){
                            dir = random.nextInt(3);
                            startX = random.nextInt(this.xsize - 1);
                            startY = random.nextInt(this.ysize - 1);
                            test = true;
                        }
                    }
                    if(test){
                        i --;
                        test =  false;
                        continue;
                    }
                    // Adding ships
                    this.grid[startX][startY].addShip();
                    startY --;
                    
                    
                }
                if(dir == 1){
                    //east
                    if(startX + pieces > this.xsize-1){
                        startX = random.nextInt(this.xsize - 1);
                        startY = random.nextInt(this.ysize - 1);
                        dir = random.nextInt(3);
                        i --;
                        continue;
                    }
                    for(int x = 0; x<pieces; x++){
                        if(this.grid[startX][startY].hasShip()){
                            dir = random.nextInt(3);
                            startX = random.nextInt(this.xsize - 1);
                            startY = random.nextInt(this.ysize - 1);
                            test = true;
                        }
                    }
                    if(test){
                        i --;
                        test =  false;
                        continue;
                    }
                    // Adding ships
                    this.grid[startX][startY].addShip();
                    startX ++;
                    
                    
                }
                if(dir == 2){
                    //south
                    if(startY + pieces > this.ysize-1){
                        dir = random.nextInt(3);
                        startX = random.nextInt(this.xsize - 1);
                        startY = random.nextInt(this.ysize - 1);
                        i --;
                        continue;
                    }
                    for(int x = 0; x<pieces; x++){
                        if(this.grid[startX][startY].hasShip()){
                            dir = random.nextInt(3);
                            startX = random.nextInt(this.xsize - 1);
                            startY = random.nextInt(this.ysize - 1);
                            test = true;
                        }
                    }
                    if(test){
                        i --;
                        test =  false;
                        continue;
                    }
                    // Adding ships
                    this.grid[startX][startY].addShip();
                    startY ++;
                }
                if(dir == 3){
                    //west
                    if(startX - pieces < 0){
                        dir = random.nextInt(3);
                        startX = random.nextInt(this.xsize - 1);
                        startY = random.nextInt(this.ysize - 1);
                        i --;
                        continue;
                    }
                    for(int x = 0; x<pieces; x++){
                        if(this.grid[startX][startY].hasShip()){
                            dir = random.nextInt(3);
                            startX = random.nextInt(this.xsize - 1);
                            startY = random.nextInt(this.ysize - 1);
                            test = true;
                        }
                    }
                    if(test){
                        i --;
                        test =  false;
                        continue;
                    }
                    // Adding ships
                    this.grid[startX][startY].addShip();
                    startX --;
                }

            }
        
        
        
    
            
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
