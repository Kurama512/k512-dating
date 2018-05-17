package com.formation.dating.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.dating.entity.Adresse;
import com.formation.dating.entity.Apparence;
import com.formation.dating.repository.AdresseRepository;
import com.formation.dating.repository.ApparenceRepository;
@Service
public class AdresseService {

private final AdresseRepository adresseRepository;
	
	@Autowired
	public AdresseService(AdresseRepository adresseRepository) {
		this.adresseRepository = adresseRepository;
	}
	
	public Iterable<Adresse> findAll(){
		return adresseRepository.findAll();
	}

	public void save(Adresse adresse) {
		adresseRepository.save(adresse);
		
	}

}
