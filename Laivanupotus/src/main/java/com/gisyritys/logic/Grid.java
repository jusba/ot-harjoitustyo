/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gisyritys.logic;

import java.util.Random;

/**
 *
 * Luo pelilautaa kuvaavan gridin ja hoitaa siihen liittyviä toimintoja
 */
public class Grid {

    private Location grid[][];
    private int xsize;
    private int ysize;

    public Grid(int x, int y) {
        this.xsize = x;
        this.ysize = y;
        this.grid = new Location[this.xsize][this.ysize];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = new Location();
            }

        }
    }
    
    /**
    * Lisää laivan haluttuun kohtaan 
    *
    * @param int x, int y eli halutun ruudun sijainti
    * 
    * @return
    */

    public void addShip(int x, int y) {
        if (!grid[x][y].hasShip()) {
            grid[x][y].addShip();
        }

    }
    /**
    * Poistaa laivan halutusta kohdasta
    *
    * @param   int x, int y, eli halutun ruudun sijainti.
    * 
    * @return
    */

    public void removeShip(int x, int y) {
        if (grid[x][y].hasShip()) {
            grid[x][y].removeShip();

        }
    }
    
    /**
    * Luo tiekoneelle uuden satunnaisen gridin.
    * Gridiin asetettavat laivat voivat koskea vain kulmista, eivätkä voi olla vierekkäin
    *
    * @param   
    * 
    * @return
    */

    public void randomGrid() {
        int pieces = 1;

        Random random = new Random();
        int startX = random.nextInt(this.xsize);
        int startY = random.nextInt(this.ysize);
        int dir = random.nextInt(4);

        Boolean test = false;
        while (true) {

            boolean passed = true;
            for (int i = 0; i < pieces; i++) {
                int testiX = startX;
                int testiY = startY;
                if (dir == 0) {
                    //north
                    if (startY - pieces < 0 && passed) {
                        System.out.println("DirY: " + dir);
                        dir = random.nextInt(4);
                        startX = random.nextInt(this.xsize);
                        startY = random.nextInt(this.ysize);
                        i--;
                        continue;
                    }
                    for (int x = 0; x < pieces; x++) {

                        if (this.grid[testiX][testiY].hasShip() && passed) {
                            System.out.println("Dir: " + dir);
                            dir = random.nextInt(4);
                            startX = random.nextInt(this.xsize);
                            startY = random.nextInt(this.ysize);
                            test = true;
                        }
                        if (testiX - 1 >= 0 && passed) {
                            if (this.grid[testiX - 1][testiY].hasShip()) {
                                System.out.println("DirN: " + dir);
                                dir = random.nextInt(4);
                                startX = random.nextInt(this.xsize);
                                startY = random.nextInt(this.ysize);
                                test = true;
                            }
                        }
                        if (testiX + 1 <= this.xsize - 1 && passed) {
                            if (this.grid[testiX + 1][testiY].hasShip()) {
                                System.out.println("DirN: " + dir);
                                dir = random.nextInt(4);
                                startX = random.nextInt(this.xsize);
                                startY = random.nextInt(this.ysize);
                                test = true;
                            }
                        }
                        if (testiY - 1 >= 0 && passed) {
                            if (this.grid[testiX][testiY - 1].hasShip()) {
                                System.out.println("DirN: " + dir);
                                dir = random.nextInt(4);
                                startX = random.nextInt(this.xsize);
                                startY = random.nextInt(this.ysize);
                                test = true;
                            }
                        }
                        if (testiY + 1 <= this.ysize - 1 && passed) {
                            if (this.grid[testiX][testiY + 1].hasShip()) {
                                System.out.println("DirN: " + dir);
                                dir = random.nextInt(4);
                                startX = random.nextInt(this.xsize);
                                startY = random.nextInt(this.ysize);
                                test = true;
                            }
                        }

                        if (passed) {
                            testiY--;
                        }

                    }
                    if (test) {
                        i--;
                        test = false;
                        continue;
                    }
                    // Adding ships
                    //testi
                    System.out.println(startX + ":" + startY);
                    //testi
                    passed = false;
                    this.grid[startX][startY].addShip();
                    startY--;

                }
                if (dir == 1) {
                    //east
                    if (startX + pieces > this.xsize - 1 && passed) {
                        System.out.println("DirY: " + dir);
                        startX = random.nextInt(this.xsize);
                        startY = random.nextInt(this.ysize);
                        dir = random.nextInt(4);
                        i--;
                        continue;
                    }
                    for (int x = 0; x < pieces; x++) {

                        if (this.grid[testiX][testiY].hasShip() && passed) {
                            System.out.println("Dir: " + dir);
                            dir = random.nextInt(4);
                            startX = random.nextInt(this.xsize);
                            startY = random.nextInt(this.ysize);
                            test = true;
                        }
                        if (testiX - 1 >= 0) {
                            if (this.grid[testiX - 1][testiY].hasShip() && passed) {
                                System.out.println("DirE: " + dir);
                                dir = random.nextInt(4);
                                startX = random.nextInt(this.xsize);
                                startY = random.nextInt(this.ysize);
                                test = true;
                            }
                        }
                        if (testiX + 1 <= this.xsize - 1) {
                            if (this.grid[testiX + 1][testiY].hasShip() && passed) {
                                System.out.println("DirE: " + dir);
                                dir = random.nextInt(4);
                                startX = random.nextInt(this.xsize);
                                startY = random.nextInt(this.ysize);
                                test = true;
                            }
                        }
                        if (testiY - 1 >= 0) {
                            if (this.grid[testiX][testiY - 1].hasShip() && passed) {
                                System.out.println("DirE: " + dir);
                                dir = random.nextInt(4);
                                startX = random.nextInt(this.xsize);
                                startY = random.nextInt(this.ysize);
                                test = true;
                            }
                        }
                        if (testiY + 1 <= this.ysize - 1) {
                            if (this.grid[testiX][testiY + 1].hasShip() && passed) {
                                System.out.println("DirE: " + dir);
                                dir = random.nextInt(4);
                                startX = random.nextInt(this.xsize);
                                startY = random.nextInt(this.ysize);
                                test = true;
                            }
                        }

                        if (passed) {
                            testiX++;
                        }

                    }
                    if (test) {
                        i--;
                        test = false;
                        continue;
                    }
                    // Adding ships
                    //testi
                    System.out.println(startX + ":" + startY);
                    //testi
                    passed = false;
                    this.grid[startX][startY].addShip();
                    startX++;

                }
                if (dir == 2) {
                    //south
                    if (startY + pieces > this.ysize - 1 && passed) {
                        System.out.println("DirY: " + dir);
                        dir = random.nextInt(4);
                        startX = random.nextInt(this.xsize);
                        startY = random.nextInt(this.ysize);
                        i--;
                        continue;
                    }
                    for (int x = 0; x < pieces; x++) {

                        if (this.grid[testiX][testiY].hasShip() && passed) {
                            System.out.println("Dir: " + dir);
                            dir = random.nextInt(4);
                            startX = random.nextInt(this.xsize);
                            startY = random.nextInt(this.ysize);
                            test = true;
                        }
                        if (testiX - 1 >= 0) {
                            if (this.grid[testiX - 1][testiY].hasShip() && passed) {
                                System.out.println("DirS: " + dir);
                                dir = random.nextInt(4);
                                startX = random.nextInt(this.xsize);
                                startY = random.nextInt(this.ysize);
                                test = true;
                            }
                        }
                        if (testiX + 1 <= this.xsize - 1) {
                            if (this.grid[testiX + 1][testiY].hasShip() && passed) {
                                System.out.println("DirS: " + dir);
                                dir = random.nextInt(4);
                                startX = random.nextInt(this.xsize);
                                startY = random.nextInt(this.ysize);
                                test = true;
                            }
                        }
                        if (testiY - 1 >= 0) {
                            if (this.grid[testiX][testiY - 1].hasShip() && passed) {
                                System.out.println("DirS: " + dir);
                                dir = random.nextInt(4);
                                startX = random.nextInt(this.xsize);
                                startY = random.nextInt(this.ysize);
                                test = true;
                            }
                        }
                        if (testiY + 1 <= this.ysize - 1) {
                            if (this.grid[testiX][testiY + 1].hasShip() && passed) {
                                System.out.println("DirS: " + dir);
                                dir = random.nextInt(4);
                                startX = random.nextInt(this.xsize);
                                startY = random.nextInt(this.ysize);
                                test = true;
                            }
                        }

                        if (passed) {
                            testiY++;
                        }

                    }
                    if (test) {
                        i--;
                        test = false;
                        continue;
                    }
                    // Adding ships
                    //testi
                    System.out.println(startX + ":" + startY);
                    //testi
                    passed = false;
                    this.grid[startX][startY].addShip();
                    startY++;
                }
                if (dir == 3) {
                    //west
                    if (startX - pieces < 0 && passed) {
                        System.out.println("DirY: " + dir);
                        dir = random.nextInt(4);
                        startX = random.nextInt(this.xsize);
                        startY = random.nextInt(this.ysize);
                        i--;
                        continue;
                    }
                    for (int x = 0; x < pieces; x++) {

                        if (this.grid[testiX][testiY].hasShip() && passed) {
                            System.out.println("Dir: " + dir);
                            dir = random.nextInt(4);
                            startX = random.nextInt(this.xsize);
                            startY = random.nextInt(this.ysize);
                            test = true;
                        }
                        if (testiX - 1 >= 0) {
                            if (this.grid[testiX - 1][testiY].hasShip() && passed) {
                                System.out.println("DirS: " + dir);
                                dir = random.nextInt(4);
                                startX = random.nextInt(this.xsize);
                                startY = random.nextInt(this.ysize);
                                test = true;
                            }
                        }
                        if (testiX + 1 <= this.xsize - 1) {
                            if (this.grid[testiX + 1][testiY].hasShip() && passed) {
                                System.out.println("DirS: " + dir);
                                dir = random.nextInt(4);
                                startX = random.nextInt(this.xsize);
                                startY = random.nextInt(this.ysize);
                                test = true;
                            }
                        }
                        if (testiY - 1 >= 0) {
                            if (this.grid[testiX][testiY - 1].hasShip() && passed) {
                                System.out.println("DirS: " + dir);
                                dir = random.nextInt(4);
                                startX = random.nextInt(this.xsize);
                                startY = random.nextInt(this.ysize);
                                test = true;
                            }
                        }
                        if (testiY + 1 <= this.ysize - 1) {
                            if (this.grid[testiX][testiY + 1].hasShip() && passed) {
                                System.out.println("DirS: " + dir);
                                dir = random.nextInt(4);
                                startX = random.nextInt(this.xsize);
                                startY = random.nextInt(this.ysize);
                                test = true;
                            }
                        }
                        if (passed) {
                            testiX--;
                        }

                    }
                    if (test) {

                        i--;
                        test = false;
                        continue;
                    }
                    // Adding ships
                    //testi
                    System.out.println(startX + ":" + startY);
                    //testi
                    passed = false;
                    this.grid[startX][startY].addShip();
                    startX--;
                }

            }

            //testi
            System.out.println("Dir: " + dir);
            System.out.println("-----------------");
            //testi
            pieces++;
            if (pieces > 5) {
                return;
            }
            startX = random.nextInt(this.xsize);
            startY = random.nextInt(this.ysize);
            dir = random.nextInt(4);

        }

    }
    /**
    * Tarkistaa onko gridi tyhjä eli peli loppunut
    *
    * @param   
    * 
    * @return true tai false tilanteen mukaan.
    */
    
    public boolean checkGrid() {
        int shipAmount = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j].hasShip()) {
                    if (grid[i][j].getShip().getStatus()) {
                        shipAmount++;

                    }
                }

            }

        }
        System.out.println(shipAmount);
        if (shipAmount > 0) {

            return true;
        }

        return false;
    }
    
    /**
    * Tarkistaa tiettyyn gridiin liittyviä tilastoja
    *
    * @param   
    * 
    * @return int[] jossa mukana tilastoja
    */

    public int[] gridCheckerStats() {
        int shipAmount = 0;
        int floatAmount = 0;
        int seaAmount = 0;
        int guessed = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j].hasShip()) {
                    shipAmount++;
                    if (grid[i][j].getShip().getStatus()) {
                        floatAmount++;

                    }
                }
                if (!grid[i][j].hasShip()) {
                    seaAmount++;
                }
                if (grid[i][j].getGuessed()) {
                    guessed++;
                }

            }

        }
        int[] list = new int[4];
        list[0] = shipAmount;
        list[1] = floatAmount;
        list[2] = seaAmount;
        list[3] = guessed;
        return list;
    }

    
    public int getXSize() {
        return this.xsize;
    }

    public int getYSize() {
        return this.ysize;
    }

    public Location[][] getGrid() {
        return this.grid;
    }

    public Location getLocation(int x, int y) {
        return this.grid[x][y];
    }
    
    

}
