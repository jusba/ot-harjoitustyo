# Käyttöohje

### Aloitus
Lataa [Laivanupotus.jar](https://github.com/jusba/ot-harjoitustyo/releases/download/Viikko6/Laivanupotus.jar)
Ohjelma luo tietokantatiedoston stats.db samaan kansioon itsensä kanssa ensimmäisen käynnistyksen yhteydessä.  

Ohjelma käynnistyy komentoriviltä komennolla:  
`java -jar Laivanupotus.jar` 

### Käyttö
#### (Mahdolliset kuvat tulee myöhemmin, sillä graafinen ulkoasu varmaan muuttuu vielä hieman)  

#### Päävalikko
Käynnistyessään ohjelma siirtyy päävalikkoon, mistä pääsee painikkeita painamalla aloittamaan uuden pelin tai katsomaan tilastoja.

#### Laivanasetusvalikko
Aloittamalla päävalikossa uuden pelin siirtyy kuva laivanasetusvalikkoon. Tässä valikossa asetetaan pelaajan laivat pelilaudalle. Laivat asetetaan klikkaamalla ruutuja hiiren vasemmalle painikkeella. Kirjoitushetkellä palojen sijoitusta ei ole rajoitettu, mutta olisi suotavaa jos ne laitettaisiin pelin yleisten sääntöjen mukaan (kts. [wikipedia](https://fi.wikipedia.org/wiki/Laivanupotus)). Jo laitettuja paloja voi poistaa hiiren oikealla painikkeella. Ylhäällä näkyy jäljellä olevien laivapalojen määrä. Kun paloja on laitettu tarpeeksi, jatka peliä painamalla valmis.

#### Pelivalikko
Laivanasetusvalikosta peli siirtyy varsinaiseen pelivalikkoon. Tässä valikossa on kaksi ruudukkoa, vasemmanpuoleisessa on pelaajan laivat ja oikeanpuolimmaisessa tietokoneen. Peli on käynnissä niin kauan kuin ylhäällä lukee siitä ilmoittava teksti. Pelaajan omat laivat ovat hänen ruudukossaan tumman harmaina.

Pelivalikossa peli etenee vuorotellen. Ihmispelaaja aloittaa klikkaamalla satunnaista ruutua oikeanpuolimmaisesta eli tietokoneen ruudukosta. Ruudun väri muuttuu tilanteen mukaan. Osuessaan mahdollisesti tietokoneen laivaan, ruutu muuttuu oranssiksi. Ohi menneen laukauksen jälkeen ruutu muuttuu vaaleammansiniseksi. Pelaajan valittua ruudun tietokone tekee oman valintansa ja tilanne päivittyy samoilla väreillä myös pelaajan ruudukossa. 

Peli on käynnissä niin kauan, kuin jommallakummalla on vielä tuhoutumattomia laivaruutuja jäljellä. Jos jommankumman pelaajan laivaruudut loppuvat, muuttuu yläreunan peli käynnissä teksti tilannetta kuvaavaksi. Tämän jälkeen ruutuja ei voi enään valita ja pelaaja pääsee seuraavaan valikkoon lopeta peli painikkeella.

#### Pelinjälkeiset tilastot
Pelaajan lopetettua pelin siirtyy näkymä pelinjälkeisiin tilastoihin. Tässä näkyy tilastoja edellisen pelin tuloksista. Pelinjälkeisistä tilastoista siirrytään takaisin päävalikkoon siitä kertovan painikkeen avulla.

#### Tilastot
Painettaessa päävalikossa tilastot painiketta, pääsee pelaaja tarkastelemaan edellisen 50 pelin tuloksia. Tulokset haetaan tietokannasta joka luodaan pelin käynnistyessä, eli se on tyhjä jos myöskään pelejä ei ole pelattu. Tilastovalikosta pääsee takaisin päävalikkoon painikkeella.


