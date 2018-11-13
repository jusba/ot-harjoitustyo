/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gisyritys.laivanupotus;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
/**
 *
 * @author Jussi
 */
public class Board {
    private Grid grid;
    
    public Board(){
        this.grid = new Grid();
    }
    public Grid setupBoard(){
        
        return this.grid;
    }
    public Scene boardScene(){
        
        GridPane pane = new GridPane();
        Location[][] g = this.grid.getGrid();
        for (int x = 0; x <= this.grid.getGrid().length-1; x++) {
            for (int y = 0; y <= this.grid.getGrid()[x].length-1; y++) {
                String status = "Sea";
                if(this.grid.getGrid()[x][y].hasShip()){
                     status = "Ship";
                }
            pane.add(new Button(status), x, y);
            }
        }
        

        Scene b = new Scene(pane);
        return b;
    
    }
}
