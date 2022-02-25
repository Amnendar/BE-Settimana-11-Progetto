package it.gestionesegreteria.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import it.gestionesegreteria.model.CorsoLaurea;
import it.gestionesegreteria.model.Segreteria;
import it.gestionesegreteria.model.Studente;

@Component
public class SegreteriaLoader implements CommandLineRunner {

	@Autowired
	ApplicationContext ctx;

	
	@Override
	public void run(String... args) throws Exception {
		Segreteria segreteria = ctx.getBean(Segreteria.class);
		valorizzaSegreteria(segreteria);
		
	}
	
	//valorizziamo le map aggiungendo 2 corsi e 2 studenti
	
	public void valorizzaSegreteria(Segreteria s) {
		CorsoLaurea c1 = CorsoLaurea.builder().codice("CL1").nome("Informatica").indirizzo("viale Vasco Da Gama 12").numeroEsami(15).build();
		CorsoLaurea c2 = CorsoLaurea.builder().codice("CL2").nome("Storia").indirizzo("piazza Universita 9").numeroEsami(10).build();
		Studente s1 = Studente.builder().matricola("ABC1").nome("Valerio").cognome("Rossi").dataNascita("1999-03-11").email("rossiv@gmail.it").indirizzo("Via Leonardo da Vinci 22").citta("Roma").corsoLaurea(c1).build(); 
		Studente s2 = Studente.builder().matricola("EEE2").nome("Luigi").cognome("Mario").dataNascita("1983-1-29").email("luigibro@nintendo.jp").indirizzo("Via dei Tubi Verdi 11").citta("Regno dei Funghi").corsoLaurea(c2).build();
		s.aggiungiCorso(c1);
		s.aggiungiCorso(c2);
		s.aggiungiStudente(s1);
		s.aggiungiStudente(s2);
		
		
	}
	
	
}
