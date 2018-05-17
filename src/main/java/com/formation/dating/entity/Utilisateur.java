package com.formation.dating.entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Utilisateur {
	@Id
	@NotNull
	@NotBlank
	@Column(length = 150)
	private String emailUtilisateur;
	@NotBlank
	@Column(length=100)
	private String nom;
	@NotBlank
	@Column(length=100)
	private String prenom;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(length=10)
	private Date dateNaissance;
	@NotBlank
	@Column(length=10)
	private String sexe;
	@NotBlank
	@Column(length=255)
	private String motDePasse;
	@NotBlank
	@Column(length=100)
	private String description;
	@NotBlank
	@Column(length=100)
	private String pseudo;
	@NotBlank
	@Column(length=100)
	private String numeroTel;
	@NotNull
	@Column(length=100)
	private Integer type;
	@ManyToOne
	private Adresse adresse;
	@ManyToMany
	private Collection<Utilisateur> utilisateurs;
	@ManyToOne
	private Situation situation;
	@ManyToMany
	private Collection<CentreInteret> centreInteretUtilisateurs;
	@ManyToOne
	private Apparence apparence;
	@OneToMany
	private Collection<Photo> photos;
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
	
	
	public Utilisateur(@NotNull @NotBlank String emailUtilisateur, @NotBlank String nom, @NotBlank String prenom,
			Date dateNaissance, @NotBlank String sexe, @NotBlank String motDePasse, @NotBlank String description,
			@NotBlank String pseudo, @NotBlank String numeroTel, @NotNull Integer type, Adresse adresse,
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
	
}
