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
        int shipAmount1 = 0;
        int floatAmount1 = 0;
        int seaAmount1 = 0;
        int guessed1 = 0;
        for (int i = 0; i < playerGrid.getGrid().length; i++) {
            for (int j = 0; j < playerGrid.getGrid()[i].length; j++) {
                if(playerGrid.getGrid()[i][j].hasShip()){
                        shipAmount1 ++;
                    if(playerGrid.getGrid()[i][j].getShip().getStatus()){
                        floatAmount1 ++;
                        
                    }
                }
                if(!playerGrid.getGrid()[i][j].hasShip()){
                    seaAmount1 ++;
                }
                if(playerGrid.getGrid()[i][j].getGuessed()){
                    guessed1 ++;
                }
                
                
            }

        }
        int shipAmount2 = 0;
        int floatAmount2 = 0;
        int seaAmount2 = 0;
        int guessed2 = 0;
        for (int i = 0; i < botGrid.getGrid().length; i++) {
            for (int j = 0; j < botGrid.getGrid()[i].length; j++) {
                if(botGrid.getGrid()[i][j].hasShip()){
                        shipAmount2 ++;
                    if(botGrid.getGrid()[i][j].getShip().getStatus()){
                        floatAmount2 ++;
                        
                    }
                }
                if(!botGrid.getGrid()[i][j].hasShip()){
                    seaAmount2 ++;
                }
                if(botGrid.getGrid()[i][j].getGuessed()){
                    guessed2 ++;
                }
                
                
            }

        }
        String[] list = new String[8];
        list[0] = "Omia laivaruutuja jäljellä: " + floatAmount1;
        list[1] = "Laivoja alunperin: " + shipAmount1;
        list[2] = "Meriruutuja: " +seaAmount1;
        list[3] = "Arvattuja ruutuja: " + guessed1 + "\n" + "" + "\n" + "----------------------------------------------------------" + "\n" +"" ;
        list[4] = "Vihollisen laivaruutuja jäljellä: " +floatAmount2;  
        list[5] = "Vihollisen laivoja alunperin: " + shipAmount2;
        list[6] = "Vihollisen meriruutuja: " + seaAmount2;
        list[7] = "Vihollisen arvaamia ruutuja : " + guessed2;
        
        return list;
    }
           
         
}
