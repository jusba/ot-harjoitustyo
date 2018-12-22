# Testausdokumentti

### Testaus

#### Sovelluslogiikka
Ohjelman testit testaavat sovelluslogiikkaa, suurin osa etenkin Grid luokan toimintoja. Myös laudan tekemisen käyttöliittymäpuolelle on muutama testi (GridTest.java), mutta näitä ei kuitenkaan oletuksena ajeta. Testit testaavat metodien toimintaa varsin yksinkertaisesti, lähinnä tarkastaen palautettuja arvoja tietyin kriteerein.

#### Tiedon pysyväistallennus

###### HUOMIO: Myös tiedon tallennusta tarkistavat testit luovat tietokannan samaan hakemistoon ohjelman kanssa ( stats.db )
Ohjelman käyttämää tiedon pysyväistallennusta testataan sitä tarkistavilla testeillä. Testit tyhjentävät luomaansa tietokantataulua eri testien välissä uusilla statementeilla.

#### Testikattavuus
Ilman käyttöliittymäkerrosta ohjelman testien rivikattavuus on 98% ja haaraumakattavuus 91%
![testikattavuus](https://github.com/jusba/ot-harjoitustyo/blob/master/Dokumentaatio/Images/testikattavuus.PNG?raw=true)  

Jatkokehitysideana testaukseen, ohjelmassa tulisi todennäköisesti olla tämänhetkisiä käyttöliittymäluokkia koskevia testejä, sille ne suorittavat paljon myös ohjelman toimintaan liittyviä asioita.  

### Järjestelmätestaus
Suoritettu manuaalisesti  

#### Asennus

Ohjelman uusinta versiota on haettu ja sitä on ajettu [käyttöohjeen](https://github.com/jusba/ot-harjoitustyo/blob/master/Dokumentaatio/kayttohje.md) perusteella Windows-ympäristössä. Aikaisempia releaseja on ajettu myös Linux-ympäristössä, joten toimiminen siellä on myös oletettavaa. 

Ohjelma toteuttaa kaikki [vaatimusmäärittelyssä](https://github.com/jusba/ot-harjoitustyo/blob/master/Dokumentaatio/Vaatimusm%C3%A4%C3%A4rittely.md) ilmoitetut toiminnallisuudet, paitsi mahdolliset lisäominaisuudet

Ohjelman vaihtoehtoinen asennus tapahtuu kloonaamalla tämän repositorion sisältö hakemistoon ja ajamalla ohjelman Main luokkaa esimerkiksi ohjelmointiympäristön kautta.
