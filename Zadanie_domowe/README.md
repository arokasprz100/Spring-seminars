# Zaawansowane Technologie Internetowe

## Spring Boot - zadanie domowe

W ramach zadania domowego rozwijać będziemy aplikację stanowiąca bazę przykładów zaprezentowanych w trakcie seminarium. Punkt wyjścia stanowić będzie przykład **4**. Celem ćwiczenia będzie:
 * uruchomienie projektu na dostępnych w ramach kursu maszynach wirtualnych
 * dodanie do aplikacji obsługi edycji i usuwania rekordów
 * dodanie do aplikacji testów

### Uruchomienie projektu w środowisku pracowni
W celu sklonowania projektu, w środowisku pracowni, w wybranym przez siebie katalogu, wykonujemy polecenie:
```
git clone https://github.com/arokasprz100/Spring-seminars/
```
Następnie uruchamiamy narzędzie STS za pomocą polecenia:
```
/opt/sts/SpringToolSuite4 
```
Aby zaimportować projekt, wybieramy opcje `File` > `Open Projects from File System` > `Directory`. Następnie wskazujemy katalog zawierający przykład nr 4 i naciskamy `Finish`. 

Następnie naciskamy prawym przyciskiem myszy na projekt, wybieramy: `Maven` > `Update project`. Odczekujemy chwilę i następnie uruchamiamy przykład: ponownie naciskamy prawym przyciskiem myszy na projekt, wybieramy `Run As` > `Spring Boot App`. 

Po uruchomieniu przykładu otwieramy przeglądarkę i wypisujemy:
```
http://localhost:8095/
```
W tym momencie pojawi się strona główna naszej aplikacji bazowej.


### Dodanie do aplikacji obsługi edycji i usuwania rekordów


### Dodanie do aplikacji testów

1. Dodać do projektu dependencję spring-boot-starter-test.
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
    <version>2.1.6.RELEASE</version>
</dependency>
```
2. Przetestować aplikację pod względem poprawności działania autoryzacji użytkownika stosując adnotację

       @SpringBootTest 
       
(na podstawie przykładu testów SpringSecurityJdbcAuthenticationPostgreSqlApplicationTests.java umieszczonych w projekcie        SpringSecurityJDBCAuthenticationPostgreSQL).

3. Przetestować aplikację bez podnoszenia serwera Tomcat stosując MockMvc na podstawie przykładu testu SimpleControllerTest.java umieszczonego w projekcie SpringBootTesting.  
