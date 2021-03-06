# Ohjelmistotekniikka harjoitustyö

## Laivanupotuspeli

Laivanupotuspeli on perinteinen lautapeli, mikä toteutetaan tässä sovelluspohjaisessa muodossa. Projekti toteutettiin ohjelmistotekniikka 2018 kurssia varten. Pelissä on mahdollisuus pelata laivanupotuspeliä tietokonetta vastaan, eli asettaa omat laivansa haluttuihin kohtiin, sekä yrittää tuhota vastustajan laivat. Pelaaja voittaa jos hän tuhoaa vastustajan laivat ennen kuin hänen omansa tuhotaan.
  
Pelin on pelattavissa ja sen perusominaisuudet toimivat.
### Dokumentaatio

- [Ajankäyttö](https://github.com/jusba/ot-harjoitustyo/blob/master/Dokumentaatio/ajankaytto.md)
- [Vaatimusmäärittely](https://github.com/jusba/ot-harjoitustyo/blob/master/Dokumentaatio/Vaatimusm%C3%A4%C3%A4rittely.md)
- [Arkkitehtuurikuvaus](https://github.com/jusba/ot-harjoitustyo/blob/master/Dokumentaatio/arkkitehtuuri.md)
- [Käyttöohje](https://github.com/jusba/ot-harjoitustyo/blob/master/Dokumentaatio/kayttohje.md)
- [Testausdokumentti](https://github.com/jusba/ot-harjoitustyo/blob/master/Dokumentaatio/testaus.md)
- [Ohjelman parannettavia kohteita](https://github.com/jusba/ot-harjoitustyo/blob/master/Dokumentaatio/arkkitehtuuri.md#ohjelman-parannettavia-kohteita)

### Releaset
- [Viikko 7](https://github.com/jusba/ot-harjoitustyo/releases/tag/viikko7)
- [Viikko 6](https://github.com/jusba/ot-harjoitustyo/releases/tag/Viikko6)
- [Viikko 5](https://github.com/jusba/ot-harjoitustyo/releases/tag/viikko5)



### Komentorivikomennot
Komennot suoritetaan sovelluksen pääkansiossa

#### Testaus
##### Testit  
Komento:  
`mvn test`  
##### Testikattavuus  
Komento:  
`mvn jacoco:report`  
Testikattavuusraportti löytyy sovelluksen kansiosta target/site/jacoco/index.html

#### Jarin generointi
Komento:  
`mvn package`  
Generoitu jar-tiedosto löytyy target kansiosta (Laivanupotus-1.0-SNAPSHOT)  

#### Checkstyle tarkastus
Komento:  
`mvn jxr:jxr checkstyle:checkstyle`    
Checkstyle virheet löytyy sovelluksen kansiosta target/site/checkstyle.html  

#### JavaDocin luonti
Komento:  
`mvn javadoc:javadoc`    
Luotu JavaDoc löytyy kansiosta target/site/apidocs/index.html

