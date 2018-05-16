package com.formation.dating.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Photo {
	
	@Id
	private Integer idPhoto;
	private String lien;
	private Integer note;
	public Integer getIdPhoto() {
		return idPhoto;
	}
	public void setIdPhoto(Integer idPhoto) {
		this.idPhoto = idPhoto;
	}
	public String getLien() {
		return lien;
	}
	public void setLien(String lien) {
		this.lien = lien;
	}
	public Integer getNote() {
		return note;
	}
	public void setNote(Integer note) {
		this.note = note;
	}
	public Photo(Integer idPhoto, String lien, Integer note) {
		super();
		this.idPhoto = idPhoto;
		this.lien = lien;
		this.note = note;
	}
	public Photo() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Photo [idPhoto=" + idPhoto + ", lien=" + lien + ", note=" + note + ", utilisateurPhoto="
				+ utilisateurPhoto + "]";
	}

	@ManyToOne
	private Utilisateur utilisateurPhoto;
	public Utilisateur getUtilisateurPhoto() {
		return utilisateurPhoto;
	}
	public void setUtilisateurPhoto(Utilisateur utilisateurPhoto) {
		this.utilisateurPhoto = utilisateurPhoto;
	}
	public Photo(Integer idPhoto, String lien, Integer note, Utilisateur utilisateurPhoto) {
		super();
		this.idPhoto = idPhoto;
		this.lien = lien;
		this.note = note;
		this.utilisateurPhoto = utilisateurPhoto;
	}
}
