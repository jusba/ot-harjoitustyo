/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gisyritys.graphics;

import com.gisyritys.logic.Grid;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author Jussi
 */
public class Stats {
    private Grid playerGrid;
    private Grid botGrid;
    
    public Stats(Grid p, Grid b ){
        playerGrid = p;
        botGrid = b;
        
    }
    public BorderPane getStatsPane(){
        BorderPane stats = new BorderPane();
        String labelText = "Tilastot: " +"\n" + "" + "\n";
        for(String amount: checkGrids() ){
            labelText = labelText + amount +"\n"; 
        }
        Label label = new Label(labelText);
        stats.setCenter(label);
        return stats;
        
    }
    public String[] checkGrids(){
        int[] player = playerGrid.gridCheckerStats();
        int[] bot = botGrid.gridCheckerStats();
        
        String[] list = new String[8];
        list[0] = "Omia laivaruutuja jäljellä: " + player[1];
        list[1] = "Laivoja alunperin: " + player[0];
        list[2] = "Meriruutuja: " +player[2];
        list[3] = "Arvattuja ruutuja: " + player[3] + "\n" + "" + "\n" + "----------------------------------------------------------" + "\n" +"" ;
        list[4] = "Vihollisen laivaruutuja jäljellä: " +bot[1];  
        list[5] = "Vihollisen laivoja alunperin: " + bot[0];
        list[6] = "Vihollisen meriruutuja: " + bot[2];
        list[7] = "Vihollisen arvaamia ruutuja : " + bot[3];
        
        return list;
    }
    
           
         
}
