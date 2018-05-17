package com.formation.dating.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.formation.dating.entity.Apparence;
@Repository
public interface ApparenceRepository  extends CrudRepository<Apparence, Integer> {

}
