package com.iris.irisback.repository;

import com.iris.irisback.model.Article;
import com.iris.irisback.model.Client;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends MongoRepository<Article,String > {
    Article findArticleById(String id);
}
