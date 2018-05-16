package com.formation.dating.entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Situation {
	
	@Id
	@GeneratedValue
	private Integer idSituation;
	private String statutPro;
	private String statutPerso;
	private Integer nbrEnfant;
	private String orientation;
	private String fumeur;
	private String alcool;
	@OneToMany
	private Collection<Utilisateur> utilisateursSituation;
	public Situation(Integer idSituation, String statutPro, String statutPerso, Integer nbrEnfant, String orientation,
			String fumeur, String alcool, Collection<Utilisateur> utilisateursSituation) {
		super();
		this.idSituation = idSituation;
		this.statutPro = statutPro;
		this.statutPerso = statutPerso;
		this.nbrEnfant = nbrEnfant;
		this.orientation = orientation;
		this.fumeur = fumeur;
		this.alcool = alcool;
		this.utilisateursSituation = utilisateursSituation;
	}
	public Collection<Utilisateur> getUtilisateursSituation() {
		return utilisateursSituation;
	}
	public void setUtilisateursSituation(Collection<Utilisateur> utilisateursSituation) {
		this.utilisateursSituation = utilisateursSituation;
	}
	public Integer getIdSituation() {
		return idSituation;
	}
	public void setIdSituation(Integer idSituation) {
		this.idSituation = idSituation;
	}
	public String getStatutPro() {
		return statutPro;
	}
	public void setStatutPro(String statutPro) {
		this.statutPro = statutPro;
	}
	public String getStatutPerso() {
		return statutPerso;
	}
	public void setStatutPerso(String statutPerso) {
		this.statutPerso = statutPerso;
	}
	public Integer getNbrEnfant() {
		return nbrEnfant;
	}
	public void setNbrEnfant(Integer nbrEnfant) {
		this.nbrEnfant = nbrEnfant;
	}
	public String getOrientation() {
		return orientation;
	}
	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}
	public String getFumeur() {
		return fumeur;
	}
	public void setFumeur(String fumeur) {
		this.fumeur = fumeur;
	}
	public String getAlcool() {
		return alcool;
	}
	public void setAlcool(String alcool) {
		this.alcool = alcool;
	}
	public Situation(Integer idSituation, String statutPro, String statutPerso, Integer nbrEnfant, String orientation,
			String fumeur, String alcool) {
		super();
		this.idSituation = idSituation;
		this.statutPro = statutPro;
		this.statutPerso = statutPerso;
		this.nbrEnfant = nbrEnfant;
		this.orientation = orientation;
		this.fumeur = fumeur;
		this.alcool = alcool;
	}
	public Situation() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Situation [idSituation=" + idSituation + ", statutPro=" + statutPro + ", statutPerso=" + statutPerso
				+ ", nbrEnfant=" + nbrEnfant + ", orientation=" + orientation + ", fumeur=" + fumeur + ", alcool="
				+ alcool + ", utilisateursSituation=" + utilisateursSituation + "]";
	}
}
