# Testausdokumentti

### Testaus

#### Sovelluslogiikka
Ohjelman testit testaavat sovelluslogiikkaa, suurin osa etenkin Grid luokan toimintoja. Myös laudan tekemisen käyttöliittymäpuolelle on muutama testi (GridTest.java), mutta näitä ei kuitenkaan oletuksena ajeta. Testit testaavat metodien toimintaa varsin yksinkertaisesti, lähinnä tarkastaen palautettuja arvoja tietyin kriteerein.

#### Tiedon pysyväistallennus

###### HUOMIO: Myös tiedon tallennusta tarkistavat testit luovat tietokannan samaan hakemistoon ohjelman kanssa ( stats.db )
Ohjelman käyttämää tiedon pysyväistallennusta testataan sitä tarkistavilla testeillä. Testit tyhjentävät luomaansa tietokantataulua eri testien välissä uusilla statementeilla.

#### Testikattavuus
