package com.iris.irisback.service;

import com.iris.irisback.dto.ArticleDTO;
import com.iris.irisback.dto.MachineDTO;
import com.iris.irisback.mapper.ArticleMapper;
import com.iris.irisback.mapper.MachineMapper;
import com.iris.irisback.model.Article;
import com.iris.irisback.model.Machine;
import com.iris.irisback.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ArticleService {

   @Autowired ArticleRepository articleRepository ;

    public ArticleDTO addArticle(Article article)  throws IOException {
        return ArticleMapper.MAPPER.toArticleDTO(articleRepository.save(article));
    }

}
