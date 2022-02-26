package it.gestionesegreteria.model;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

import lombok.Getter;


//classe che funge da DB

@Component
@Getter
public class Segreteria {

	private final Map<String, Studente> studenti = new HashMap<>();
	private final Map<String, CorsoLaurea> corsi = new HashMap<>();
	
	
	//metodi di inserimento
	
	public void aggiungiStudente(Studente s) {
		if (studenti.containsValue(s)) {
			System.out.println("ERRORE! Studente gia presente nel database!");
			return;
		}
		studenti.put(s.getMatricola(), s);
	}
	
	
	public void aggiungiCorso(CorsoLaurea c) {
		if(corsi.containsValue(c)) {
			System.out.println("ERRORE! Corso gia presente nel database!");
		}
		corsi.put(c.getCodice() , c);
	}
	
	
	//metodi che mostrano tutti gli elementi
	
	public Collection<Studente> mostraTuttiStudenti(){
		return studenti.values();
	}
	
	public Collection<CorsoLaurea> mostraTuttiCorsi(){
		return corsi.values();
	}
	
	
	//metodi di cancellazione
	
	
	public void eliminaStudente(String matricola) {
		if (studenti.containsKey(matricola)) {
		studenti.remove(matricola);
		return;
		}
		System.out.println("ERRORE! Nessuno studente corrispondente a questa matricola!");
		
	}
	
	public void eliminaCorso(String codice) {
		if (corsi.containsKey(codice)) {
		corsi.remove(codice);
		return;
		}
		System.out.println("ERRORE! Nessun corso corrsipondente a questo codice!");
	}
	
	
	//metodi di aggiornamento
	
	public void aggiornaStudente(Studente s) {
		for (Studente studente : studenti.values()) {
			if (s.getMatricola().equals(studente.getMatricola())) {
				studente.setCitta(s.getCitta());
				studente.setNome(s.getNome());
				studente.setCognome(s.getCognome());
				studente.setDataNascita(s.getDataNascita());
				studente.setIndirizzo(s.getIndirizzo());
				studente.setEmail(s.getEmail());
				return;
			}
		}
		System.out.println("ERRORE! Nessuno studente corrispondente a questa matricola!");
	}
	
	public void aggiornaCorso(CorsoLaurea c) {
		for (CorsoLaurea corsoLaurea : corsi.values()) {
			if(c.getCodice().equals(corsoLaurea.getCodice())) {
				corsoLaurea.setIndirizzo(c.getIndirizzo());
				corsoLaurea.setNome(c.getNome());
				corsoLaurea.setNumeroEsami(c.getNumeroEsami());
				return;
			}
		}
		System.out.println("ERRORE! Nessuno studente corrispondente a questa matricola!");
	}
	
	
	//metodi che trovano un elemento tramite chiave primaria
	
	public Studente trovaStudenteByMatricola(String matricola) {
		 Studente s = studenti.get(matricola);
		 if (s == null) {
			 System.out.println("ERRORE! Nessuno studente corrispondente a questa matricola!");
			 return null;
		 }
		 return s;
	}
	
	
	public CorsoLaurea trovaCorsoByCodice(String codice) {
		CorsoLaurea c = corsi.get(codice);
		if(c== null) {
			System.out.println("ERRORE! Nessun corso corrispondente a questo codice!");
			 return null;
		}
		return c;
	}
	
	
}
