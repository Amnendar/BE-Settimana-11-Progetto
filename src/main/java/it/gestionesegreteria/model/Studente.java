package it.gestionesegreteria.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Studente {

	@NotBlank
	private String matricola;
	@NotBlank
	private String nome;
	@NotBlank
	private String cognome;
	@NotBlank
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String dataNascita;
	@NotBlank
	private String email;
	@NotBlank
	private String indirizzo;
	@NotBlank
	private String citta;
	private CorsoLaurea corsoLaurea;
	
	
	
	@Override
	public String toString() {
		return "Studente [matricola=" + matricola + ", nome=" + nome + ", cognome=" + cognome + ", dataNascita="
				+ dataNascita + ", email=" + email + ", indirizzo=" + indirizzo + ", citta=" + citta + ", corsoLaurea="
				+ corsoLaurea + "]";
	}
	
	
	
	
	
}
