# Zaawansowane Technologie Internetowe

## Spring Boot - zadanie domowe

W ramach zadania domowego rozwijać będziemy aplikację stanowiąca bazę przykładów zaprezentowanych w trakcie seminarium. Punkt wyjścia stanowić będzie przykład **4**. Celem ćwiczenia będzie:
 * uruchomienie projektu na dostępnych w ramach kursu maszynach wirtualnych
 * dodanie do aplikacji obsługi edycji i usuwania rekordów
 * dodanie do aplikacji obsługi Spring Security
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



Otwieramy przeglądarkę i wypisujemy:
```
http://localhost:8095/
```
W tym momencie pojawi się strona główna naszej aplikacji bazowej.


### Dodanie do aplikacji obsługi edycji i usuwania rekordów

### Dodanie do aplikacji obsługi Spring Security

Aby dodać do aplikacji obsługę Spring Security należy:

1.  Dodać do projektu dependencję spring-boot-starter-security.

        <dependency>
         <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-starter-security</artifactId>
        </dependency>

2.  Stworzyć tabelę bazodanową korzystając np. z serwisu DBaaS ElephantSQL.

W bazie powinny się znaleźć następujące tabele:

 *  tabela reprezentująca użytkownika z jego danymi, takimi jak nazwa oraz hasło,
 *  tabela reprezentująca rolę użytkownika zawierająca nazwę użytkownika oraz jego rolę np. user, admin.
    
Dane o bazie danych należy zawrzeć w pliku application.properties, przykładowo:

    spring.datasource.url=jdbc:postgresql://localhost/testdb
    spring.datasource.username=postgres
    spring.datasource.password=123

3. Nadpisać automatyczną konfigurację Spring Security tak jak pokazano w przykładzie SpringSecurityJDBCAuthenticationPostgreSQL. 

        public class SecurityConfig extends WebSecurityConfigurerAdapter { 

         @Autowired
        	DataSource dataSource;
 
	        @Autowired
	        public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
             ...
	        }
 
          @Override
	        protected void configure(HttpSecurity http) throws Exception {
	        	...
	        }
        }

### Dodanie do aplikacji testów

1. Dodać do projektu dependencję spring-boot-starter-test.

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
            <version>2.1.6.RELEASE</version>
        </dependency>

2. Przetestować aplikację pod względem poprawności działania autoryzacji użytkownika stosując adnotację

       @SpringBootTest 
       
(na podstawie przykładu testów SpringSecurityJdbcAuthenticationPostgreSqlApplicationTests.java umieszczonych w projekcie        SpringSecurityJDBCAuthenticationPostgreSQL).

3. Przetestować aplikację bez podnoszenia serwera Tomcat stosując MockMvc na podstawie przykładu testu SimpleControllerTest.java umieszczonego w projekcie SpringBootTesting.  
