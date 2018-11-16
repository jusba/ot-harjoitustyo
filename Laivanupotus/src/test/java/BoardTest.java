/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.gisyritys.laivanupotus.Board;
import com.gisyritys.laivanupotus.Grid;
import com.gisyritys.laivanupotus.Location;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jussi
 */
public class BoardTest {
    
    Board board;
   
    
    @Before
    public void setUp() {
        board = new Board();
    }
    @Test
    public void gridGetsCreated(){
        
        assertEquals((board.getBoard() instanceof Grid), true);
    }
    @Test
    public void boardGetsCreated(){
        assertEquals((board instanceof Board), true);
    }
    @Test
    public void gridSizeRight(){
        int x = board.getBoard().getXSize();
        int y = board.getBoard().getYSize();
        int sum = 0;
        for(int i=0; i<board.getBoard().getGrid().length; i++) {
            for(int j=0; j<board.getBoard().getGrid()[i].length; j++) {
                sum++;
            }
        
        }
        assertEquals(sum,(y*x));
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
