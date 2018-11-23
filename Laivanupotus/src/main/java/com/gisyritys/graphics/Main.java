/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gisyritys.graphics;
import com.gisyritys.logic.Grid;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

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
        Grid grid = board.getBoard();
        
        start.setOnAction((event) -> {
            BorderPane b = board.boardScene();
            Label cont = new Label("Valmis");
            cont.setOnMouseClicked(new EventHandler<MouseEvent>(){
                    @Override
                    public void handle(MouseEvent event){
                        Game game = new Game(board.getBoard());
                        BorderPane p = game.getGame();
                        Scene gameScene = new Scene(p);
                        w.setScene(gameScene);
                        
                    }    
                    
                });
            b.setRight(cont);
            //Onko kirjotustyyli oikee?
            Scene boardScene = new Scene(b);
            w.setScene(boardScene);
            //Onko kirjotustyyli oikee?
            
            
        });
        
        
        w.setScene(menu);
        w.setTitle("Laivanupotus");
        w.show();
        
    }
    
    public static void main(String[] args) {
        launch(Main.class);
        
    }
}
