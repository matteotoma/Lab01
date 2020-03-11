package it.polito.tdp.parole.model;

import java.util.List;
import java.util.*;

public class Parole {
	private TreeMap<String, String> parole;
		
	public Parole() {
		parole = new TreeMap<String, String>();
	}
	
	public void addParola(String p) {
		parole.put(p, p);
	}
	
	public List<String> getElenco() {
		LinkedList<String> l = new LinkedList<String>(parole.values());
		return l;
	}
	
	public void reset() {
		parole.clear();
	}
	
	public void cancella(String c) {
		if(parole.containsKey(c))
			parole.remove(c);
	}

}
