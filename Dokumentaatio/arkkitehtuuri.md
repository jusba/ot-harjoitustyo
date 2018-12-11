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

Ohjelman loogisen toiminnallisuuden toteuttaa Grid luokka. Se on kahden sisäkkäisen Arrayn muodostama 2D gridi, mihin koko peli perustuu. Pelaajan gridi luodaan graafisista luokista saatavien arvojen (klikkausten) perusteella sellaisiksi kuin halutaan. Tietokoneelle luodaan oma satunnainen gridi pelin sääntöjen mukaan randomGrid() metodilla. Grid luokassa on myös gridin tarkastukseen liittyviä metodeja, millä tarkastetaan esimerkiksi onko siinä vielä laivoja (checkGrid(), jonka avulla tarkastetaan loppuuko peli) tai luodaan tilastoja (gridCheckerStats() auttaa tilastoluokkia tilastovalikoiden luomisessa).

Gridin "ruuduissa" eli Arrayiden kohdissa on Location luokan objekteja. Nämä kuvaavat yhtä ruutua. Tässä luokassa muutetaan yksittäisten ruutujen statusta

Jokaisessa ruudussa myös joko on tai ei ole Ship luokan objektia, mikä kuvaa siinä olevaa laivaa.

## Toiminnallisuus

![Sekvenssikaavio](https://github.com/jusba/ot-harjoitustyo/blob/master/Dokumentaatio/Images/Board_valikon_toiminta.png)
                    
## Ohjelman parannettavia kohteita  

- Liian monen asian toteutus graafisissa luokissa. Toiminnan pitäisi tapahtua enemmän loogisissa luokissa.
- Main luokan ahtaminen täyteen erilaisen toteutustavan sijaan.
- Sovellusrakennetta pitäisi eriyttää enemmän metodeihin ja mahdollisesti luokkiin.
                     
                    
                    
                     


                    
                    
                    
                    
                    
                     

