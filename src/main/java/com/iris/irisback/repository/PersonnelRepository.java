package com.iris.irisback.repository;

import com.iris.irisback.model.Personnel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PersonnelRepository extends MongoRepository<Personnel, String> {
  Optional<Personnel> findPersonnelByLoginAndPassword(String login, String password);

  Personnel findPersonnelByName(String s);

  Personnel findPersonnelById(String id);

  Personnel findPersonnelByLogin(String s);
}
