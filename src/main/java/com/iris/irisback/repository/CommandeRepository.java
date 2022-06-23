package com.iris.irisback.repository;

import com.iris.irisback.model.Commande;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommandeRepository extends MongoRepository<Commande,String> {

    @Query(value="{ 'id' : ?0 }")
    List<Commande> findCommandeByClientId(String id);


}
