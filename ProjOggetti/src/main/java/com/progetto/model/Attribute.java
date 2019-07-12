package com.progetto.model;

/**
 * <p>La classe pubblica <b>Attribute</b> viene usata per prendere i dati ed i tipi di dati
 * all'interno delle classi modellate in modo da poter restituire, mediante un opportuno
 * metodo definito nel <i>Controller</i>, la lista dei metadati delle variabili in formato json.
 * Vengono quidndi create tre variabili di tipo String con i conseuti costruttore con super(),
 * getter e setters ed un toString() di controllo.</p>
 */

public class Attribute {
	String alias;
	String sourceField;
	String type;
	
	public Attribute(String alias, String sourceField, String type) {
		super();
		this.alias = alias;
		this.sourceField = sourceField;
		this.type = type;
	}
	
	public String getAlias() {
		return alias;
	}
	
	public void setAlias(String alias) {
		this.alias = alias;
	}
	
	public String getSourceField() {
		return sourceField;
	}
	
	public void setSourceField(String sourceField) {
		this.sourceField = sourceField;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "Attribute [alias=" + alias + ", sourceField=" + sourceField + ", type=" + type + "]";
	}
}
