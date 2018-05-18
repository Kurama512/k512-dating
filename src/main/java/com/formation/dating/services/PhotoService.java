package com.formation.dating.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.dating.entity.Photo;
import com.formation.dating.entity.Utilisateur;
import com.formation.dating.repository.PhotoRepository;


@Service
public class PhotoService {
	
	private final PhotoRepository photoRepository;
	
	@Autowired
	public PhotoService(PhotoRepository photoRepository) {
		this.photoRepository = photoRepository;
	}
	
	public Photo saveOne(Photo photo){
		return photoRepository.save(photo);
	}

	public List<Photo> findByUtilisateurPhoto(@Valid Utilisateur user) {
		
		return photoRepository.findByUtilisateurPhoto(user);
	}

}
