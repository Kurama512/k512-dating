package com.formation.dating.entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class CentreInteret {
	
	@Id
	@GeneratedValue
	private Integer idCi;
	@Override
	public String toString() {
		return "CentreInteret [idCi=" + idCi + ", sport=" + sport + ", loisir=" + loisir + ", multimedia=" + multimedia
				+ ", utilisateursCI=" + utilisateursCI + ", apparence=" + apparence + "]";
	}
	public CentreInteret() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CentreInteret(Integer idCi, String sport, String loisir) {
		super();
		this.idCi = idCi;
		this.sport = sport;
		this.loisir = loisir;
	}
	
	public Integer getIdCi() {
		return idCi;
	}
	public void setIdCi(Integer idCi) {
		this.idCi = idCi;
	}
	public String getSport() {
		return sport;
	}
	public void setSport(String sport) {
		this.sport = sport;
	}
	public String getLoisir() {
		return loisir;
	}
	public void setLoisir(String loisir) {
		this.loisir = loisir;
	}
	private String sport;
	private String loisir;
	@ManyToMany
	private Collection<Multimedia> multimedia;
	@ManyToMany
	private Collection<Utilisateur> utilisateursCI;
	public CentreInteret(Integer idCi, String sport, String loisir, Collection<Multimedia> multimedia,
			Collection<Utilisateur> utilisateursCI, Apparence apparence) {
		super();
		this.idCi = idCi;
		this.sport = sport;
		this.loisir = loisir;
		this.multimedia = multimedia;
		this.utilisateursCI = utilisateursCI;
		this.apparence = apparence;
	}
	@ManyToOne
	private Apparence apparence;
	public Collection<Multimedia> getMultimedia() {
		return multimedia;
	}
	public void setMultimedia(Collection<Multimedia> multimedia) {
		this.multimedia = multimedia;
	}
	public Collection<Utilisateur> getUtilisateursCI() {
		return utilisateursCI;
	}
	public void setUtilisateursCI(Collection<Utilisateur> utilisateursCI) {
		this.utilisateursCI = utilisateursCI;
	}
	public Apparence getApparence() {
		return apparence;
	}
	public void setApparence(Apparence apparence) {
		this.apparence = apparence;
	}
}
