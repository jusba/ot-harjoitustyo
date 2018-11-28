/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gisyritys.graphics;

import com.gisyritys.logic.Grid;
import com.gisyritys.logic.Ship;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;

import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;

import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Jussi
 */
public class Board {

    private Grid grid;
    private int column;

    public Board() {
        this.grid = new Grid(10, 10);

    }

    public Grid getBoard() {

        return this.grid;
    }

    public BorderPane boardScene() {
        BorderPane screen = new BorderPane();
        Label lbl = new Label("                                      Tyyppi: ");
        //Ship type indicator
        screen.setTop(lbl);
        //Continue to next scene

        Label cont = new Label("Valmis");
        cont.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                return;
            }

        });
        screen.setRight(cont);
        //Ship type selection
        VBox vbox = new VBox();

        ToggleGroup ships = new ToggleGroup();
        RadioButton lt = new RadioButton("Lentotukialus");
        lt.setUserData(1);
        lt.setToggleGroup(ships);
        RadioButton tl = new RadioButton("Taistelulaiva");
        tl.setUserData(2);
        tl.setToggleGroup(ships);
        RadioButton ri = new RadioButton("Risteilijä");
        ri.setUserData(3);
        ri.setToggleGroup(ships);
        RadioButton ha = new RadioButton("Hävittäjä");
        ha.setUserData(4);
        ha.setToggleGroup(ships);
        RadioButton su = new RadioButton("Sukellusvene");
        su.setUserData(5);
        su.setToggleGroup(ships);

        ships.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {

            }

        });
        vbox.getChildren().add(lt);
        vbox.getChildren().add(tl);
        vbox.getChildren().add(ri);
        vbox.getChildren().add(ha);
        vbox.getChildren().add(su);

        screen.setLeft(vbox);

        //Ship Grid
        GridPane pane = new GridPane();

        for (int x = 0; x <= this.grid.getGrid().length - 1; x++) {
            for (int y = 0; y <= this.grid.getGrid()[x].length - 1; y++) {
                

                Label button = new Label("~~");
                BackgroundFill b = new BackgroundFill(javafx.scene.paint.Paint.valueOf("#376b9a"), CornerRadii.EMPTY, Insets.EMPTY);
                Background background = new Background(b);
                button.setBackground(background);
                //Mouse clicks
                button.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {

                        int xloc = pane.getColumnIndex(button);
                        int yloc = pane.getRowIndex(button);
                        MouseButton mouse = event.getButton();
                        if (mouse == MouseButton.SECONDARY) {
                            Ship ship = grid.getLocation(xloc, yloc).getShip();
                            lbl.setText("                                      Tyyppi: " + ship.getTyyppi());
                            System.out.println(ship);
                        } else {
                            BackgroundFill bShip = new BackgroundFill(javafx.scene.paint.Paint.valueOf("#40474d"), CornerRadii.EMPTY, Insets.EMPTY);
                            Background backgroundShip = new Background(bShip);
                            button.setBackground(backgroundShip);
                            //Poista
                            System.out.println(xloc + "," + yloc);
                            //Poista
                            grid.addShip(xloc, yloc);

                        }

                    }

                });
                pane.add(button, x, y);

            }
        }

        screen.setCenter(pane);

        return screen;

    }
}
