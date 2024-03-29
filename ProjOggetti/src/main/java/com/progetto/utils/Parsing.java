package com.progetto.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;
/** <p>Il primo Parsing trova il link del file da scaricare all'indirizzo richiesto.
 *  Tramite il metodo <i>download</i> appena viene richiamato il parsing il file viene salvato
 *  col nome definito, nel path indicato (definito per sistemi Windows)</p>
 * 
 *
 */
public class Parsing {
	
	public static void getParsing()
	{ 
		String url = "http://data.europa.eu/euodp/data/api/3/action/package_show?id=erasmus-mobility-statistics-2012-13";
		try {
			//Apro la connessione con l'URL desiderato e apro l'InputStream 
				URLConnection openConnection = new URL(url).openConnection();
				openConnection.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
				InputStream in = openConnection.getInputStream();
			//Con il BufferedReader leggo riga per riga il file
				 String data = "";
				 String line = "";
				 try {
				   InputStreamReader inR = new InputStreamReader( in );
				   BufferedReader buf = new BufferedReader( inR );
			//Inserisco in data le righe del file
				   while ( ( line = buf.readLine() ) != null ) {
					   data+= line;
				   }
				 } finally {
			//Chiudo la connessione
				   in.close();
				 }
			//Definisco degli oggetti json per ricercare le informazioni per effettuare il download del file
				JSONObject obj = (JSONObject) JSONValue.parseWithException(data); 
				JSONObject objI = (JSONObject) (obj.get("result"));
				JSONArray objA = (JSONArray) (objI.get("resources"));
			//In un foreach scandisco gli elementi alla ricerca dell'url del file da scaricare in formato csv
				for(Object o: objA){
				    if ( o instanceof JSONObject ) {
				        JSONObject o1 = (JSONObject)o; 
				        String format = (String)o1.get("format");
				        String urlD = (String)o1.get("url");
				        if(format.endsWith("CSV") && urlD.endsWith("SM_2012_13_20141103_01.csv")) {
				        	download(urlD, "dati-erasmus.csv");
				        }
				    }
			}
			System.out.println( "Download file completed" );
		}catch(FileAlreadyExistsException e) {
			System.out.println("File already exist");	
		}catch (IOException | ParseException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
//Metodo per salvare una copia del file di interesse assegnandogli un nome
	public static void download(String url, String fileName) throws Exception {
	    try (InputStream in = URI.create(url).toURL().openStream()) {
	        Files.copy(in, Paths.get(fileName));
	    }
	}
}