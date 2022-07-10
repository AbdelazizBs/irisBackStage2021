package com.iris.irisback.repository;

import com.iris.irisback.model.Commande;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommandeRepository extends MongoRepository<Commande, String> {

  List<Commande> findCommandeByClientId(String id);

  Commande findCommandeById(String id);

  Commande findCommandeByClientIdAndNumCmd(String clientId, String numCmd);

  Commande findCommandeByClientNomAndNumCmd(String nomClient, String numCmd);
}
