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
        

        start.setOnAction((event) -> {
            Board board = new Board();
            Grid grid = board.getBoard();
            Grid botGrid = new Grid(10,10);
            botGrid.randomGrid();
            BorderPane b = board.boardScene();
            Button cont = new Button("Valmis");
            cont.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    Game game = new Game(board.getBoard(),botGrid);
                    Button stop = new Button("Lopeta peli");
                    
                    
                    
                    stop.setOnAction((eventStats) -> {
                        Stats stats = new Stats(game.getGrid(),game.getBotGrid());
                        BorderPane statsPane = stats.getStatsPane();
                        Button toMenu = new Button("Valikkoon");
                        
                        statsPane = stats.getStatsPane();
                        toMenu.setOnAction((eventQuit) -> {
                           
                            w.setScene(menu);
                        
                        });
                        statsPane.setRight(toMenu);
                        Scene statsScene = new Scene(statsPane);
                        w.setScene(statsScene);
                        
                        
                        
                    });   
                    
                    BorderPane p = game.getGame();
                    p.setBottom(stop);
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
