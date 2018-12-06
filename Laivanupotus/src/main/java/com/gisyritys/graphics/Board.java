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
    private int ships;

    public Board() {
        this.grid = new Grid(10, 10);
        this.ships = 15;

    }

    public Grid getBoard() {
        
        return this.grid;
    }

    public BorderPane boardScene() {
        BorderPane screen = new BorderPane();
        
        Label lbl = new Label("Aseta laivat              Paloja jäljellä: " + ships);
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
                        if (mouse == MouseButton.SECONDARY && ships < 15 && grid.getLocation(xloc, yloc).hasShip()) {
                            BackgroundFill b = new BackgroundFill(javafx.scene.paint.Paint.valueOf("#376b9a"), CornerRadii.EMPTY, Insets.EMPTY);
                            Background background = new Background(b);
                            button.setBackground(background);
                            ships = ships +1;
                            lbl.setText("Aseta laivat              Paloja jäljellä: " + ships);
                            grid.removeShip(xloc, yloc);
                            
                        } 
                        else if(mouse == MouseButton.PRIMARY && ships > 0 && !grid.getLocation(xloc, yloc).hasShip()) {
                            BackgroundFill bShip = new BackgroundFill(javafx.scene.paint.Paint.valueOf("#40474d"), CornerRadii.EMPTY, Insets.EMPTY);
                            Background backgroundShip = new Background(bShip);
                            button.setBackground(backgroundShip);
                            ships = ships -1;
                            lbl.setText("Aseta laivat              Paloja jäljellä: " + ships);
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
