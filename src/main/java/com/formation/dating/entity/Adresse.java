package com.formation.dating.entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Adresse {
	
	@Id
	@GeneratedValue
	private Integer idAdresse;
	private Integer codePostal;
	private String ville;
	private Integer numero;
	private String typeRue;
	private String nomRue;
	private String complement;
	private String prefixe;
	@OneToMany
	private Collection<Utilisateur> utilisateursAdresse;
	public Integer getIdAdresse() {
		return idAdresse;
	}
	public void setIdAdresse(Integer idAdresse) {
		this.idAdresse = idAdresse;
	}
	public Integer getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(Integer codePostal) {
		this.codePostal = codePostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getTypeRue() {
		return typeRue;
	}
	public void setTypeRue(String typeRue) {
		this.typeRue = typeRue;
	}
	public String getNomRue() {
		return nomRue;
	}
	public void setNomRue(String nomRue) {
		this.nomRue = nomRue;
	}
	public String getComplement() {
		return complement;
	}
	public void setComplement(String complement) {
		this.complement = complement;
	}
	public String getPrefixe() {
		return prefixe;
	}
	public void setPrefixe(String prefixe) {
		this.prefixe = prefixe;
	}
	public Adresse(Integer idAdresse, Integer codePostal, String ville, Integer numero, String typeRue, String nomRue,
			String complement, String prefixe) {
		super();
		this.idAdresse = idAdresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.numero = numero;
		this.typeRue = typeRue;
		this.nomRue = nomRue;
		this.complement = complement;
		this.prefixe = prefixe;
	}
	public Adresse() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Adresse [idAdresse=" + idAdresse + ", codePostal=" + codePostal + ", ville=" + ville + ", numero="
				+ numero + ", typeRue=" + typeRue + ", nomRue=" + nomRue + ", complement=" + complement + ", prefixe="
				+ prefixe + "]";
	}
	
	
}
