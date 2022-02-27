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
	
	//valorizziamo le map aggiungendo 3 corsi e 4 studenti
	
	public void valorizzaSegreteria(Segreteria s) {
		CorsoLaurea c1 = CorsoLaurea.builder().codice("CL1").nome("Informatica").indirizzo("viale Vasco Da Gama 12").numeroEsami(15).build();
		CorsoLaurea c2 = CorsoLaurea.builder().codice("CL2").nome("Storia").indirizzo("piazza Universita 9").numeroEsami(10).build();
		CorsoLaurea c3 = CorsoLaurea.builder().codice("CL3").nome("Scienze Umanistiche").indirizzo("via Kiev 24").numeroEsami(11).build();
		Studente s1 = Studente.builder().matricola("ABC1").nome("Valerio").cognome("Rossi").dataNascita("1999-03-11").email("rossiv@gmail.it").indirizzo("Via Leonardo da Vinci 22").citta("Roma").corsoLaurea(c1).build(); 
		Studente s2 = Studente.builder().matricola("EEE2").nome("Luigi").cognome("Mario").dataNascita("1983-01-29").email("luigibro@nintendo.jp").indirizzo("Via dei Tubi Verdi 11").citta("Regno dei Funghi").corsoLaurea(c2).build();
		Studente s3 = Studente.builder().matricola("FGH3").nome("Bowser").cognome("Jr.").dataNascita("1990-07-22").email("bj@hotmail.it").indirizzo("Castello di Bowser").citta("Regno dei Funghi").corsoLaurea(c3).build();
		Studente s4 = Studente.builder().matricola("MFK4").nome("Samuel").cognome("Jackson").dataNascita("1960-11-11").email("english@doyouspeak.it").indirizzo("Via delle Iene 18").citta("Arezzo").corsoLaurea(c1).build();
		s.aggiungiCorso(c1);
		s.aggiungiCorso(c2);
		s.aggiungiCorso(c3);
		s.aggiungiStudente(s1);
		s.aggiungiStudente(s2);
		s.aggiungiStudente(s3);
		s.aggiungiStudente(s4);
		
		
	}
	
	
}
