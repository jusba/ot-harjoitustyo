/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gisyritys.laivanupotus;


import java.awt.event.MouseAdapter;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.JLabel;
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
        BorderPane screen = new BorderPane();
        //Ship type selection
        VBox vbox = new VBox();
        
        ToggleGroup ships = new ToggleGroup();
        RadioButton lt =  new RadioButton("Lentotukialus");
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
        
        ships.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                System.out.println(ships.getSelectedToggle().getUserData());
            }
            
        });
        vbox.getChildren().add(lt);
        vbox.getChildren().add(tl);
        vbox.getChildren().add(ri);
        vbox.getChildren().add(ha);
        vbox.getChildren().add(su);
        
        screen.setLeft(vbox);
        
        
        GridPane pane = new GridPane();
        Location[][] g = this.grid.getGrid();
        for (int x = 0; x <= this.grid.getGrid().length-1; x++) {
            for (int y = 0; y <= this.grid.getGrid()[x].length-1; y++) {
                String status = "Sea";
                if(this.grid.getGrid()[x][y].hasShip()){
                     status = "Ship";
                }
                
                Label button = new Label("~~");
                button.setOnMouseClicked(new EventHandler<MouseEvent>(){
                    @Override
                    public void handle(MouseEvent event){
                        button.setText("[][]");
                    }
                    
                });
                pane.add(button, x, y);

                
                
            }
        }
        
        screen.setCenter(pane);
        Scene b = new Scene(screen);
        return b;
    
    }
}
