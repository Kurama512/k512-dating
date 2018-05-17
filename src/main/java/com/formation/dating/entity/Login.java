package com.formation.dating.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.formation.dating.services.UtilisateurService;

public class Login {
	@NotNull
	@NotBlank
	private String email;
	@NotNull
	@NotBlank
	private String password;
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Login(@NotNull @NotBlank String email, @NotNull @NotBlank String password) {
		super();
		this.email = email;
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = UtilisateurService.get_SHA_512_SecurePassword(password);
	}
}
