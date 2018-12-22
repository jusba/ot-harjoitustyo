/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gisyritys.graphics;

import com.gisyritys.logic.Grid;
import java.util.ArrayList;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

/**
 *
 * Hoitaa tilastoihin liittyvien näkymien luonnin ja palautuksen
 */
public class Stats {

    private Grid playerGrid;
    private Grid botGrid;

    public Stats(Grid p, Grid b) {
        playerGrid = p;
        botGrid = b;

    }

    /**
     * Luo tilastonäkymän pelin loputtua
     *
     * @param
     *
     * @return BorderPane, jossa edellisen pelin tilastoja
     */

    public BorderPane getStatsPane() {
        BorderPane stats = new BorderPane();
        String labelText = "Tilastot: " + "\n" + "" + "\n";
        for (String amount : checkGrids()) {
            labelText = labelText + amount + "\n";
        }
        Label label = new Label(labelText);
        stats.setCenter(label);
        return stats;

    }

    /**
     * Luo tilastonäkymän tietokannassa olevista peleistä. Pelatut pelit
     * asetetaan gridille uutuusjärjestyksessä
     *
     * @param
     *
     * @return GridPAne jossa tietoja peleistä
     */
    public GridPane getDbStatsPane(ArrayList<int[]> games) {
        GridPane stats = new GridPane();
        Label header = new Label("TIlastot");
        Label header2 = new Label("Viimeiset 50 peliä:");
        stats.add(header, 0, 0);
        stats.add(header2, 0, 2);
        Label own = new Label("Omia laivoja alunperin ");
        Label ownE = new Label("Omia lopuksi ");
        Label ai = new Label("Vihollisen alunperin ");
        Label aiE = new Label("Vihollisen lopuksi ");
        Label t = new Label("Käytetyt vuorot ");
        stats.add(own, 0, 4);
        stats.add(ownE, 1, 4);
        stats.add(ai, 2, 4);
        stats.add(aiE, 3, 4);
        stats.add(t, 4, 4);

        int size = games.size();
        int x = 0;
        int y = 5;
        int limit = 0;
        for (int i = 0; i < games.size(); i++) {
            if (limit < 50) {
                int[] game = games.get(size - 1);
                Label first = new Label("           " + (Integer.toString(game[0])));
                Label second = new Label("           " + (Integer.toString(game[1])));
                Label third = new Label("           " + (Integer.toString(game[2])));
                Label fourth = new Label("           " + (Integer.toString(game[3])));
                Label fifth = new Label("           " + (Integer.toString(game[4])));
                stats.add(first, x, y);
                stats.add(second, x + 1, y);
                stats.add(third, x + 2, y);
                stats.add(fourth, x + 3, y);
                stats.add(fifth, x + 4, y);
                y++;
                size--;
                limit++;
            }

        }

        return stats;

    }

    /**
     * Luo BorderPaneen sopivan version edellisen pelin tilastoista
     *
     * @param
     *
     * @return String[] jossa arvot BorderPaneen
     */

    public String[] checkGrids() {
        int[] player = playerGrid.gridCheckerStats();
        int[] bot = botGrid.gridCheckerStats();

        String[] list = new String[8];
        list[0] = "Omia laivaruutuja jäljellä: " + player[1];
        list[1] = "Laivoja alunperin: " + player[0];
        list[2] = "Meriruutuja: " + player[2];
        list[3] = "Arvattuja ruutuja: " + player[3] + "\n" + "" + "\n" + "----------------------------------------------------------" + "\n" + "";
        list[4] = "Vihollisen laivaruutuja jäljellä: " + bot[1];
        list[5] = "Vihollisen laivoja alunperin: " + bot[0];
        list[6] = "Vihollisen meriruutuja: " + bot[2];
        list[7] = "Vihollisen arvaamia ruutuja : " + bot[3];

        return list;
    }

    /**
     * Luo BorderPaneen sopivan version kaikista tilastoista
     *
     * @param
     *
     * @return Int[] jossa arvot BorderPaneen
     */
    public int[] checkGridsDB() {
        int[] player = playerGrid.gridCheckerStats();
        int[] bot = botGrid.gridCheckerStats();

        int[] list = new int[8];
        list[0] = player[1];
        list[1] = player[0];
        list[2] = player[2];
        list[3] = player[3];
        list[4] = bot[1];
        list[5] = bot[0];
        list[6] = bot[2];
        list[7] = bot[3];

        return list;
    }

}
