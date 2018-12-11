/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gisyritys.testing;


import com.gisyritys.logic.DBStats;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author torkjuss
 */
public class DBStatsTest {
    
    
    DBStats db;
    
    
    @Before
    public void setUp() {
        db = new DBStats();
    }
    @Test
    public void dbTableGetsCreated(){
        String url = "jdbc:sqlite:stats.db";
        Statement stmt = null;
        try (Connection conn = DriverManager.getConnection(url)){
            stmt = conn.createStatement();
            String sql = "DROP TABLE games";
            stmt.executeUpdate(sql);
                
            
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            
        }
        
        db.createDB();
        
        try (Connection conn = DriverManager.getConnection(url)){
            DatabaseMetaData meta = conn.getMetaData();
            
            ResultSet res = meta.getTables(null, null, "games", 
            new String[] {"TABLE"});
            while (res.next()) {
                assertEquals("games",res.getString("TABLE_NAME"));
                assertEquals("TABLE",res.getString("TABLE_TYPE"));
                
                
            }
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            assertEquals(true, false);
        }
        
        
    }
    @Test
    public void addingAndGettingWorks(){
        String url = "jdbc:sqlite:stats.db";
        Statement stmt = null;
        try (Connection conn = DriverManager.getConnection(url)){
            stmt = conn.createStatement();
            String sql = "DROP TABLE games";
            stmt.executeUpdate(sql);
                
            
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            
        }
        
        db.createDB();
        int[] list = new int[6];
        list[1] = 1;
        list[0] = 0;
        list[5] = 5;
        list[4] = 4;
        list[3] = 3;
        db.addToDB(list);
        ArrayList<int[]> returns = db.getDB();
        assertEquals(returns.get(0)[0],1);
        assertEquals(returns.get(0)[1],0);
        assertEquals(returns.get(0)[2],5);
        assertEquals(returns.get(0)[3],4);
        assertEquals(returns.get(0)[4],3);
        int[] list2 = new int[6];
        list2[1] = 10;
        list2[0] = 10;
        list2[5] = 10;
        list2[4] = 10;
        list2[3] = 10;
        db.addToDB(list2);
        returns = db.getDB();
        assertEquals(returns.get(1)[0],10);
        assertEquals(returns.get(1)[1],10);
        assertEquals(returns.get(1)[2],10);
        assertEquals(returns.get(1)[3],10);
        assertEquals(returns.get(1)[4],10);
        
    }
    
    

    
}
