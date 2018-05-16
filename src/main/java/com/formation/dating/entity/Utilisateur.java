package com.formation.dating.entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Utilisateur {
	@Id
	@NotNull
	private String emailUtilisateur;
	private String nom;
	private String prenom;
	private Date dateNaissance;
	private String sexe;
	private String motDePasse;
	private String description;
	private String pseudo;
	private String numeroTel;
	private Integer type;
	@ManyToOne
	private Adresse adresse;
	@ManyToMany
	private Collection<Utilisateur> utilisateurs;
	@ManyToOne
	private Situation situation;
	@ManyToMany
	private Collection<CentreInteret> centreInteretUtilisateurs;
	
	public String getEmailUtilisateur() {
		return emailUtilisateur;
	}
	public void setEmailUtilisateur(String emailUtilisateur) {
		this.emailUtilisateur = emailUtilisateur;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public String getMotDePasse() {
		return motDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public String getNumeroTel() {
		return numeroTel;
	}
	public void setNumeroTel(String numeroTel) {
		this.numeroTel = numeroTel;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Utilisateur(@NotNull String emailUtilisateur, String nom, String prenom, Date dateNaissance, String sexe,
			String motDePasse, String description, String pseudo, String numeroTel, Integer type) {
		super();
		this.emailUtilisateur = emailUtilisateur;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.sexe = sexe;
		this.motDePasse = motDePasse;
		this.description = description;
		this.pseudo = pseudo;
		this.numeroTel = numeroTel;
		this.type = type;
	}
	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Utilisateur [emailUtilisateur=" + emailUtilisateur + ", nom=" + nom + ", prenom=" + prenom
				+ ", dateNaissance=" + dateNaissance + ", sexe=" + sexe + ", motDePasse=" + motDePasse
				+ ", description=" + description + ", pseudo=" + pseudo + ", numeroTel=" + numeroTel + ", type=" + type
				+ ", adresse=" + adresse + ", utilisateurs=" + utilisateurs + ", situation=" + situation
				+ ", centreInteretUtilisateurs=" + centreInteretUtilisateurs + ", apparence=" + apparence + ", photos="
				+ photos + "]";
	}
	
	@ManyToOne
	private Apparence apparence;
	
	public Utilisateur(@NotNull String emailUtilisateur, String nom, String prenom, Date dateNaissance, String sexe,
			String motDePasse, String description, String pseudo, String numeroTel, Integer type, Adresse adresse,
			Collection<Utilisateur> utilisateurs, Situation situation,
			Collection<CentreInteret> centreInteretUtilisateurs, Apparence apparence, Collection<Photo> photos) {
		super();
		this.emailUtilisateur = emailUtilisateur;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.sexe = sexe;
		this.motDePasse = motDePasse;
		this.description = description;
		this.pseudo = pseudo;
		this.numeroTel = numeroTel;
		this.type = type;
		this.adresse = adresse;
		this.utilisateurs = utilisateurs;
		this.situation = situation;
		this.centreInteretUtilisateurs = centreInteretUtilisateurs;
		this.apparence = apparence;
		this.photos = photos;
	}
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	public Collection<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}
	public void setUtilisateurs(Collection<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}
	public Situation getSituation() {
		return situation;
	}
	public void setSituation(Situation situation) {
		this.situation = situation;
	}
	public Collection<CentreInteret> getCentreInteretUtilisateurs() {
		return centreInteretUtilisateurs;
	}
	public void setCentreInteretUtilisateurs(Collection<CentreInteret> centreInteretUtilisateurs) {
		this.centreInteretUtilisateurs = centreInteretUtilisateurs;
	}
	public Apparence getApparence() {
		return apparence;
	}
	public void setApparence(Apparence apparence) {
		this.apparence = apparence;
	}
	public Collection<Photo> getPhotos() {
		return photos;
	}
	public void setPhotos(Collection<Photo> photos) {
		this.photos = photos;
	}

	@OneToMany
	private Collection<Photo> photos;
}
