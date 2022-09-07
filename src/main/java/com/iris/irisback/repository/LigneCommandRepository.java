package com.iris.irisback.repository;

import com.iris.irisback.model.Article;
import com.iris.irisback.model.Commande;
import com.iris.irisback.model.LigneCommand;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LigneCommandRepository extends MongoRepository<LigneCommand,String> {

List<LigneCommand> findLigneCommandByCommandeAndAndArticle(Commande commande, Article article) ;
}
