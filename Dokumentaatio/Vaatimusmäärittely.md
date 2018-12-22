# Vaatimusmäärittely

### Sovelluksen tarkoitus

Sovellus on kaikille varmaan varsin tuttu [laivanupotuspeli](https://fi.wikipedia.org/wiki/Laivanupotus).

### Sovelluksen toiminnallisuudet

##### Päävalikko
- Pelaaja voi avata päävalikosta uuden pelin tai siirtyä tarkastelemaan edellisten pelien tilastoja

##### Laivanasetusvalikko
- Uuden pelin avatessa avautuu laivanasetusvalikko ja pelaaja saa asettaaa laivansa pelilaudalle.
- Oletuksena on, että pelaaja tottelee kiltisti normaalin lautapeliversion sääntöjä.
- Kun pelaaja on asettanut mielestään tarpeeksi laivoja, siirtyy peli pelivalikkoon.

##### Pelivalikko
- Peli etenee vuorotellen pelaajan ja tietokoneen valitessa ruutuja.
- Kummankin vuorolla näkyy vastustajan aluetta kuvaava ruudukko
- Pelaaja valitsee ruutuja, joissa vastustajan laivat mahdollisesti ovat.
- Valittuaan ruudun ruudun kuvake muuttuu joko osumaa kuvaavaksi tai hutia kuvaavaksi.
- Kun jomman kumman pelaajan kaikki laivaruudut on tuhottu, peli loppuu ja voittajan nimi näkyy ikkunassa.
- Tästä voi siirtyä lopulta tulosvalikkoon

##### Tulosvalikko
- Valikossa näkyy käytettyjen vuorojen määrä, molempien pelaajien valittujen ruutujen ja osumien määrä.
- Tulosvalikosta siirrytään takaisin päävalikkoon

##### Edellisten pelien tulosvalikko
- Valikossa näkyy tietokannasta haettuja edellisten pelien tuloksia

### Mahdollisia lisätoiminnallisuuksia
- Kaksinpeli
- Tietokoneelle eri vaikeusasteita
- Tilastovalikko johon pääsee päävalikosta, mikä näyttää aikaisempien pelien tilastoja (toteutettu)
- Muutettava peliruudukon koko
- Muutettava laivaruutujen määrä
- Tietokonepelaajan laivojen sijaintien näkyminen pelin lopuksi
- Laivojen kokonaan tuhoutumisen merkkaaminen jotenkin
- Lisää tilastoja

### Toiminnallisuuteen liittyviä rajoitteita
- Toimivuus ainakin Windows ja Linux koneissa (Projekti toteutetaan Windows pohjaisella käyttäjärjestelmällä, sekä mahdollisesti tilanteen sitä vaatiessa Virtualboxissa pyörivällä Ubuntulla.
- Ohjelmointikieli Java
- Ei verkkotoiminnallisuuksia
- Tilastojen tallennus tapahtuu paikallisesti

##### Ohjelman tekijä varaa oikeuden muokata tätä dokumenttia siitä etukäteen ilmoittamatta
