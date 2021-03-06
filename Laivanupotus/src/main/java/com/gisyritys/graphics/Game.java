/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gisyritys.graphics;

import com.gisyritys.logic.Grid;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.layout.Background;
import javafx.scene.paint.Paint;

/**
 *
 * Hoitaa pelaajan pelaamiseen liittyvät näkymät
 */
public class Game {

    Grid grid;
    Grid bot;
    Boolean gameOn;

    public Game(Grid g, Grid b) {
        this.grid = g;
        this.bot = b;
        this.gameOn = true;

    }

    /**
     * Tuo pelaajalle pelattavan version tietokoneen pelilaudasta. Ruudut ovat
     * klikattavissa ja näin tuhottavissa.
     *
     * @param
     *
     * @return Klikattavan BorderPane version tietokonepelaajan laudasta
     */
    public BorderPane getGame() {
        BorderPane screen = new BorderPane();
        Label type = new Label("Peli käynnissä");
        screen.setTop(type);

        BotGame botGame = new BotGame(this.grid);
        GridPane pane = botGame.startGrid();

        GridPane botPane = new GridPane();
        for (int x = 0; x <= bot.getGrid().length - 1; x++) {
            for (int y = 0; y <= bot.getGrid()[x].length - 1; y++) {
                Label button = new Label("~~");

                BackgroundFill b = new BackgroundFill(javafx.scene.paint.Paint.valueOf("#376b9a"), CornerRadii.EMPTY, Insets.EMPTY);
                Background background = new Background(b);
                button.setBackground(background);

                //Mouse clicks
                button.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {

                        int xloc = botPane.getColumnIndex(button);
                        int yloc = botPane.getRowIndex(button);
                        MouseButton mouse = event.getButton();
                        if (mouse == MouseButton.SECONDARY) {

                        } else if (mouse == MouseButton.PRIMARY && gameOn) {
                            Boolean play = false;
                            if (bot.getGrid()[xloc][yloc].hasShip()) {

                                BackgroundFill b = new BackgroundFill(javafx.scene.paint.Paint.valueOf("#eea331"), CornerRadii.EMPTY, Insets.EMPTY);
                                Background background = new Background(b);
                                button.setBackground(background);

                                play = true;
                                if (!bot.getGrid()[xloc][yloc].getShip().getStatus()) {
                                    play = false;
                                }
                                bot.getLocation(xloc, yloc).getShip().sinkShip();

                            } else if (!bot.getGrid()[xloc][yloc].hasShip() && !bot.getGrid()[xloc][yloc].getGuessed()) {
                                play = true;
                                BackgroundFill b = new BackgroundFill(javafx.scene.paint.Paint.valueOf("#54aeff"), CornerRadii.EMPTY, Insets.EMPTY);
                                Background background = new Background(b);
                                button.setBackground(background);

                            }
                            if (play) {
                                GridPane pane = botGame.play();
                                grid = botGame.getGrid();
                                screen.setLeft(pane);
                            }

                            bot.getGrid()[xloc][yloc].setGuessed();

                            if (!grid.checkGrid()) {
                                type.setText("Tietokone voitti!");
                                gameOn = grid.checkGrid();
                            }
                            if (!bot.checkGrid()) {
                                type.setText("Sinä voitit!");
                                gameOn = bot.checkGrid();
                            }
                            if (!grid.checkGrid() && !bot.checkGrid()) {
                                type.setText("Tasapeli!");
                                gameOn = grid.checkGrid();
                            }

                        }

                    }

                });

                botPane.add(button, x, y);

            }
        }

        Label keski = new Label("|    |\n|    |\n|    |\n|    |\n|    |\n|    |\n|    |\n|    |\n|    |\n|    |");

        screen.setLeft(pane);
        screen.setCenter(keski);
        screen.setRight(botPane);

        return screen;

    }

    public Grid getGrid() {
        return this.grid;
    }

    public Grid getBotGrid() {
        return this.bot;
    }
}
