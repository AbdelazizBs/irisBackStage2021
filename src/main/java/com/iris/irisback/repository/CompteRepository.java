package com.iris.irisback.repository;

import com.iris.irisback.model.Compte;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompteRepository extends MongoRepository<Compte, String> {
 Optional <Compte> findCompteByEmail(String email);

  Optional<Compte> findCompteByEmailAndPassword(String email, String password);
}
