package com.formation.dating.services;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.dating.entity.Apparence;
import com.formation.dating.entity.Utilisateur;
import com.formation.dating.repository.ApparenceRepository;
@Service
public class ApparenceService {

private final ApparenceRepository apparenceRepository;
	
	@Autowired
	public ApparenceService(ApparenceRepository apparenceRepository) {
		this.apparenceRepository = apparenceRepository;
	}
	
	public Iterable<Apparence> findAll(){
		return apparenceRepository.findAll();
	}

	public void save(Apparence apparence) {
		apparenceRepository.save(apparence);
		
	}
}
