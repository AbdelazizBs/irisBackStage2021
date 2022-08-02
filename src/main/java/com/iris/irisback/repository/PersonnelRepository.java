package com.iris.irisback.repository;

import com.iris.irisback.model.Compte;
import com.iris.irisback.model.Personnel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonnelRepository extends MongoRepository<Personnel, String> {
  //  Optional<Personnel> findPersonnelByNameAndPassword(String name, String password);

  //  @Query("{login:'?0'}")
  //  Personnel findPersonnelByLogin(String login);

  //  Personnel findPersonnelByName(String s);

  Personnel findPersonnelById(String id);

  Optional<Personnel> findPersonnelByCompte(Compte compte);

  Personnel findPersonnelByName(String s);
}
