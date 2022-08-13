package br.com.ticinema.cinema.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ChaveCompostaSessao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name="id_sala")
	private Long idSala;
	
	@Column(name="id_filme")
	private Long idFilme;
	

}
