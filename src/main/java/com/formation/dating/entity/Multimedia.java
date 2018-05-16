package com.formation.dating.entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Multimedia {
		
		@Id
		@GeneratedValue
		private Integer idMultimedia;
		private String typeMultimedia;
		private String genre;
		private String titre;
		private String artiste;
		public Integer getIdMultimedia() {
			return idMultimedia;
		}
		public void setIdMultimedia(Integer idMultimedia) {
			this.idMultimedia = idMultimedia;
		}
		public String getTypeMultimedia() {
			return typeMultimedia;
		}
		public void setTypeMultimedia(String typeMultimedia) {
			this.typeMultimedia = typeMultimedia;
		}
		public String getGenre() {
			return genre;
		}
		public void setGenre(String genre) {
			this.genre = genre;
		}
		public String getTitre() {
			return titre;
		}
		public void setTitre(String titre) {
			this.titre = titre;
		}
		public String getArtiste() {
			return artiste;
		}
		public void setArtiste(String artiste) {
			this.artiste = artiste;
		}
		public Multimedia(Integer idMultimedia, String typeMultimedia, String genre, String titre, String artiste) {
			super();
			this.idMultimedia = idMultimedia;
			this.typeMultimedia = typeMultimedia;
			this.genre = genre;
			this.titre = titre;
			this.artiste = artiste;
		}
		public Multimedia() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			return "Multimedia [idMultimedia=" + idMultimedia + ", typeMultimedia=" + typeMultimedia + ", genre="
					+ genre + ", titre=" + titre + ", artiste=" + artiste + ", centreInteretMultimedia="
					+ centreInteretMultimedia + "]";
		}
		
		@ManyToMany
		private Collection<CentreInteret> centreInteretMultimedia;
		public Collection<CentreInteret> getCentreInteretMultimedia() {
			return centreInteretMultimedia;
		}
		public void setCentreInteretMultimedia(Collection<CentreInteret> centreInteretMultimedia) {
			this.centreInteretMultimedia = centreInteretMultimedia;
		}
		public Multimedia(Integer idMultimedia, String typeMultimedia, String genre, String titre, String artiste,
				Collection<CentreInteret> centreInteretMultimedia) {
			super();
			this.idMultimedia = idMultimedia;
			this.typeMultimedia = typeMultimedia;
			this.genre = genre;
			this.titre = titre;
			this.artiste = artiste;
			this.centreInteretMultimedia = centreInteretMultimedia;
		}
}
