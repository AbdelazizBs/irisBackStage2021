package com.iris.irisback.repository;

import com.iris.irisback.model.Article;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends MongoRepository<Article, String> {
  Article findArticleById(String id);

  Article findArticleByRefIris(String refIris);
  List <Article> findArticleByRefClient(String s);
}
