package com.formation.dating.entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Apparence {
	
	@Id
	@GeneratedValue
	private Integer idApparence;
	private Integer taille;
	private String couleurYeux;
	private String origine;
	private String couleurCheveux;
	private String typeCheveux;
	private Float masse;
	public Integer getIdApparence() {
		return idApparence;
	}
	public void setIdApparence(Integer idApparence) {
		this.idApparence = idApparence;
	}
	public Integer getTaille() {
		return taille;
	}
	public void setTaille(Integer taille) {
		this.taille = taille;
	}
	public String getCouleurYeux() {
		return couleurYeux;
	}
	public void setCouleurYeux(String couleurYeux) {
		this.couleurYeux = couleurYeux;
	}
	public String getOrigine() {
		return origine;
	}
	public void setOrigine(String origine) {
		this.origine = origine;
	}
	public String getCouleurCheveux() {
		return couleurCheveux;
	}
	public void setCouleurCheveux(String couleurCheveux) {
		this.couleurCheveux = couleurCheveux;
	}
	public String getTypeCheveux() {
		return typeCheveux;
	}
	public void setTypeCheveux(String typeCheveux) {
		this.typeCheveux = typeCheveux;
	}
	public Float getMasse() {
		return masse;
	}
	public void setMasse(Float masse) {
		this.masse = masse;
	}
	public Apparence(Integer idApparence, Integer taille, String couleurYeux, String origine, String couleurCheveux,
			String typeCheveux, Float masse) {
		super();
		this.idApparence = idApparence;
		this.taille = taille;
		this.couleurYeux = couleurYeux;
		this.origine = origine;
		this.couleurCheveux = couleurCheveux;
		this.typeCheveux = typeCheveux;
		this.masse = masse;
	}
	public Apparence() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Apparence [idApparence=" + idApparence + ", taille=" + taille + ", couleurYeux=" + couleurYeux
				+ ", origine=" + origine + ", couleurCheveux=" + couleurCheveux + ", typeCheveux=" + typeCheveux
				+ ", masse=" + masse + ", utilisateursApparence=" + utilisateursApparence + "]";
	}
	@OneToMany
	private Collection<Utilisateur> utilisateursApparence;
	public Apparence(Integer idApparence, Integer taille, String couleurYeux, String origine, String couleurCheveux,
			String typeCheveux, Float masse, Collection<Utilisateur> utilisateursApparence) {
		super();
		this.idApparence = idApparence;
		this.taille = taille;
		this.couleurYeux = couleurYeux;
		this.origine = origine;
		this.couleurCheveux = couleurCheveux;
		this.typeCheveux = typeCheveux;
		this.masse = masse;
		this.utilisateursApparence = utilisateursApparence;
	}
	public Collection<Utilisateur> getUtilisateursApparence() {
		return utilisateursApparence;
	}
	public void setUtilisateursApparence(Collection<Utilisateur> utilisateursApparence) {
		this.utilisateursApparence = utilisateursApparence;
	}
}
