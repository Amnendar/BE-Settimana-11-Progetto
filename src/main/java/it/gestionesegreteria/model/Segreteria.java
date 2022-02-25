package it.gestionesegreteria.model;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;


//classe che funge da DB

@Data
@AllArgsConstructor
public class Segreteria {

	private final Map<String, Studente> studenti = new HashMap<>();
	private final Map<String, CorsoLaurea> corsi = new HashMap<>();
	
	
	
	
	public void aggiungiStudente(Studente s) {
		studenti.put(s.getMatricola(), s);
	}
	
	
	public void aggiungiCorso(CorsoLaurea c) {
		corsi.put(c.getCodice() , c);
	}
	
	public Collection<Studente> mostraTuttiStudenti(){
		return studenti.values();
	}
	
	public Collection<CorsoLaurea> mostraTuttiCorsi(){
		return corsi.values();
	}
	
	public void eliminaStudente(String matricola) {
		studenti.remove(matricola);
	}
	
	public void eliminaCorso(String codice) {
		corsi.remove(codice);
	}
	
	public void aggiornaStudente(Studente s) {
		for (Studente studente : studenti.values()) {
			if (s.getMatricola().equals(studente.getMatricola())) {
				studente.setCitta(s.getCitta());
				studente.setNome(s.getNome());
				studente.setCognome(s.getCognome());
				studente.setDataNascita(s.getDataNascita());
				studente.setIndirizzo(s.getIndirizzo());
				studente.setEmail(s.getEmail());
			}
		}
	}
	
	public void aggiornaCorso(CorsoLaurea c) {
		for (CorsoLaurea corsoLaurea : corsi.values()) {
			if(c.getCodice().equals(corsoLaurea.getCodice())) {
				corsoLaurea.setIndirizzo(c.getIndirizzo());
				corsoLaurea.setNome(c.getNome());
				corsoLaurea.setNumeroEsami(c.getNumeroEsami());
			}
		}
	}
	
	
	
}
