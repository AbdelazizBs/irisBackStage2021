package com.iris.irisback.repository;

import com.iris.irisback.model.Personnel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonnelRepository extends MongoRepository<Personnel, String> {
  Personnel findPersonnelByLoginAndPassword(String login, String password);

  Personnel findPersonnelById(String id);

  Personnel findPersonnelByLogin(String s);
}
