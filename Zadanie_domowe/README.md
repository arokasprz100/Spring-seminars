# Zaawansowane Technologie Internetowe

## Spring Boot - zadanie domowe

W ramach zadania domowego rozwijać będziemy aplikację stanowiąca bazę przykładów zaprezentowanych w trakcie seminarium. Ponieważ w czasie prezentacji skupiliśmy się na działaniu Spring Boota, nie było możliwości przećwiczenia pisania aplikacji - zajmiemy się tym w ramach tego zadania. Podobne zadanie wykonywaliśmy już w ramach ćwiczeń laboratoryjnych. Punkt wyjścia stanowić będzie przykład **4**. Celem ćwiczenia będzie:
 * uruchomienie projektu na dostępnych w ramach kursu maszynach wirtualnych
 * dodanie do aplikacji obsługi usuwania rekordów
 * badanie działania aplikacji za pomocą narzędzia Spring Boot Actuator
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


### Dodanie do aplikacji obsługi usuwania rekordów
Na początek będziemy chcieli dodać do naszego modelu kilka pól (kolumny w tabeli bazy danych). Będą one odpowiadały za przechowywanie informacji o nazwie kursu, w ramach którego realizowany jest projekt, oraz o prowadzącym kursu. W tym celu edytujemy plik `Project.java` znajdujący się w pakiecie `com.zti.example4.project` tak, by znajdująca się tam klasa wyglądała jak poniżej:

```
@Entity
public class Project {
    
    private Long id;
    
    private String name;
    
    private String course;
    
    private String supervisor;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getCourse() {
        return course;
    }
    
    public void setCourse(String course) {
        this.course = course;
    }
    
    public String getSupervisor() {
        return supervisor;
    }
    
    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }
}
```

Następnie edytujemy istniejące szablony służące do wyświetlania oraz dodawania projektów. W tym celu w pliku `add-project.html` (szablon formularza do dodawania projektów) dodajemy w odpowiednim miejscu następujący kod:
```
<div class="form-group justify-content-center">
    <label for="course"> Course </label>
    <input type="text" th:field="*{course}" id="course" class="form-control" placeholder="Course">
</div>

<div class="form-group justify-content-center">
    <label for="supervisor"> Supervisor </label>
    <input type="text" th:field="*{supervisor}" id="supervisor" class="form-control" placeholder="Supervisor">
</div>
```
Kod ten odpowiada za dodanie dwóch dodatkowych pól do szablonu. Użyty został tutaj `Bootstrap` (np. `class="form-group justify-content-center"`). Analogicznie edytujemy szablon odpowiedzialny za wyświetlanie projektów (`list-projects.html`). W odpowiednim miejscu dodajemy tam kod: 
```
<th scope="col"> Course </th>
<th scope="col"> Supervisor </th>
```
oraz:
```
<td th:text="${project.course}"></td>
<td th:text="${project.supervisor}"></td>
```

W tym momencie przystępujemy do dodania operacji usuwania rekordu z bazy danych. Podobnie w odpowiednim miejscu w pliku `list-projects.html` dodajemy poniższy fragment kodu:
```
<th scope="col"> Actions </th>
```
oraz, w innym miejscu tego pliku:
```
<td><a th:href="@{/projects/{id}/delete(id=${project.id})}" th:text="Delete"></a></td>
```
Mamy tutaj przykład używanego przez Thymeleaf sposobu zapisu URL. Następnie dodajemy odpowiedni `endpoint` w kontrolerze odpowiedzialnym za projekty:
```
@GetMapping
@RequestMapping("/{id}/delete")
public String deleteProject(@PathVariable String id, Model model) {
    projectService.deleteById(Long.parseLong(id));
    model.addAttribute("id", id);
    return "delete-project-confirm";
}
```
Następnie w interfejsie `ProjectService` dodajemy deklarację metody:
```
void deleteById(Long id);
```
oraz jej implementację w klasie `ProjectServiceImpl`:
```
@Override
public void deleteById(Long id) {
    projectRepository.deleteById(id);
}
```
Należy tutaj zwrócić uwagę, że nie musieliśmy niczego dodawać w interfejsie `ProjectRepository`. Pozostało jeszcze stworzyć szablon `delete-project-confirm.html` w katalogu `templates` i dodać do niego następujący kod:
```
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Spring Boot example application</title>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"/>
</head>
<body class="text-center">
    <h1 class="bg-dark text-white p-3"> (Very) simple project manager </h1>
    
    <h2> Project with id: <span th:utext="${id}"></span> deleted.</h2>
    
    <ul class="list-group p-2">
        <li> <a th:href="@{/projects/}" class="list-group-item"> Go back to project list </a> </li>
    </ul>

</body>
</html>
```

Następnie testujemy zaimplementowaną funkcjonalność dodając i usuwając kilka rekordów. Projekt można oczywiście dowolnie sobie rozwinąć, np. dodać walidację wprowadzanych danych czy możliwość ich edycji. Po zakończeniu testów nie wyłączamy jeszcze aplikacji.


### Użycie narzędzia Spring Boot Actuator
W drugiej części zadania posłużymy się narzędziem Spring Boot Actuator. Mając uruchomiony projekt wpisujemy w wyszukiwarkę:
```
http://localhost:8095/actuator
```
w tym miejscu wyświetlają nam się wszystkie dostępne `endpointy`. Na początek sprawdźmy stan aplikacji, wybierając `endpoint` `health`:
```
http://localhost:8095/actuator/health
```
Jeśli aplikacja działa prawidłowo powinniśmy zobaczyć wiadomość `{"status":"UP"}`. Następnie będziemy chcieli zobaczyć historię wykonanych zapytań HTTP. W tym celu wpisujemy:
```
http://localhost:8095/actuator/httptrace
```
Szukamy tutaj wykonanych przez nas wcześniej operacji `delete`. Następnie sprawdzimy zawartość pliku z logami. W tym celu wpisujemy:
```
http://localhost:8095/actuator/logfile
```
Na koniec wyłączymy za pomocą Spring Boot Actuator naszą aplikację. Ponieważ w tym celu należy posłużyć się metodą POST, najprościej będzie to zrobić za pomocą narzędzia CURL:
```
curl -X POST http://localhost:8095/actuator/shutdown
```
Powinniśmy otrzymać odpowiedź `{"message":"Shutting down, bye..."}` a aplikacja powinna się wyłączyć.


### Dodanie do aplikacji testów

1. Aby móc testować aplikację w środowisku Spring Boot należy dodać do projektu dependencję spring-boot-starter-test.
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
    <version>2.1.6.RELEASE</version>
</dependency>
```
2. Kolejno należy przetestować aplikację pod względem poprawności zapisywania, usuwania i wyświetlania danych z bazy.

Przed podjęciem się pisania testów należy dodać do kodu klasy Project dwa konstruktory:

```
	public Project() {
    }
	
	public Project(Long id, String name, String course, String supervisor) {
		this.id = id;
		this.course = course;
		this.name = name;
		this.supervisor = supervisor;
	}
```
Pozwoli to na łatwiejsze zdefiniowanie parametrów projektu podczas testowania.
Testując aplikację, której repozytorium danych oparte jest na repozytorium JPA należy użyć adnotacji 
``` 
@DataJpaTest
```
w połączeniu z 
```
@RunWith(SpringRunner.class)
```
Pierwsza z adnotacji umożliwia wyłączenie automatycznej konfiguracji Spring Boot i zastosowanie konfiguracji istotnej podczas testów JPA. 

Klasę testową umieszczamy w katalogu /src/test/java. 
```
@RunWith(SpringRunner.class)
@DataJpaTest
class HomeworkApplicationTests {

	@Autowired
	private ProjectRepository projectRepository;
	
	
	@Test
	void testSaveProject() {
		Project project = new Project(1L,"project","course","supervisor");
		projectRepository.save(project);
		assertNotNull(project);
	}
	
	@Test
	void testDeleteProject() {
         ...
	}
	
	@Test
	void findAllProjects() {
          ...
	}

}
```
Brakujące metody testowe należy uzupełnić zgodnie z podanym przykładem.

Drugą opcję testowania aplikacji umożliwia nam adnotacja
```
@AutoConfigureMockMvc
```
W przykładowym tescie poniżej uruchamiany jest pełen kontekst aplikacji Spring, ale bez serwera. Sprawdzana jest poprawność przetwarzania żądania HTTP z zapytaniem o projekty.

```
@RunWith(SpringRunner.class)
@WebMvcTest(ProjectController.class)
class HomeworkApplicationControllerTests {
	
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getProjectsTest() throws Exception {
        mockMvc
                .perform(get("/"))
                .andExpect(status().isOk());
        
    }
}
```
Test należy umieścić w katalogu /src/test/java i dopisać do niego sprawdzanie poprawności działania kontrolera dla pozostałych endpointów obsługiwanych przez aplikację. 
