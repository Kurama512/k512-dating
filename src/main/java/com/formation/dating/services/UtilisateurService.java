package com.formation.dating.services;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.dating.entity.Utilisateur;
import com.formation.dating.repository.UtilisateurRepository;

@Service
public class UtilisateurService {
	
	private final UtilisateurRepository utilisateurRepository;
	
	@Autowired
	public UtilisateurService(UtilisateurRepository utilisateurRepository) {
		this.utilisateurRepository = utilisateurRepository;
	}
	
	public Iterable<Utilisateur> findAll(){
		return utilisateurRepository.findAll();
	}

	public void save(@Valid Utilisateur user) {
		utilisateurRepository.save(user);
		
	}

}
