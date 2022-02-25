package it.gestionesegreteria.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import it.gestionesegreteria.model.CorsoLaurea;
import it.gestionesegreteria.model.Segreteria;
import it.gestionesegreteria.model.Studente;

//classe che contiene i Bean

@Configuration
public class SegreteriaConfig {

	
	
	@Bean
	public Segreteria segreteria() {
		return new Segreteria();
	
	}
	
	@Bean
	@Scope("prototype")
	public Studente studente() {
		return new Studente();
	}
	
	@Bean
	@Scope("prototype")
	public CorsoLaurea corsoLaurea() {
		return new CorsoLaurea();
	}
	
	
}
