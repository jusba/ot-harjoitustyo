/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gisyritys.graphics;

import com.gisyritys.logic.Grid;
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
 * @author Jussi
 */
public class BotGame {
    Grid grid;
    Random random;
    
    public BotGame(Grid g){
    
        this.grid = g;
        this.random = new Random();
    }
    
    public GridPane play(){
        
        GridPane pane = new GridPane();
        int xCoord = chooseX();
        int yCoord = chooseY();

        for (int x = 0; x <= this.grid.getGrid().length - 1; x++) {
            for (int y = 0; y <= this.grid.getGrid()[x].length - 1; y++) {
                
                Label button = new Label("~~");
                BackgroundFill b = new BackgroundFill(javafx.scene.paint.Paint.valueOf("#376b9a"), CornerRadii.EMPTY, Insets.EMPTY);
                Background background = new Background(b);
                button.setBackground(background);
                if(xCoord == x && yCoord == y ||this.grid.getGrid()[x][y].getGuessed() ){
                    this.grid.getGrid()[x][y].setGuessed();
                    
                    BackgroundFill bGuessed = new BackgroundFill(javafx.scene.paint.Paint.valueOf("#54aeff"), CornerRadii.EMPTY, Insets.EMPTY);
                    Background backgroundGuessed = new Background(bGuessed);
                    button.setBackground(backgroundGuessed);
                }
                
                if (this.grid.getGrid()[x][y].hasShip() && this.grid.getGrid()[x][y].getShip().getStatus()) {
                    if(xCoord == x && yCoord == y){
                        BackgroundFill bSink = new BackgroundFill(javafx.scene.paint.Paint.valueOf("#eea331"), CornerRadii.EMPTY, Insets.EMPTY);
                        Background backgroundSink = new Background(bSink);
                        button.setBackground(backgroundSink);
                        grid.getLocation(x, y).getShip().sinkShip();
                        this.grid.getGrid()[x][y].setGuessed();
                        
                        
                    }
                    else{
                        BackgroundFill bShip = new BackgroundFill(javafx.scene.paint.Paint.valueOf("#40474d"), CornerRadii.EMPTY, Insets.EMPTY);
                        Background backgroundShip = new Background(bShip);
                        button.setBackground(backgroundShip);
                    }
                    
                }
                if(this.grid.getGrid()[x][y].hasShip()){
                    if(this.grid.getGrid()[x][y].getShip().getStatus() == false){
                        BackgroundFill bSink = new BackgroundFill(javafx.scene.paint.Paint.valueOf("#eea331"), CornerRadii.EMPTY, Insets.EMPTY);
                        Background backgroundSink = new Background(bSink);
                        button.setBackground(backgroundSink);
                    }
                }
                

                pane.add(button, x, y);

            }
        }
        return pane;
    }
    public GridPane startGrid(){
        GridPane pane = new GridPane();
        

        for (int x = 0; x <= this.grid.getGrid().length - 1; x++) {
            for (int y = 0; y <= this.grid.getGrid()[x].length - 1; y++) {
                
                Label button = new Label("~~");
                
                BackgroundFill b = new BackgroundFill(javafx.scene.paint.Paint.valueOf("#376b9a"), CornerRadii.EMPTY, Insets.EMPTY);
                Background background = new Background(b);
                button.setBackground(background);
                if(this.grid.getGrid()[x][y].getGuessed() ){
                    this.grid.getGrid()[x][y].setGuessed();
                    
                    button = new Label("()");
                }
                
                if (this.grid.getGrid()[x][y].hasShip() && this.grid.getGrid()[x][y].getShip().getStatus()) {
                    
                    
                    BackgroundFill bShip = new BackgroundFill(javafx.scene.paint.Paint.valueOf("#40474d"), CornerRadii.EMPTY, Insets.EMPTY);
                    Background backgroundShip = new Background(bShip);
                    button.setBackground(backgroundShip);
                    
                    
                }
                if(this.grid.getGrid()[x][y].hasShip()){
                    if(this.grid.getGrid()[x][y].getShip().getStatus() == false){
                        button = new Label("**");
                    }
                }
                

                pane.add(button, x, y);

            }
        }
        return pane;
    }
    public Grid getGrid(){
        return this.grid;
    }
    
    public int chooseX(){
        int x = random.nextInt(this.grid.getXSize());
        return x;
    }
    public int chooseY(){
        int y = random.nextInt(this.grid.getYSize());
        return y;
    }
}
