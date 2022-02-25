package it.gestionesegreteria.controller;



import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import it.gestionesegreteria.model.CorsoLaurea;
import it.gestionesegreteria.model.Segreteria;
import it.gestionesegreteria.model.Studente;

//controller unico per entrambe le classi

@Controller
@RequestMapping("/gestionesegreteria")
public class SegreteriaController {
	
	@Autowired
	ApplicationContext ctx;
	
	
	
	private Segreteria getSegreteria() {
		return ctx.getBean(Segreteria.class);
	}

	//visualizza gli studenti
	
	@GetMapping("/visualizzastudenti")
	public ModelAndView visualizzaStudenti() {
		return new ModelAndView ("visualizzaStudenti", "studenti", getSegreteria().mostraTuttiStudenti());
			
		
	}
	
	//visualizza corsi 
	
	@GetMapping("/visualizzacorsi")
	public ModelAndView visualizzaCorsi() {
		return new ModelAndView ("visualizzaCorsi", "corsi", getSegreteria().mostraTuttiCorsi());
			
		
	}
	
	
	//inserimento Studente
	
	
	@GetMapping("/formstudente")
	public ModelAndView formStudenti(Studente s) {
		Segreteria segreteria = getSegreteria();
		Collection<CorsoLaurea> corsi = segreteria.getCorsi().values();
		ModelAndView mw = new ModelAndView("aggiungistudente", "studente", new Studente());
		mw.addObject("corsi", corsi);
		return mw;
	}
	
	@PostMapping("/aggiungistudente")
	public ModelAndView aggiungiStudente(@Valid @ModelAttribute("studente")Studente s, BindingResult result, Model model) {
		getSegreteria().aggiungiStudente(s);
		return visualizzaStudenti();
	}
	
	//inserimento Corso
	
	@GetMapping("/formcorso")
	public ModelAndView formCorsi(CorsoLaurea c) {
		ModelAndView mw = new ModelAndView("aggiungicorso", "corso", new CorsoLaurea());
		return mw;
	}
	
	@PostMapping("/aggiungicorso")
	public ModelAndView aggiungiCorso(@Valid @ModelAttribute("corso")CorsoLaurea c, BindingResult result, Model model) {
		getSegreteria().aggiungiCorso(c);
		return visualizzaCorsi();
	}
	
	
	
	//aggiorna Studente
	
	
	@GetMapping("/formaggiornastudente/{matricola}")
	public ModelAndView formAggiornaStudente(@PathVariable("matricola") String matricola ) {
		Studente s = getSegreteria().getStudenti().get(matricola);
		return new ModelAndView("aggiornaStudente", "studente", s);
	}
	
	@PostMapping("/aggiornastudente/{matricola}")
	public ModelAndView aggiornaStudente(@PathVariable("matricola") String matricola, Studente s, BindingResult result) {
		getSegreteria().aggiornaStudente(s);
		return new ModelAndView("visualizzaStudenti", "studente", getSegreteria().mostraTuttiStudenti());
	}
	
	//aggiorna Corso
	
	@GetMapping("/formaggiornacorso/{codice}")
	public ModelAndView formAggiornaCorso(@PathVariable("codice") String codice ) {
		CorsoLaurea c = getSegreteria().getCorsi().get(codice);
		return new ModelAndView("aggiornaCorso", "corso", c);
	}
	
	@PostMapping("/aggiornacorso/{codice}")
	public ModelAndView aggiornaCorso(@PathVariable("codice") String codice, CorsoLaurea c, BindingResult result) {
		getSegreteria().aggiornaCorso(c);
		return new ModelAndView("visualizzaCorsi", "corso", getSegreteria().mostraTuttiCorsi());
	}
	
	
	//cancella Studente
	
	@GetMapping("/formcancella/{matricola}")
	public ModelAndView formCancellaStudente(@PathVariable("matricola") String matricola) {
		Studente s = getSegreteria().getStudenti().get(matricola);
		return new ModelAndView("cancellastudente", "studente", s);
	}
	
	@DeleteMapping("/cancellastudente/{matricola}")
	public ModelAndView cancellaStudente(@PathVariable("matricola")String matricola) {
		getSegreteria().eliminaStudente(matricola);
		return new ModelAndView("visualizzaStudenti", "studente", getSegreteria().mostraTuttiStudenti());
	}
	
	//cancella Corso
	
	@GetMapping("/formcancella/{codice}")
	public ModelAndView formCancellaCorso(@PathVariable("codice") String codice) {
		CorsoLaurea c = getSegreteria().getCorsi().get(codice);
		return new ModelAndView("cancellacorso", "corso", c);
	}
	
	@DeleteMapping("/cancellacorso/{codice}")
	public ModelAndView cancellaCorso(@PathVariable("codice")String codice) {
		getSegreteria().eliminaCorso(codice);
		return new ModelAndView("visualizzaCorsi", "corso", getSegreteria().mostraTuttiCorsi());
	}
	
	
	
}
