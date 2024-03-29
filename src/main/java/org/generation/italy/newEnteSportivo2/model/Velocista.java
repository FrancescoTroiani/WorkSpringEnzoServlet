package org.generation.italy.newEnteSportivo2.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "velocista")
public class Velocista {

	@Id
	@Column(nullable = false, columnDefinition = "char(16)", name = "codice_fiscale")
	private String codiceFiscale;

	@Column(nullable = false, length = 40, name = "nominativo")
	private String nominativo;

	@Column(nullable = false, length = 3, name = "eta")
	private Short eta;

	@Column(nullable = false, length = 3, name = "altezza")
	private Integer altezza;

	@Column(nullable = false, name = "peso")
	private Float peso;

	@JsonBackReference
	@OneToMany(mappedBy = "iscrizionePK.velocista")
	List<Iscrizione> elencoIscrizioni;

	@JsonBackReference
	@OneToMany(mappedBy = "partecipazionePK.velocista")
	List<Partecipazione> elencoPartecipazioni;

	public Velocista() {
		super();
	}

	public Velocista(String codiceFiscale, String nominativo, Short eta, Integer altezza, Float peso) {
		super();
		this.codiceFiscale = codiceFiscale;
		this.nominativo = nominativo;
		this.eta = eta;
		this.altezza = altezza;
		this.peso = peso;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public String getNominativo() {
		return nominativo;
	}

	public Short getEta() {
		return eta;
	}

	public Integer getAltezza() {
		return altezza;
	}

	public Float getPeso() {
		return peso;
	}

	public void setPeso(Float peso) {
		this.peso = peso;
	}

}
