package com.iris.irisback.repository;

import com.iris.irisback.model.Article;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArticleRepository extends MongoRepository<Article, String> {
Optional  <Article> findArticleById(String id);

 Optional <Article> findArticleByRefIris(String refIris);
}
