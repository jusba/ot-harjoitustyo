/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gisyritys.laivanupotus;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;

/**
 *
 * @author Jussi
 */
public class Main extends Application {
    @Override
    public void start(Stage w) {
        Button start = new Button("Aloita peli");
        Scene menu = new Scene(start);
        Board board =  new Board();
        Grid grid = board.setupBoard();
        start.setOnAction((event) -> {
            w.setScene(board.boardScene());
            
            
        });
        grid = board.setupBoard();
        
        w.setScene(menu);
        w.setTitle("Laivanupotus");
        w.show();
        
    }
    
    public static void main(String[] args) {
        launch(Main.class);
        
    }
}
