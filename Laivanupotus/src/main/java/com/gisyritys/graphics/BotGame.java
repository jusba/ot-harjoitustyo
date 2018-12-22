/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gisyritys.graphics;

import com.gisyritys.logic.Grid;
import java.util.ArrayList;
import java.util.Random;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;

/**
 *
 * Hoitaa tietokoneen pelaamiseen liittyvät näkymät
 */
public class BotGame {

    Grid grid;
    Random random;
    Boolean hit;
    int previousX;
    int previousY;
    ArrayList<int[]> previous;
    int count;
    int dir;
    int startX;
    int startY;
    int saveX;
    int saveY;

    Boolean check;

    public BotGame(Grid g) {

        this.grid = g;
        this.random = new Random();
        this.hit = false;
        this.previousX = 0;
        this.previousY = 0;
        this.previous = new ArrayList<int[]>();
        this.count = 0;
        this.dir = 0;
        this.check = false;

    }

    /**
     * Suorittaa tietokonepelaajaan liittyvät toiminnot pelaajan pelilaudalla.
     * Tuo aina päivitetyn näkymän pelaajan pelilaudasta tietokonepelaajan
     * valinnan jälkeen
     *
     * @param
     *
     * @return Tietokoneen liikkeitä pelaajan pelilaudalla kuvaava GridPane
     */

    public GridPane play() {

        GridPane pane = new GridPane();
        int[] cXY = new int[3];
        int xCoord = chooseX();
        int yCoord = chooseY();
        if (this.count > 0 && this.count < 5) {
            cXY = this.grid.chooseXYForBot(this.previousX, this.previousY, this.dir);
            if (cXY[0] != saveX && cXY[1] != saveY && this.check) {
                cXY = this.grid.chooseAnotherDirectionForBot(saveX, saveY, this.dir);
                this.check = false;

            }
            xCoord = cXY[0];
            yCoord = cXY[1];
        }
        if (this.count >= 5) {
            this.count = 0;
            this.hit = false;
            this.dir = 0;
        }

        boolean match = true;
        while (true) {
            for (int x = 0; x <= this.grid.getGrid().length - 1; x++) {
                for (int y = 0; y <= this.grid.getGrid()[x].length - 1; y++) {

                    Label button = new Label("~~");
                    BackgroundFill b = new BackgroundFill(javafx.scene.paint.Paint.valueOf("#376b9a"), CornerRadii.EMPTY, Insets.EMPTY);
                    Background background = new Background(b);
                    button.setBackground(background);
                    if (this.grid.getGrid()[x][y].getGuessed()) {

                        BackgroundFill bGuessed = new BackgroundFill(javafx.scene.paint.Paint.valueOf("#54aeff"), CornerRadii.EMPTY, Insets.EMPTY);
                        Background backgroundGuessed = new Background(bGuessed);
                        button.setBackground(backgroundGuessed);
                    }
                    if (xCoord == x && yCoord == y && !this.grid.getGrid()[x][y].getGuessed()) {
                        BackgroundFill bGuessed = new BackgroundFill(javafx.scene.paint.Paint.valueOf("#54aeff"), CornerRadii.EMPTY, Insets.EMPTY);
                        Background backgroundGuessed = new Background(bGuessed);
                        button.setBackground(backgroundGuessed);
                        this.grid.getGrid()[x][y].setGuessed();
                        if (this.count == 0) {
                            this.dir--;
                        }
                        this.dir++;

                        match = false;

                    }

                    if (this.grid.getGrid()[x][y].hasShip() && this.grid.getGrid()[x][y].getShip().getStatus()) {
                        if (xCoord == x && yCoord == y) {
                            BackgroundFill bSink = new BackgroundFill(javafx.scene.paint.Paint.valueOf("#eea331"), CornerRadii.EMPTY, Insets.EMPTY);
                            Background backgroundSink = new Background(bSink);
                            button.setBackground(backgroundSink);
                            grid.getLocation(x, y).getShip().sinkShip();
                            this.grid.getGrid()[x][y].setGuessed();
                            if (this.hit) {
                                count = 0;
                                this.dir = this.grid.getPrevDir();
                            }
                            if (!this.hit) {
                                this.saveX = xCoord;
                                this.saveY = yCoord;
                            }
                            this.hit = true;
                            this.startX = xCoord;
                            this.startY = yCoord;
                            match = false;
                            this.check = true;

                        } else {
                            BackgroundFill bShip = new BackgroundFill(javafx.scene.paint.Paint.valueOf("#40474d"), CornerRadii.EMPTY, Insets.EMPTY);
                            Background backgroundShip = new Background(bShip);
                            button.setBackground(backgroundShip);
                        }

                    }
                    if (this.grid.getGrid()[x][y].hasShip()) {
                        if (this.grid.getGrid()[x][y].getShip().getStatus() == false) {
                            BackgroundFill bSink = new BackgroundFill(javafx.scene.paint.Paint.valueOf("#eea331"), CornerRadii.EMPTY, Insets.EMPTY);
                            Background backgroundSink = new Background(bSink);
                            button.setBackground(backgroundSink);
                        }
                    }

                    pane.add(button, x, y);

                }
            }
            if (this.hit) {
                this.count++;
            }

            if (!match) {

                break;
            }

            xCoord = chooseX();
            yCoord = chooseY();
        }

        this.previousX = xCoord;
        this.previousY = yCoord;

        if (this.hit) {
            this.previousX = startX;
            this.previousY = startY;

        }

        return pane;
    }

    /**
     * Tuo pelaajan pelilaudan, ennenkuin kumpikaan on valinnut ensimmäisiä
     * ruutujaan.
     *
     * @param
     *
     * @return Pelaajan pelilautaa kuvaava GridPane ennenkuin kumpikaan valinnut
     * ruutuja
     */

    public GridPane startGrid() {
        GridPane pane = new GridPane();

        for (int x = 0; x <= this.grid.getGrid().length - 1; x++) {
            for (int y = 0; y <= this.grid.getGrid()[x].length - 1; y++) {

                Label button = new Label("~~");

                BackgroundFill b = new BackgroundFill(javafx.scene.paint.Paint.valueOf("#376b9a"), CornerRadii.EMPTY, Insets.EMPTY);
                Background background = new Background(b);
                button.setBackground(background);
                if (this.grid.getGrid()[x][y].getGuessed()) {
                    this.grid.getGrid()[x][y].setGuessed();

                    button = new Label("()");
                }

                if (this.grid.getGrid()[x][y].hasShip() && this.grid.getGrid()[x][y].getShip().getStatus()) {

                    BackgroundFill bShip = new BackgroundFill(javafx.scene.paint.Paint.valueOf("#40474d"), CornerRadii.EMPTY, Insets.EMPTY);
                    Background backgroundShip = new Background(bShip);
                    button.setBackground(backgroundShip);

                }
                if (this.grid.getGrid()[x][y].hasShip()) {
                    if (this.grid.getGrid()[x][y].getShip().getStatus() == false) {
                        button = new Label("**");
                    }
                }

                pane.add(button, x, y);

            }
        }
        return pane;
    }

    public Grid getGrid() {
        return this.grid;
    }

    /**
     * Valitsee x arvon
     *
     * @param
     *
     * @return SAtunnainen x arvo kentän koon mukaan
     */
    public int chooseX() {

        int x = random.nextInt(this.grid.getXSize());
        return x;
    }

    /**
     * Valitsee y arvon
     *
     * @param
     *
     * @return Satunnainen y arvo kentän koon mukaan
     */
    public int chooseY() {

        int y = random.nextInt(this.grid.getYSize());
        return y;
    }

}
