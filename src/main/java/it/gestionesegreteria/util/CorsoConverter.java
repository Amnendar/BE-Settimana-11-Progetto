package it.gestionesegreteria.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import it.gestionesegreteria.model.CorsoLaurea;
import it.gestionesegreteria.model.Segreteria;

//classe che converte una stringa in un corso di laurea a partire dal codice

@Component
public class CorsoConverter implements Converter<String, CorsoLaurea>{

	@Autowired
	private ApplicationContext ctx;
	
	
	
	@Override
	public CorsoLaurea convert(String codice) {
		Segreteria segreteria = ctx.getBean(Segreteria.class);
		return segreteria.trovaCorsoByCodice(codice);
	}
	
	
}
