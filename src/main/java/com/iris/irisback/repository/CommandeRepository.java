package com.iris.irisback.repository;

import com.iris.irisback.model.Commande;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommandeRepository extends MongoRepository<Commande, String> {

  List<Commande> findCommandeByClientId(String id);

Optional <Commande> findCommandeById(String id);

  Commande findCommandeByClientIdAndNumCmd(String clientId, String numCmd);

  Commande findCommandeByClientNomAndNumCmd(String nomClient, String numCmd);
}
