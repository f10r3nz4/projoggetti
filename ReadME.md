# projoggetti
<body>
<p>Il dataset assegnatoci contiene collegamenti a più file dello stesso argomento - dati sui partecipanti e gli organizzatori di un percorso Erasmus -, della quale tre sono di estensione <i>.csv</i>. La scelta è ricaduta sul file con più righe (il CSV completo presenta quasi 300 000 record, per le stampe e le statistiche abbiamo fatto in modo di visualizzarne solo i primi 1000 per velocizzare ed alleggerire le interrogazioni sul file).</p>
<p>Per organizzare i dati abbiamo modellato più classi, della quale una astratta. Ognuna di queste racchiude gli attributi dei record che sono stati divisi a seconda del concetto rappresentato (com'è descritto dal seguente diagramma delle classi).
<img src=""></img>
<p>Tutte saranno istanza della superclasse <b>Student</b>. Tutte queste classi si troveranno nel package <b>model</b>.</p>
<p>Di seguito riportiamo il diagramma delle sequenze che ha lo scopo di rappresentare l'esecuzione del programma.</p>
<img src=""></img>
<p>E successivamente si trovano i casi d'uso dell'applicazione.</p>
<img src=""></img>
  <h3>/data</h3>
<p>La prima rotta è <i>/data</i> che stampa tutti gli attributti in coppia nome valore, separati per classe d'implementazione.</p>
<p>Prima di tutto salviamo i dati in un ArrayList <b>List<Student></b>, inizializzato nel Service all'interno della quale si definisce anche il metodo <b>retrieveAllData</b> e <b>retrieveDataStudent</b> che vengono richiamati dal Controller e servono a prendere le informazioni che vogliamo stampare</p>
<p>Si possono applicare a <i>/data</i> dei filtri, con la sittassi <b>/data?filter=</b>. Sono stati implementati filtri con operatori sia condizionali che logici e sono specificati di seguito. Questo è possibile perchè è stato specificato un @RequestParam con valore di default nullo.</p>
  <h3>/metadata</h3>
<p></p>
  <h3>/statistics</h3>
<p></p>
</body>

localhost:8080/data?filter={"age":{"$not":21}}<br>
localhost:8080/data?filter={"sh_duration":{"$in":["T","?"]}}<br>
localhost:8080/data?filter={"studygrant":{"$nin":[0, 1235, 355.84]}}<br>
localhost:8080/data?filter={"$or":[{"lang_preparation":"EC"},{"lang_preparation":"NN"}]}<br>
localhost:8080/data?filter={"$or":[{"lang_preparation":"EC"},{"total_credits":30}]}<br>
localhost:8080/data?filter={"$and":[{"gender":"M"},{"age":21}]}<br>
localhost:8080/data?filter={"studylength":{"$gt":4}}<br>
localhost:8080/data?filter={"studycredits":{"$gte":48}}<br>
localhost:8080/data?filter={"n_years":{"$lt":3}}<br>
localhost:8080/data?filter={"subject_area":{"$lte":22}}<br>
localhost:8080/data?filter={"placementgrant":{"$bt":[800,900]}}<br>
