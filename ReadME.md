# projoggetti
<body>
<p>Il dataset assegnatoci contiene collegamenti a più file dello stesso argomento - dati sui partecipanti e gli organizzatori di un percorso Erasmus -, della quale tre sono di estensione <i>.csv</i>. La scelta è ricaduta sul file con più righe (il CSV completo presenta quasi 300 000 record, per le stampe e le statistiche abbiamo fatto in modo di visualizzarne solo i primi 1000 per velocizzare ed alleggerire le interrogazioni sul file).</p>
<p>Per organizzare i dati abbiamo modellato più classi, della quale una astratta. Ognuna di queste racchiude gli attributi dei record che sono stati divisi a seconda del concetto rappresentato (com'è descritto dal seguente diagramma delle classi).</p>
<img src="doc/diagrammaclassi.png"></img>
<p>Tutte saranno istanza della superclasse <b>Student</b>. Tutte queste classi si troveranno nel package <b>model</b>.</p>
<p>Di seguito riportiamo il diagramma delle sequenze che ha lo scopo di rappresentare l'esecuzione del programma.</p>
<img src="doc/diagrammaflusso.png"></img>
<p>E successivamente si trovano i casi d'uso dell'applicazione.</p>
<img src="doc/casiuso.png"></img>
  <h3>/data</h3>
<p>La prima rotta è <i>/data</i> che stampa tutti gli attributti in coppia nome valore, separati per classe d'implementazione.</p>
<p>Prima di tutto salviamo i dati in un ArrayList <b>List<Student></b>, inizializzato nel Service all'interno della quale si definisce anche il metodo <b>retrieveAllData</b> e <b>retrieveDataStudent</b> che vengono richiamati dal Controller e servono a prendere le informazioni che vogliamo stampare</p>
<p>Si possono applicare a <i>/data</i> dei filtri, con la sittassi /data?filter=filtro. Sono stati implementati filtri con operatori sia condizionali che logici e sono specificati di seguito. Questo è possibile perchè è stato specificato un @RequestParam con valore di default nullo.</p>
  <h4>Filters</h4>
<p>Il metodo <i>doFilter</i>, a seconda dei parametri passategli, va a ricercare il filtro selezionato per poi applicarlo ad ogni elemento all'interno dell'ArrayList. Tutti gli elementi che soddisfano il filtro vengono inseriti in un ulteriore ArrayList per poi stamparli, nel caso sono state richieste le statistiche vengono prima elaborate e poi visualizzate.</p>
<p>Visto che i filtri vengono richiamati in due modi diversi:<br>
  {"parametro":{"$nomefiltro":valore}}<br>
  {"$nomefiltro":{"parametro":valore}}<br>
  il suddetto metodo prevede un controllo sulla posizione di parametri a seconda della chiamata</p>
<p>I filtri implementati sono di due categorie: Logici e Condizionali, ognuno definito in metodi diversi con la propria sintassi.</p>
  <h5>Operatori Logici</h5>
  <p>Accettano ogni tipo di variabile</p>
<p>$not</p>
 <p><i>Forma generale:</i> {"parametro":{"$not":valore}}<br> 
    <i>Esempio:</i>localhost:8080/data?filter={"age":{"$not":21}}</p>

<p>$in</p>
<p><i>Forma generale:</i> {"parametro":{"$in":[valore1,valore2,valore3,...]}}<br>
  <i>Esempio:</i> localhost:8080/data?filter={"sh_duration":{"$in":["T","?"]}}</p>

<p>$nin</p>
<p><i>Forma generale:</i> {"parametro":{"$nin":[valore1,valore2,valore3,...]}}<br>
  <i>Esempio:</i> localhost:8080/data?filter={"studygrant":{"$nin":[0, 1235, 355.84]}}</p>

<p>$or</p>
<p><i>Forma generale:</i> {"$or":[{"parametro1":valore1},{"parametro2":valore2}]}<br>
   {"$or":[{"parametro":valore1},{"parametro":valore2}]}<br>
  <i>Esempio:</i> localhost:8080/data?filter={"$or":[{"lang_preparation":"EC"},{"total_credits":30}]}<br>
  localhost:8080/data?filter={"$or":[{"lang_preparation":"EC"},{"lang_preparation":"NN"}]}</p>
  
<p>$and</p>
<p><i>Forma generale:</i> {"$and":[{"parametro1":valore1},{"parametro2":valore2}]}<br>
  <i>Esempio:</i> localhost:8080/data?filter={"$and":[{"gender":"M"},{"age":21}]}</p>

  <h5>Operatori Condizionali</h5>
  <p>Accettano solo tipi numerici</p>
<p>$gt</p>
 <p><i>Forma generale:</i> {"parametro":{"$gt":valore}}<br> 
    <i>Esempio:</i>localhost:8080/data?filter={"studylength":{"$gt":4}}</p>
  
<p>$gte</p>
 <p><i>Forma generale:</i> {"parametro":{"$gte":valore}}<br> 
    <i>Esempio:</i>localhost:8080/data?filter={"studycredits":{"$gte":48}}</p>
  
<p>$lt</p>
 <p><i>Forma generale:</i> {"parametro":{"$lt":valore}}<br> 
    <i>Esempio:</i>localhost:8080/data?filter={"n_years":{"$lt":3}}</p>
  
<p>$lte</p>
 <p><i>Forma generale:</i> {"parametro":{"$lte":valore}}<br> 
    <i>Esempio:</i>localhost:8080/data?filter={"subject_area":{"$lte":22}}</p>
  
<p>$bt</p>
 <p><i>Forma generale:</i> {"parametro":{"$bt":[valore1,valore2]}}<br> 
    <i>Esempio:</i>localhost:8080/data?filter={"placementgrant":{"$bt":[800,900]}}</p>
<h5>Operatori logici e condizionali combinati</h5>
<p>Sia con la rotta /data che con la rotta /statistics é possibile applicare più filtri, oltre che combinare un operatore logico con uno condizionale con la sintassi {"parametro":{"$nomefiltro1":valore},"parametro":{"$nomefiltro2":valore},...}</p>
<p><i>Esempi:</i> localhost:8080/data?filter={"subject_area":{"$lte":38},"$or":[{"lang_preparation":"EC"},{"total_credits":30}]}<br>
localhost:8080/statistics?field=nationality&filter={"age":{"$lte":25},"age":{"$not":20}}</p>
  <h3>/metadata</h3>
<p></p>
  <h3>/statistics</h3>
<p>Nel controller la rotta <i>/statistics</i> chiama il metodo <i>retriveStatistics</i>. Esso gestisce i tipi di dato passategli per il calcolo: per le <b>stringhe</b> e per i <b>char</b> viene restituito solo il conteggio(attraverso il metodo di <i>Student</i>, <i>countString</i>), raggruppato per valore, per i tipi numerici vengono stampati, oltre al loro conteggio(metodo <i>countNum</i> di <i>Student</i>) la media, il minimo e il massimo, la deviazione standard e la somma.</p>
<p>Per calcolare una statistica la sintassi, indifferente per ogni tipo, é: /statistics/field=parametro</p>
<p><i>Esempio:</i> localhost:8080/statistics?field=total_credits<br>
localhost:8080/statistics?field=lang_taught</p>
<p>E' possibile applicare in cascata ad una statistica un filtro tramite la sintassi: /statistics/field=parametro&filter=filtro</p>
<p><i>Esempi:</i><br>
localhost:8080/statistics?field=study_level&filter={"host_code":{"$not":"IT"}}<br>
localhost:8080/statistics?field=age&filter={"placemententerprise":{"$in":["STUDIO ROMOLI","UNIVERSIT? DI ROMA"]}}<br>
localhost:8080/statistics?field=gender&filter={"placementcountry":{"$nin":["???","IT"]}}<br>
localhost:8080/statistics?field=placementsector&filter={"$or":[{"gender":"M"},{"placementstart":"Apr-13"}]}<br>
localhost:8080/statistics?field=placementsector&filter={"$or":[{"placementstart":"Mar-13"},{"placementstart":"Apr-13"}]}<br>
localhost:8080/statistics?field=mob_type&filter={"$and":[{"host_country":"FI"},{"study_level":1}]}<br>
localhost:8080/statistics?field=n_years&filter={"total_credits":{"$gt":30}}<br>
localhost:8080/statistics?field=total_credits&filter={"n_years":{"$gte":2}}<br>
localhost:8080/statistics?field=Gender&filter={"age":{"$lt":25}}<br>
localhost:8080/statistics?field=studylength&filter={"subject_area":{"$lte":38}}<br>
localhost:8080/statistics?field=lang_taught&filter={"age":{"$bt":[20,30]}}</p>
</body>








