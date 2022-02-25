package it.gestionesegreteria.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CorsoLaurea {

	@NotBlank
	private String codice;
	@NotBlank
	private String nome;
	private String indirizzo;
	@Min(10)
	private int numeroEsami;
	
	
	
	@Override
	public String toString() {
		return "CorsoLaurea [codice=" + codice + ", nome=" + nome + ", indirizzo=" + indirizzo + ", numeroEsami="
				+ numeroEsami + "]";
	}
	
	
	
	
	
}
