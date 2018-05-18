package com.formation.dating.repository;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.formation.dating.entity.Photo;
import com.formation.dating.entity.Utilisateur;
@Repository
public interface PhotoRepository extends CrudRepository<Photo, Integer>{
	
	public List<Photo> findByUtilisateurPhoto(@Valid Utilisateur user); 
	
}
