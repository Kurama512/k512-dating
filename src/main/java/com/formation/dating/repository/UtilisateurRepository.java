package com.formation.dating.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.formation.dating.entity.Utilisateur;

@Repository
public interface UtilisateurRepository extends CrudRepository<Utilisateur, String>{
	
	public Iterable<Utilisateur> findAll();
	public Utilisateur findUtilisateurByEmailUtilisateurAndMotDePasse(String email, String password);
	
}
