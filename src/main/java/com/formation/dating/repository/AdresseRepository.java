package com.formation.dating.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.formation.dating.entity.Adresse;

@Repository
public interface AdresseRepository extends CrudRepository<Adresse, Integer> {

}
