package com.mycompany.unicafe;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


/**
 *
 * @author Jussi
 */
public class KassapaateTest {
    
    Kassapaate Kassa;
    
    
    @Before
    public void setUp() {
        Kassa = new Kassapaate();
        
    }
    @Test
    public void oikeatRahatJaMyynnit(){
        assertEquals(100000, Kassa.kassassaRahaa());
        assertEquals(0, Kassa.edullisiaLounaitaMyyty());
        assertEquals(0, Kassa.maukkaitaLounaitaMyyty());
                
    }
    @Test
    public void käteisNostoToimiiEdullinen(){
        int first = Kassa.syoEdullisesti(250);
        assertEquals(1, Kassa.edullisiaLounaitaMyyty());
        assertEquals(100240, Kassa.kassassaRahaa());
        assertEquals(10, first);
        int second = Kassa.syoEdullisesti(200);
        assertEquals(1, Kassa.edullisiaLounaitaMyyty());
        assertEquals(100240, Kassa.kassassaRahaa());
        assertEquals(200,second);
    }
    @Test
    public void käteisNostoToimiiMaukas(){
        int first = Kassa.syoMaukkaasti(410);
        assertEquals(1, Kassa.maukkaitaLounaitaMyyty());
        assertEquals(100400, Kassa.kassassaRahaa());
        assertEquals(10, first);
        int second = Kassa.syoMaukkaasti(200);
        assertEquals(1, Kassa.maukkaitaLounaitaMyyty());
        assertEquals(100400, Kassa.kassassaRahaa());
        assertEquals(200,second);
    }
    @Test
    public void korttiOstoToimiiEdullinen(){
        Maksukortti kortti =  new Maksukortti(410);
        Boolean first = Kassa.syoEdullisesti(kortti);
        assertEquals(170,kortti.saldo());
        assertEquals(true,first);
        assertEquals(1,Kassa.edullisiaLounaitaMyyty());
        Boolean second = Kassa.syoEdullisesti(kortti);
        assertEquals(170,kortti.saldo());
        assertEquals(1,Kassa.edullisiaLounaitaMyyty());
        assertEquals(false, second);
        assertEquals(100000,Kassa.kassassaRahaa());
    }
    @Test
    public void korttiOstoToimiiMaukas(){
        Maksukortti kortti =  new Maksukortti(410);
        Boolean first = Kassa.syoMaukkaasti(kortti);
        assertEquals(10,kortti.saldo());
        assertEquals(true,first);
        assertEquals(1,Kassa.maukkaitaLounaitaMyyty());
        Boolean second = Kassa.syoMaukkaasti(kortti);
        assertEquals(10,kortti.saldo());
        assertEquals(1,Kassa.maukkaitaLounaitaMyyty());
        assertEquals(false, second);
        assertEquals(100000,Kassa.kassassaRahaa());
    }
    
    @Test
    public void kortilleLadatessaSaldoMuuttuuJaKassaKasvaa(){
        Maksukortti kortti =  new Maksukortti(0); 
        Kassa.lataaRahaaKortille(kortti, 100);
        assertEquals(kortti.saldo(), 100);
        assertEquals(Kassa.kassassaRahaa(),100100);
        
    }
    @Test
    public void KortilleEiVoiLadataMiinusta(){
        Maksukortti kortti =  new Maksukortti(0); 
        Kassa.lataaRahaaKortille(kortti, -100);
        assertEquals(kortti.saldo(), 0);
        assertEquals(Kassa.kassassaRahaa(),100000);
        
    }
          
    
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
