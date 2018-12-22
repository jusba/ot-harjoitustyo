#  Arkkitehtuurikuvaus

## Rakenne

Ohjelman pakkausrakenne on kaksitasoinen:  

- Graafisen puolen hoitavaa com.gisyritys.graphic pakkauksen koodi.  
- Loogisen puolen taas hoitaa com.gisyriys.logic pakkauksen koodi.  
![Pakkaus](https://github.com/jusba/ot-harjoitustyo/blob/master/Dokumentaatio/Images/Pakkauskaavio2_0.JPG)

## Käyttöliittymä  

Ohjelmassa on viisi erilaista näkymää.
- Päävalikko
- Laivanasetusvalikko
- Pelivalikko
- Pelinjälkeiset tilastot valikko
- Tilastot valikko

Jokainen näistä on toteutettu omana Scene oliona. Käyttöliittymässä pääsee liikkumaan ympäri takaisin päävalikkoon, joten ohjelman sulkeminen esimerkiksi pelien välissä ei ole välttämätöntä. Sovelluksen käyttöliittymä ja sovelluslogiikka on eriytetty toisistaan, mutta ohjelman ollessa hyvin paljon graafiseen toimintaan perustuva, tapahtuu osa toiminnasta myös graafisissa luokissa. Tätä korjaillaan mahdollisesti aikataulun sitä salliessa.

## Tietojen tallennus 
Luokka DBStats hoitaa tietojen hakemisen ja viemisen tietokantaan. Tietokantatiedosto stats.db luodaan ohjelman ensimmäiselle käyttökerralla. Se sijaintsee samassa kansiossa ohjelman suorittavan Jar tiedoston kanssa.  
Ohjelman tarvitsema taulu games luodaan seuraavalla lauseella:    
`CREATE TABLE IF NOT EXISTS games ownships int, ownremaining int, aiships int, airemaining int, turns int)`

Lisättäessä tietoja tietokantaan, ei ole suoraan estetty SQL-injenktion mahdollisuutta. Kuitenkaan ohjelmassa ei ole minkäänlaista käyttäjän syötetty klikattavia ruutuja lukuun ottamatta, joten injektio ei ole mahdollinen.  

Tietojen lisäys tietokantaan hoidetaan seuraavalla lauseella:  
`INSERT INTO games (ownships, ownremaining, aiships, airemaining, turns) VALUES ( ?, ?, ?, ?, ?)`

Tietokannasta haettaessa tietoa sieltä haetaan aina kaikki tiedot, mitkä lisätään listarakenteeseen esittämistä varten.  

Tietojen haku tietokannasta tapahtuu seuraavalla lauseella:  
`SELECT ownships, ownremaining, aiships, airemaining, turns FROM games`

## Sovelluslogiikka

Ohjelman loogisen toiminnallisuuden toteuttaa Grid luokka. Se on kahden sisäkkäisen Arrayn muodostama 2D gridi, mihin koko peli perustuu. Pelaajan gridi luodaan graafisista luokista saatavien arvojen (klikkausten) perusteella sellaisiksi kuin halutaan. Tietokoneelle luodaan oma satunnainen gridi pelin sääntöjen mukaan randomGrid() metodilla. Grid luokassa on myös gridin tarkastukseen liittyviä metodeja, millä tarkastetaan esimerkiksi onko siinä vielä laivoja (checkGrid(), jonka avulla tarkastetaan loppuuko peli) tai luodaan tilastoja (gridCheckerStats() auttaa tilastoluokkia tilastovalikoiden luomisessa). Myös tietokonepelaajan toimintaan liittyviä asioita toteutetaan paljon grid luokan metodeilla.

Gridin "ruuduissa" eli Arrayiden kohdissa on Location luokan objekteja. Nämä kuvaavat yhtä ruutua. Tässä luokassa muutetaan yksittäisten ruutujen statusta

Jokaisessa ruudussa myös joko on tai ei ole Ship luokan objektia, mikä kuvaa siinä olevaa laivaa.

## Toiminnallisuus
#### Uuden laudan luonti
Uusi pelilauta luodaan Board luokassa, mikä palauttaa BorderPane olion Mainille itse pelissä käytettäväksi.

![Sekvenssikaavio](https://github.com/jusba/ot-harjoitustyo/blob/master/Dokumentaatio/Images/Board_valikon_toiminta.png)

#### Pelin toiminnallisuus

Pelin toiminta on toteutettu Game luokan sisällä, mikä hakee BotGame luokasta tietokoneen lautaa kuvaavan BorderPanen ja yhdistää sen omaansa. Tämä BorderPane taas palautetaan Main luokalle.

![Pelin_toiminta](https://github.com/jusba/ot-harjoitustyo/blob/master/Dokumentaatio/Images/pelin_toiminta.png?raw=true)
                    
## Ohjelman parannettavia kohteita  

#### Sovelluslogiikan ja graafisen puolen eriyttämisen ongelmat  

Ohjelman graafisissa luokissa toteutetaan liikaa sovelluslogiikan toimintaa. Sovelluslogiikan pitäisi tapahtua useammassa omassa luokassaan sen sijaan, että sitä on tungettu graafisiin luokkiin. Etenkin Game ja BotGame luokat pahimpia loukkaajia tässä asiassa. Ohjelman rakenne olisi pitänyt suunnitella paremmin alunperin, jotta tälläisiltä ongelmilta vältyttäisiin.  

#### Rakenteen ongelmat

Sovelluksen rakenne on muuteenkin liian väärä. Sitä tulisi eriyttää enemmän useampaan luokkaan ja metodiin. Nyt ohjelmassa liian pitkiä metodeja ( randomGrid() metodi alunperin noin 400 riviä, tiivistetty nyt hieman alle 100) ja luokkia. Ongelmia on pyritty korjaamaan   tunkemalla Grid luokkaan liian monta toiminnallisuuden osa-aluetta, jolloin siitä on tullut huomattavasti liian pitkä ja monimutkainen. Myös monet painikkeet ja käyttöliittymäkomponentit voitaisiin hakea useammasta metodista yhden pitkän sijaan.

#### Hyvien ohjemointikäytäntöjen vastainen toiminta.
  
Edelliset ongelmat ovat periaatteessa osa tätä, mutta myös tähän on omia ongelmiaan. Esimerkiksi Main luokka on rakennettu väärin alunperin, minkä takia siinä muokataan vielä käyttöliittymäkomponentteja. Tämä olisi tullut toteuttaa alunperin periyttämällä BorderPanea graafisille luokille, jotta nämä voisivat lisätä kaikki omat nappinsa.

#### Tekoäly
  
Ohjelman "tekoäly" on varsin viime hetkillä lisätty tuotus. Sitä ennen tietokoneen peli perustui vain ruutujen arpomiseen. Tekoälyn lisäämisen yhteydessä tietokonepelaajan vaikeusaste kasvoi ainakin jonkun verran. Tekoälyn koodissa on kuitenkin ongelmia. Se on toteutettu liian lähellä graafista BotGame luokkaa, sekä se on varsin buginen, minkä takia tietokone valitsee usein vääriä ruutuja. Tämä olisi mahdollista korjata eriyttämällä tietokoneen toiminta paremmin omaksi luokakseen erossa graafisesta ja jatkokehittämällä ja debuggaamalla sen tietokonepelaajan toimintaa.

#### Graafinen ulkoasu

Ulkoasultaan ohjelma on hyvin vaatimaton, toisaalta tämä on hyvä asia, sillä kaikki on varsin simppeliä ja helposti sisäistettävää, kun monimutkaiset komponentit puuttavat. Toisaalta taas ulkoasu on tärkeä asia pelin kiinnostavuuden kannalta, joten tätä tulisi parantaa. Varsin nopeana korjauksena graafisten komponenttien välille voisi lisätä hieman paddingia, sekä ruutujen tylsien värivalintojen tilalla voisi lisätä nopeasti tehtyjä graafisia spritejä. 

#### Puuttuvat lisäominaisuudet

Ohjelman lisäominaisuudet jäivät lopulta varsin vajaiksi, johtuen kehityksen yllättävistä viiveistä. Koko projekti olisi todennäköisesti ollut helpompi toteuttaa, jos sitä olisi lähdetty rakentamaan kaksinpelinä alunperin. Nyt tietokoneen toimintaan liittyvät asiat veivät liikaa aikaa kokonaismäärästä, minkä takia monet ominaisuudet jäivät vajaiksi.



                    
                    
                     


                    
                    
                    
                    
                    
                     

