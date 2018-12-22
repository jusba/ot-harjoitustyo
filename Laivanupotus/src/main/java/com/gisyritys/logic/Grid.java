/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gisyritys.logic;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * Luo pelilautaa kuvaavan gridin ja hoitaa siihen liittyviä toimintoja
 */
public class Grid {

    private Location grid[][];
    private int xsize;
    private int ysize;
    private int startX;
    private int startY;
    private int dir;
    private Random random;
    private Boolean test;
    private int testiX;
    private int testiY;
    private int prevDir;

    public Grid(int x, int y) {
        this.xsize = x;
        this.ysize = y;
        this.grid = new Location[this.xsize][this.ysize];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = new Location();
            }

        }
        this.random = new Random();
        this.random.nextInt(this.xsize);
        this.startY = random.nextInt(this.ysize);
        this.dir = random.nextInt(4);
        this.test = false;

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
     * @param int x, int y, eli halutun ruudun sijainti.
     *
     * @return
     */
    public void removeShip(int x, int y) {
        if (grid[x][y].hasShip()) {
            grid[x][y].removeShip();

        }
    }

    /**
     * Luo tiekoneelle uuden satunnaisen gridin. Gridiin asetettavat laivat
     * voivat koskea vain kulmista, eivätkä voi olla vierekkäin
     *
     * @param
     *
     * @return
     */
    public void randomGrid() {
        int pieces = 1;

        while (true) {

            boolean passed = true;
            for (int i = 0; i < pieces; i++) {
                this.testiX = startX;
                this.testiY = startY;
                if (dir == 0) {
                    //north
                    if (startY - pieces < 0 && passed) {
                        gridRandomizerValueRandomizer(false);
                        i--;
                        continue;
                    }
                    for (int x = 0; x < pieces; x++) {

                        checkDirections(passed);

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
                    passed = false;
                    this.grid[startX][startY].addShip();
                    startY--;

                }
                if (dir == 1) {
                    //east
                    if (startX + pieces > this.xsize - 1 && passed) {
                        gridRandomizerValueRandomizer(false);
                        i--;
                        continue;
                    }
                    for (int x = 0; x < pieces; x++) {

                        checkDirections(passed);

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

                    passed = false;
                    this.grid[startX][startY].addShip();
                    startX++;

                }
                if (dir == 2) {
                    //south
                    if (startY + pieces > this.ysize - 1 && passed) {
                        gridRandomizerValueRandomizer(false);
                        i--;
                        continue;
                    }
                    for (int x = 0; x < pieces; x++) {

                        checkDirections(passed);

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

                    passed = false;
                    this.grid[startX][startY].addShip();
                    startY++;
                }
                if (dir == 3) {
                    //west
                    if (startX - pieces < 0 && passed) {
                        gridRandomizerValueRandomizer(false);
                        i--;
                        continue;
                    }
                    for (int x = 0; x < pieces; x++) {

                        checkDirections(passed);

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

                    passed = false;
                    this.grid[startX][startY].addShip();
                    startX--;
                }

            }

            pieces++;
            if (pieces > 5) {
                return;
            }
            gridRandomizerValueRandomizer(false);

        }

    }

    /**
     * Tarkistaa randomgridiä varten ruutuja ja asettaa satunnaiset arvot
     * tarviattessa.
     *
     *
     * @param Boolean passed, joka kertoo mitä kohtia käydään läpi
     *
     * @return -
     */
    public void checkDirections(Boolean passed) {
        if (this.grid[testiX][testiY].hasShip() && passed) {
            gridRandomizerValueRandomizer(true);

        }
        if (testiX - 1 >= 0 && this.grid[testiX - 1][testiY].hasShip() && passed) {

            gridRandomizerValueRandomizer(true);

        }
        if (testiX + 1 <= this.xsize - 1 && this.grid[testiX + 1][testiY].hasShip() && passed) {

            gridRandomizerValueRandomizer(true);

        }
        if (testiY - 1 >= 0 && this.grid[testiX][testiY - 1].hasShip() && passed) {

            gridRandomizerValueRandomizer(true);

        }
        if (testiY + 1 <= this.ysize - 1 && this.grid[testiX][testiY + 1].hasShip() && passed) {

            gridRandomizerValueRandomizer(true);

        }
    }

    /**
     * Asettaa uusia satunnaisia arvoja random gridiä varten
     *
     * @param Boolean tester joka kertoo asetetaanko uusi testiarvo
     *
     * @return -
     */
    public void gridRandomizerValueRandomizer(Boolean tester) {
        this.dir = random.nextInt(4);
        this.startX = random.nextInt(this.xsize);
        this.startY = random.nextInt(this.ysize);
        if (tester) {
            this.test = true;
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
        int[] list = new int[4];
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

    /**
     * Valitsee tietokoneelle seuraavan ruudun, jos tietokone on osunut
     * edellisellä johonkin
     *
     * @param int x, int y, int dir, edelliset xy kordinaatit ja suunta
     *
     * @return int[] lista seuraavista kordinaateista
     */
    public int[] chooseXYForBot(int x, int y, int dir) {
        int coords[] = new int[3];

        int d = dir;
        boolean guess = false;
        while (d < 4) {
            if (d == 0) {
                // north
                if (y - 1 >= 0) {
                    guess = checkLocation(x, y - 1);
                }

            }
            if (d == 1) {
                // east
                if (x + 1 <= this.xsize - 1) {
                    guess = checkLocation(x + 1, y);
                }
            }
            if (d == 2) {
                // south
                if (y + 1 <= this.ysize - 1) {
                    guess = checkLocation(x, y + 1);
                }
            }
            if (d == 3) {
                // west
                if (x - 1 >= 0) {
                    guess = checkLocation(x - 1, y);
                }
            }
            if (guess) {
                break;

            }
            d++;
        }

        if (!guess) {
            
            return failedCoords();
        }
        this.prevDir = d;
        if (this.prevDir > 3) {
            this.prevDir = 0;
        }
        return coordsMaker(x, y, d);
    }

    /**
     * Tekee kordinaatit int[] arraylle oikeaan muotoon suunnan mukaan
     *
     * @param int x, int y, int dir, edelliset xy kordinaatit ja suunta
     *
     * @return int[] lista seuraavista kordinaateista
     */
    public int[] coordsMaker(int x, int y, int d) {
        int coords[] = new int[3];
        if (d == 0) {
            coords[0] = x;
            coords[1] = y - 1;

        }
        if (d == 1) {
            coords[0] = x + 1;
            coords[1] = y;

        }
        if (d == 2) {
            coords[0] = x;
            coords[1] = y + 1;

        }
        if (d == 3) {
            coords[0] = x - 1;
            coords[1] = y;

        }
        return coords;

    }

    public int getPrevDir() {
        return this.prevDir;
    }

    /**
     * Valitsee tietokoneelle seuraavan ruudun, jos tietokone on käynyt yhden
     * laivan yhden suunnan läpi
     *
     * @param int x, int y, int dir, alkuperäiset osumakordinaatit laivaan ja
     * nykyinen suunta
     *
     * @return int[] lista seuraavista kordinaateista
     */
    public int[] chooseAnotherDirectionForBot(int x, int y, int dir) {
        

        
        boolean guess = false;

        if (newDir(dir - 1) == 0 && y - 1 >= 0) {
            // north

            guess = checkLocation(x, y - 1);

        }
        if (newDir(dir - 1) == 1 && x + 1 <= this.xsize - 1) {
            // east

            guess = checkLocation(x + 1, y);

        }
        if (newDir(dir - 1) == 2 && y + 1 <= this.ysize - 1) {
            // south

            guess = checkLocation(x, y + 1);

        }
        if (newDir(dir - 1) == 3 && x - 1 >= 0) {
            // west

            guess = checkLocation(x - 1, y);

        }

        if (!guess) {

            return failedCoords();
        }
        prevDirChecker(newDir(dir - 1));

        return coordsMaker(x, y, newDir(dir - 1));

    }
    /**
     * Luo uudet satunnaiset kordinaatit, jos niiden luonti ei onnistu kunnolla chooseAnotherDirectionForBot:ssa
     *
     * @param 
     *
     * @return int[] lista seuraavista kordinaateista
     */

    public int[] failedCoords() {
        int coords[] = new int[3];
        coords[0] = random.nextInt(10);
        coords[1] = random.nextInt(10);
        return coords;
    }
    
    /**
     * Tarkistaa, onko prevDir muuttuja kunnossa
     *
     * @param int d suunta, joka on uusi edellinen
     *
     * @return 
     */
    public void prevDirChecker(int d) {
        this.prevDir = d;
        if (this.prevDir > 3) {
            this.prevDir = 0;
        }
    }

    /**
     * Antaa parametrina saatuun suuntaan nähden vastakkaisen suunnan
     *
     * @param int d vanha suunta
     *
     * @return int uusi suunta
     */
    public int newDir(int d) {
        if (d == 0) {
            return 2;
        }
        if (d == 1) {
            return 3;
        }
        if (d == 2) {
            return 0;
        } else {
            return 1;
        }

    }

    /**
     * Tarkistaa onko sijanti arvattu aikaisemmin
     *
     * @param int x, int y kordinaatit
     *
     * @return boolean tilanteen mukaan
     */
    public boolean checkLocation(int x, int y) {
        if (!this.grid[x][y].getGuessed()) {
            return true;
        }
        return false;
    }
}
