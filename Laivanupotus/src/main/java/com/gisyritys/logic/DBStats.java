/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gisyritys.logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * Luokka tietokannan kanssa toimintaa, mahdollistaa luonnin, lisäyksen ja
 * tiedon hakemisen
 */
public class DBStats {

    /**
     * Luo tietokannan ja siihen taulun
     *
     * @param
     *
     * @return
     */
    public void createDB() {
        String url = "jdbc:sqlite:stats.db";
        Statement stmt = null;
        try (Connection conn = DriverManager.getConnection(url)) {
            stmt = conn.createStatement();
            String query = "CREATE TABLE IF NOT EXISTS games "
                    + "(ownships int, "
                    + "ownremaining int, "
                    + "aiships int,"
                    + "airemaining int, "
                    + "turns int)";

            stmt.executeUpdate(query);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Lisää jotain tietokantaan Eli periaatteessa siis viimeksi pelatun pelin
     * tiedot
     *
     * @param int[] joka sisältää pelin tiedot
     *
     * @return
     */

    public void addToDB(int[] list) {
        String url = "jdbc:sqlite:stats.db";
        Statement stmt = null;
        try (Connection conn = DriverManager.getConnection(url)) {
            stmt = conn.createStatement();
            String query = "INSERT INTO games "
                    + "(ownships, ownremaining, aiships, airemaining, turns) VALUES ("
                    + list[1] + ", "
                    + list[0] + ", "
                    + list[5] + ", "
                    + list[4] + ", "
                    + list[3] + ")";
            stmt.executeUpdate(query);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Hakee kaikkien pelien tiedot tietokannasta
     *
     * @param
     *
     * @return ArrayList<int[]> Jossa kaikki pelit arraylistissä ja niiden
     * tarkemmat tiedot Arrayssä
     */
    public ArrayList<int[]> getDB() {
        String url = "jdbc:sqlite:stats.db";
        Statement stmt = null;
        ArrayList<int[]> games = new ArrayList<int[]>();
        try (Connection conn = DriverManager.getConnection(url)) {

            stmt = conn.createStatement();
            String query = "SELECT "
                    + "ownships, "
                    + "ownremaining, "
                    + "aiships,"
                    + "airemaining, "
                    + "turns "
                    + "FROM "
                    + "games";

            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int[] list = new int[5];
                list[0] = rs.getInt("ownships");
                list[1] = rs.getInt("ownremaining");
                list[2] = rs.getInt("aiships");
                list[3] = rs.getInt("airemaining");
                list[4] = rs.getInt("turns");
                games.add(list);
                
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return games;
    }

}
