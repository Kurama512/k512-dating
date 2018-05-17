package com.formation.dating.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.dating.entity.Adresse;
import com.formation.dating.entity.Situation;
import com.formation.dating.repository.AdresseRepository;
import com.formation.dating.repository.SituationRepository;
@Service
public class SituationService {
	
private final SituationRepository situationRepository;
	
	@Autowired
	public SituationService(SituationRepository situationRepository) {
		this.situationRepository = situationRepository;
	}
	
	public Iterable<Situation> findAll(){
		return situationRepository.findAll();
	}

	public void save(Situation situation) {
		situationRepository.save(situation);	
	}

}
