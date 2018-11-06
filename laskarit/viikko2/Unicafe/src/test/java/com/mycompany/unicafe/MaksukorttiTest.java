package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }
    
    @Test
    public void kortinSaldoAlussaOikein(){
        assertEquals(10, kortti.saldo());
    }
    
    @Test
    public void rahanLataaminenKasvattaaSaldoaOikein(){
        kortti.lataaRahaa(10);
        assertEquals("saldo: 0.20", kortti.toString());
    }
    @Test
    public void rahanOttaminenToimii(){
        Boolean first = kortti.otaRahaa(1);
        assertEquals("saldo: 0.9", kortti.toString());
        Boolean second = kortti.otaRahaa(10);
        assertEquals("saldo: 0.9", kortti.toString());
        assertEquals(true, first);
        assertEquals(false, second);
        
           
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
}
