# Sample Rountig
## Caratteristiche principali
### Struttura del progetto
Il codice è gestito come progetto Maven multi-modulo, in modo da garantire una corretta organizzazione dei diversi layer applicativi.
 - **CurrenciesAPI** (pom): Costituisce il parent del progetto, è responsabile quindi della configurazione dei plugin e della definizione dei moduli che compongono il progetto.
	 - **CurrenciesAPI_Common** (jar): Contiene le componenti comuni a tutti i layer, come i POJO del data model di business (`*BO.java`) e l'inclusione di dipendenze per il logging o di utilità.
	 - **CurrenciesAPI_Integration** (jar): Contiene le componenti logiche di integrazione con servizi esterni. Gli aspetti specifici di integrazione, come le classi annotate necessarie per l'interrogazione delle API di restcountries.eu, sono isolati in questo layer. Il servizio `CountriesRestService.java`, che fa da wrapper per le API restcountries.eu, espone infatti oggetti del data model comune.
	 - **CurrenciesAPI_WebApp** (war): Contiene le componenti web necessarie per l'esposizione sia delle API REST (`CurrenciesApiController.java`) che della JSP (`CurrenciesWebController.java`). Gli oggetti utilizzati in questo layer di presentation sono specifici (`*AO.java`). In questo modo sarà possibile arricchire il data model di presentation senza intervenire sul data model di business.

Un'applicazione web prevede tipicamente almeno un ulteriore layer di DataAccess, per implementare le componenti di accesso alla base dati e renderle fruibili dagli altri moduli applicativi tramite interfacce basate sul data model di business (in maniera analoga a quanto descritto per il layer Integration).
### Framework utilizzati
I principali framework utilizzati nell'applicazione, ed un breve commento sul loro utilizzo, sono riportati nella seguente tabella.
|Framework|Note|
|--|--|
|Spring MVC 5|Per le componenti web si è scelto di utilizzare la versione più recente di Spring MVC. La configurazione dell'application context avviene unicamente tramite la contextClass `AnnotationConfigWebApplicationContext`: non sono presenti configurazioni in XML, ma unicamente classi di configurazione annotate come `@Configuration`. La classe di configurazione è `WebConfig.java`, che implementa `WebMvcConfigurer`. La componente di API REST è gestita dal `@RestController` `CurrenciesApiController.java`, la componente JSP dal `@Controller` `CurrenciesWebController.java`. Viene definita come `@Component` la classe `CountriesRestService.java`, per l'integrazione delle API di restcountries.eu, che sfrutta `RestTemplate`.|
|MapStruct|La definizione di un'applicazione layerizzata rende necessario un meccanismo di mapping semplice ed efficace per la gestione delle conversioni tra i data model dei diversi layer. MapStruct rappresenta una delle migliori scelte poiché, grazie ad un annotation processor agganciato al lifecycle Maven, genera a compile-time le implementazioni delle interfacce di mapping. In questo modo a runtime non si fa ricorso a reflection.|
|log4j|Framework standard per la gestione del logging.|
|JUnit 4|Framework standard per la gestione dello unit testing. **NOTA**: l'utilizzo dell'annotation processor di MapStruct per la creazione a compile time dei mapper, rende il plugin JUnit *standard* di Eclipse non adeguato. I test possono essere invece eseguiti correttamente tramite Maven.|
## Utilizzo
La build avviene tramite goal package sul root pom (`CurrenciesAPI/pom.xml`).
Al deploy, l'applicazine esporrà le seguenti due URL, assumendo un'installazione di Tomcat 7 di default:
 - **REST API**: http://localhost:8080/CurrenciesAPI_WebApp-1.0.0/api/countries
 - **WEB**: http://localhost:8080/CurrenciesAPI_WebApp-1.0.0/web/countries
### REST API
L'unica risorsa definita è `/countries`, che risponde unicamente all'operation `GET`.

L'API REST implementa un meccanismo di paginazione molto semplice, basato sugli attributi `page` e `pageSize`. Ad esempio con la seguente URI sarà restituita la seconda pagina di risultati, dove ogni pagina ha una dimensione di 10 record:
 - http://localhost:8080/CurrenciesAPI_WebApp-1.0.0/api/countries?page=2&pageSize=10
### WEB
La componente WEB è implementata come unica pagina JSP. Viene sempre mostrata l'intera lista di valori in una tabella formattata.
## Note
Si tengano in considerazione infine le seguenti note e spunti:
 - La corretta gestione delle eccezioni è stata solamente abbozzata tramite `TechnicalException.java`. Normalmente è necessario definire in maniera più strutturata le tipologie e le modalità di gestione delle eccezioni tecniche, applicative e impreviste.
 - Tipicamente i layer applicativi sono mascherati l'un l'altro tramite layer di pure interfacce Java. In questo modo sarebbe ad esempio possibile compilare e deployare correttamente il layer di presentation - includendo come dipendenza solamente il modulo delle interfacce di integrazione - e fornire in maniera distinta nel classpath (ad esempio tramite librerie gestite dal container) l'implementazione concreta.
 - In questa versione delle API REST non è stata prevista alcuna modalità consistente di validazione degli input e gestione degli errori. Si tratta tuttavia di uno dei primi punti su cui intervenire. 
 - Il framework di logging in questa applicazione è stato solamente impostato, ma non adottato in maniera completa.
 - Per l'esecuzione dei test JUnit sarebbe utile valutare la possibilità di implementare ed integrare nel ciclo di testing una versione mock delle API di restcountries.eu, così da non dipendere dalla loro disponibilità e raggiungibilità per l'esecuzione di uno unit test.
## Ambiente di sviluppo
L'IDE utilizzato per lo sviluppo del progetto è Eclipse Oxygen.3 Release (4.7.3).
