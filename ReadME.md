# projoggetti
<body>
<p>Il progetto, organizzato in più packages oppurtunamente divisi vuole svolgere le funzioni definite in maniera semplice ed efficiente.</p>
<p>Il dataset assegnatoci contiene collegamenti a più file dello stesso argomento - dati sui partecipanti e gli organizzatori di un percorso Erasmus -, della quale tre sono di estensione <i>.csv</i>. La scelta è ricaduta sul file con più righe (il CSV completo presenta quasi 300 000 record, per le stampe e le statistiche abbiamo fatto in modo di visualizzarne solo i primi 1000 per velocizzare ed alleggerire le interrogazioni sul file).</p>
<p>Per organizzare i dati abbiamo modellato più classi, della quale una astratta. Ognuna di queste racchiude gli attributi dei record che sono stati divisi a seconda del concetto rappresentato (com'è descritto dal seguente diagramma delle classi).
<img src=""></img>
<p>Tutte saranno istanza della superclasse <b>Student</b>. Tutte queste classi si troveranno nel package <b>model</b>.</p>
<p>Di seguito riportiamo il diagramma delle sequenze che ha lo scopo di rappresentare l'esecuzione del programma.</p>
<img src=""></img>
<p>E successivamente si trovano i casi d'uso dell'applicazione.</p>
<img src=""></img>
</body>
