/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gisyritys.laivanupotus;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Jussi
 */
public class Game {
        Grid grid;
    
    public Game(Grid g){
        this.grid = g;
    }
    
    public BorderPane getGame(){
        BorderPane screen = new BorderPane();
        Label type = new Label("testi");
        screen.setTop(type);
        
        GridPane pane = new GridPane();
        
        for (int x = 0; x <= this.grid.getGrid().length-1; x++) {
            for (int y = 0; y <= this.grid.getGrid()[x].length-1; y++) {
                Label button = new Label("~~"); 
                if(this.grid.getGrid()[x][y].hasShip()){
                    button = new Label("[][]");
                }
                
                
                //Mouse clicks
                button.setOnMouseClicked(new EventHandler<MouseEvent>(){
                    @Override
                    public void handle(MouseEvent event){
                        
                        //int xloc = pane.getColumnIndex(button);
                        //int yloc = pane.getRowIndex(button);
                        MouseButton mouse = event.getButton();
                        if(mouse == MouseButton.SECONDARY){
                        //    Ship ship = grid.getLocation(xloc, yloc).getShip();
                          //  type.setText("                                      Tyyppi: " + ship.getTyyppi());
                          //  System.out.println(ship);
                        }
                        else{
                          //  button.setText("[][]");
                            //Poista
                         //   System.out.println(xloc + "," + yloc);
                            //Poista
                          //  grid.addShip(xloc, yloc);
                            
                        }
                        
                        
                        
                        
                        
                    }
                    
                });
                pane.add(button, x, y);
                
                
                
                
            }
        }
        GridPane botPane = new GridPane();
        Grid bot = new Grid(this.grid.getXSize(),this.grid.getYSize());
        bot.randomGrid();
        for (int x = 0; x <= bot.getGrid().length-1; x++) {
            for (int y = 0; y <= bot.getGrid()[x].length-1; y++) {
                Label button = new Label("~~"); 
                if(bot.getGrid()[x][y].hasShip()){
                    button = new Label("[][]");
                }
                
                
                
                botPane.add(button, x, y);
                
                
                
                
            }
        }
        Label keski = new Label("Wip");
        screen.setLeft(pane);
        screen.setCenter(keski);
        screen.setRight(botPane);
        
        return screen;
       
    }
}
    