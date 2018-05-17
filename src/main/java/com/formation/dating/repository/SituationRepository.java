package com.formation.dating.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.formation.dating.entity.Situation;

@Repository
public interface SituationRepository extends CrudRepository<Situation, Integer> {

}
