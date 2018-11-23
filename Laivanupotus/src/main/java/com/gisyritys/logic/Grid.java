/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gisyritys.logic;

import java.util.Random;

/**
 *
 * @author Jussi
 */
public class Grid {
    private Location grid[][];
    private int xsize;
    private int ysize;
    
    
    public Grid(int x, int y) {
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
    public void randomGrid(){
        int pieces = 1;
        
        Random random = new Random();
        int startX = random.nextInt(this.xsize - 1);
        int startY = random.nextInt(this.ysize - 1);
        int dir = random.nextInt(3);
        
        Boolean test = false;
        while(true){
            
            boolean passed = true;
            for(int i = 0; i<pieces; i++){
                int testiX = startX;
                int testiY = startY;
                if(dir == 0){
                    //north
                    if(startY - pieces < 0 && passed){
                        System.out.println("DirY: "+ dir);
                        dir = random.nextInt(3);
                        startX = random.nextInt(this.xsize - 1);
                        startY = random.nextInt(this.ysize - 1);
                        i --;
                        continue;
                    }
                    for(int x = 0; x<pieces; x++){
                        
                                
                        if(passed){
                            if(this.grid[testiX][testiY].hasShip()){
                                System.out.println("Dir: "+ dir);
                                dir = random.nextInt(3);
                                startX = random.nextInt(this.xsize - 1);
                                startY = random.nextInt(this.ysize - 1);
                                test = true;
                            }
                            if(testiX -1 >= 0 ){
                                if(this.grid[testiX -1][testiY].hasShip()){
                                    System.out.println("DirN: "+ dir);
                                    dir = random.nextInt(3);
                                    startX = random.nextInt(this.xsize - 1);
                                    startY = random.nextInt(this.ysize - 1);
                                    test = true;
                                }
                            }
                            if(testiX +1 <= this.xsize -1) {
                                if(this.grid[testiX +1][testiY].hasShip()){
                                    System.out.println("DirN: "+ dir);
                                    dir = random.nextInt(3);
                                    startX = random.nextInt(this.xsize - 1);
                                    startY = random.nextInt(this.ysize - 1);
                                    test = true;
                                }
                            }
                            if(testiY -1 >= 0){
                                if(this.grid[testiX][testiY -1].hasShip()){
                                    System.out.println("DirN: "+ dir);
                                    dir = random.nextInt(3);
                                    startX = random.nextInt(this.xsize - 1);
                                    startY = random.nextInt(this.ysize - 1);
                                    test = true;
                                }
                            }
                            if(testiY +1 <= this.ysize -1){
                                if(this.grid[testiX][testiY +1].hasShip()){
                                    System.out.println("DirN: "+ dir);
                                    dir = random.nextInt(3);
                                    startX = random.nextInt(this.xsize - 1);
                                    startY = random.nextInt(this.ysize - 1);
                                    test = true;
                                }
                            }
                            
                            
                        }  
                        testiY--;
                    }
                    if(test){
                        i --;
                        test =  false;
                        continue;
                    }
                    // Adding ships
                    //testi
                    System.out.println(startX +":"+startY);
                    //testi
                    passed = false;
                    this.grid[startX][startY].addShip();
                    startY --;
                    
                    
                }
                if(dir == 1){
                    //east
                    if(startX + pieces > this.xsize-1 && passed){
                        System.out.println("DirY: "+ dir);
                        startX = random.nextInt(this.xsize - 1);
                        startY = random.nextInt(this.ysize - 1);
                        dir = random.nextInt(3);
                        i --;
                        continue;
                    }
                    for(int x = 0; x<pieces; x++){
                        
                        if(passed){
                            if(this.grid[testiX][testiY].hasShip()){
                                System.out.println("Dir: "+ dir);
                                dir = random.nextInt(3);
                                startX = random.nextInt(this.xsize - 1);
                                startY = random.nextInt(this.ysize - 1);
                                test = true;
                            }
                            if(testiX -1 >= 0 ){
                                if(this.grid[testiX -1][testiY].hasShip()){
                                    System.out.println("DirE: "+ dir);
                                    dir = random.nextInt(3);
                                    startX = random.nextInt(this.xsize - 1);
                                    startY = random.nextInt(this.ysize - 1);
                                    test = true;
                                }
                            }
                            if(testiX +1 <= this.xsize -1) {
                                if(this.grid[testiX +1][testiY].hasShip()){
                                    System.out.println("DirE: "+ dir);
                                    dir = random.nextInt(3);
                                    startX = random.nextInt(this.xsize - 1);
                                    startY = random.nextInt(this.ysize - 1);
                                    test = true;
                                }
                            }
                            if(testiY -1 >= 0){
                                if(this.grid[testiX][testiY -1].hasShip()){
                                    System.out.println("DirE: "+ dir);
                                    dir = random.nextInt(3);
                                    startX = random.nextInt(this.xsize - 1);
                                    startY = random.nextInt(this.ysize - 1);
                                    test = true;
                                }
                            }
                            if(testiY +1 <= this.ysize -1){
                                if(this.grid[testiX][testiY +1].hasShip()){
                                    System.out.println("DirE: "+ dir);
                                    dir = random.nextInt(3);
                                    startX = random.nextInt(this.xsize - 1);
                                    startY = random.nextInt(this.ysize - 1);
                                    test = true;
                                }
                            }
                        }        
                        
                        testiX ++;
                    }
                    if(test){
                        i --;
                        test =  false;
                        continue;
                    }
                    // Adding ships
                    //testi
                    System.out.println(startX +":"+startY);
                    //testi
                    passed = false;
                    this.grid[startX][startY].addShip();
                    startX ++;
                    
                    
                }
                if(dir == 2){
                    //south
                    if(startY + pieces > this.ysize-1 && passed){
                        System.out.println("DirY: "+ dir);
                        dir = random.nextInt(3);
                        startX = random.nextInt(this.xsize - 1);
                        startY = random.nextInt(this.ysize - 1);
                        i --;
                        continue;
                    }
                    for(int x = 0; x<pieces; x++){
                        
                                
                        if(passed){
                            if(this.grid[testiX][testiY].hasShip()){
                                System.out.println("Dir: "+ dir);
                                dir = random.nextInt(3);
                                startX = random.nextInt(this.xsize - 1);
                                startY = random.nextInt(this.ysize - 1);
                                test = true;
                            }
                            if(testiX -1 >= 0 ){
                                if(this.grid[testiX -1][testiY].hasShip()){
                                    System.out.println("DirS: "+ dir);
                                    dir = random.nextInt(3);
                                    startX = random.nextInt(this.xsize - 1);
                                    startY = random.nextInt(this.ysize - 1);
                                    test = true;
                                }
                            }
                            if(testiX +1 <= this.xsize -1) {
                                if(this.grid[testiX +1][testiY].hasShip()){
                                    System.out.println("DirS: "+ dir);
                                    dir = random.nextInt(3);
                                    startX = random.nextInt(this.xsize - 1);
                                    startY = random.nextInt(this.ysize - 1);
                                    test = true;
                                }
                            }
                            if(testiY -1 >= 0){
                                if(this.grid[testiX ][testiY-1].hasShip()){
                                    System.out.println("DirS: "+ dir);
                                    dir = random.nextInt(3);
                                    startX = random.nextInt(this.xsize - 1);
                                    startY = random.nextInt(this.ysize - 1);
                                    test = true;
                                }
                            }
                            if(testiY +1 <= this.ysize -1){
                                if(this.grid[testiX][testiY+1].hasShip()){
                                    System.out.println("DirS: "+ dir);
                                    dir = random.nextInt(3);
                                    startX = random.nextInt(this.xsize - 1);
                                    startY = random.nextInt(this.ysize - 1);
                                    test = true;
                                }
                            }
                        }  
                        
                        testiY ++;
                    }
                    if(test){
                        i --;
                        test =  false;
                        continue;
                    }
                    // Adding ships
                    //testi
                    System.out.println(startX +":"+startY);
                    //testi
                    passed = false;
                    this.grid[startX][startY].addShip();
                    startY ++;
                }
                if(dir == 3){
                    //west
                    if(startX - pieces < 0 && passed){
                        System.out.println("DirY: "+ dir);
                        dir = random.nextInt(3);
                        startX = random.nextInt(this.xsize - 1);
                        startY = random.nextInt(this.ysize - 1);
                        i --;
                        continue;
                    }
                    for(int x = 0; x<pieces; x++){
                        
                                
                        if(passed){
                            if(this.grid[testiX][testiY].hasShip()){
                                System.out.println("Dir: "+ dir);
                                dir = random.nextInt(3);
                                startX = random.nextInt(this.xsize - 1);
                                startY = random.nextInt(this.ysize - 1);
                                test = true;
                            }
                            if(testiX -1 >= 0 ){
                                if(this.grid[testiX -1][testiY].hasShip()){
                                    System.out.println("DirW: "+ dir);
                                    dir = random.nextInt(3);
                                    startX = random.nextInt(this.xsize - 1);
                                    startY = random.nextInt(this.ysize - 1);
                                    test = true;
                                }
                            }
                            if(testiX +1 <= this.xsize -1) {
                                if(this.grid[testiX +1][testiY].hasShip()){
                                    System.out.println("DirW: "+ dir);
                                    dir = random.nextInt(3);
                                    startX = random.nextInt(this.xsize - 1);
                                    startY = random.nextInt(this.ysize - 1);
                                    test = true;
                                }
                            }
                            if(testiY -1 >= 0){
                                if(this.grid[testiX ][testiY-1].hasShip()){
                                    System.out.println("DirW: "+ dir);
                                    dir = random.nextInt(3);
                                    startX = random.nextInt(this.xsize - 1);
                                    startY = random.nextInt(this.ysize - 1);
                                    test = true;
                                }
                            }
                            if(testiY +1 <= this.ysize -1){
                                if(this.grid[testiX ][testiY+1].hasShip()){
                                    System.out.println("DirW: "+ dir);
                                    dir = random.nextInt(3);
                                    startX = random.nextInt(this.xsize - 1);
                                    startY = random.nextInt(this.ysize - 1);
                                    test = true;
                                }
                            }
                        }  
                        testiX --;
                    }
                    if(test){
                        
                        i --;
                        test =  false;
                        continue;
                    }
                    // Adding ships
                    //testi
                    System.out.println(startX +":"+startY);
                    //testi
                    passed = false;
                    this.grid[startX][startY].addShip();
                    startX --;
                }

            }
        
            //testi
            System.out.println("Dir: "+ dir);
            System.out.println("-----------------");
            //testi
            pieces ++;
            if(pieces > 5){
                return;
            }
            startX = random.nextInt(this.xsize - 1);
            startY = random.nextInt(this.ysize - 1);
            dir = random.nextInt(3);
            
        }
            
    }
    // Not used atm.
    public boolean checkSides(int x, int y){
        if(this.grid[x -1][y].hasShip()||this.grid[x +1][y].hasShip()||this.grid[x][y-1].hasShip()||this.grid[x][y+1].hasShip()){ 
            return true;
        }   
        return false;
    }
    //Not used atm.
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
