/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gisyritys.graphics;

import com.gisyritys.logic.DBStats;
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
import javafx.scene.layout.GridPane;

/**
 *
 *
 * Ohjelman pääluokka, suorittaa graafisten luokkien asettelun
 */
public class Main extends Application {

    @Override
    public void start(Stage w) {
        Button start = new Button("Aloita peli");
        BorderPane menuPane = new BorderPane();
        menuPane.setLeft(start);

        DBStats db = new DBStats();
        db.createDB();
        Button statButton = new Button("Tilastot");
        menuPane.setRight(statButton);
        Scene menu = new Scene(menuPane);

        start.setOnAction((event) -> {
            Board board = new Board();
            Grid botGrid = new Grid(10, 10);
            botGrid.randomGrid();
            BorderPane b = board.boardScene();
            Button cont = new Button("Valmis");
            cont.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    Game game = new Game(board.getBoard(), botGrid);
                    Button stop = new Button("Lopeta peli");

                    stop.setOnAction((eventStats) -> {
                        Stats stats = new Stats(game.getGrid(), game.getBotGrid());
                        BorderPane statsPane = stats.getStatsPane();
                        Button toMenu = new Button("Valikkoon");

                        statsPane = stats.getStatsPane();
                        db.addToDB(stats.checkGridsDB());
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

            Scene boardScene = new Scene(b);
            w.setScene(boardScene);

        });

        statButton.setOnAction((event) -> {
            Grid g1 = new Grid(10, 10);
            Grid g2 = new Grid(10, 10);
            Stats dbStats = new Stats(g1, g2);
            GridPane dbPane = dbStats.getDbStatsPane(db.getDB());
            Button toMenu = new Button("Valikkoon");
            toMenu.setOnAction((eventQuit) -> {

                w.setScene(menu);

            });
            dbPane.add(toMenu, 4, 0);
            Scene statsScene = new Scene(dbPane);
            w.setScene(statsScene);
        });

        w.setScene(menu);
        w.setTitle("Laivanupotus");
        w.show();

    }

    public static void main(String[] args) {
        launch(Main.class);

    }
}
