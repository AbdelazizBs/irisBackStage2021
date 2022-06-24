package com.iris.irisback.service;

import com.iris.irisback.dto.ArticleDTO;
import com.iris.irisback.dto.MachineDTO;
import com.iris.irisback.exception.NotFoundException;
import com.iris.irisback.mapper.ArticleMapper;
import com.iris.irisback.mapper.ClientMapper;
import com.iris.irisback.mapper.MachineMapper;
import com.iris.irisback.model.Article;
import com.iris.irisback.model.Client;
import com.iris.irisback.model.Machine;
import com.iris.irisback.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ArticleService {

   @Autowired ArticleRepository articleRepository ;

    public ArticleDTO addArticle(ArticleDTO articleDTO )  throws IOException {
        final Article article = ArticleMapper.MAPPER.toArticle(articleDTO);
        return ArticleMapper.MAPPER.toArticleDTO(articleRepository.save(article));
    }



    public  ArticleDTO updateArticle(ArticleDTO articleDTO , String idArticle)throws IOException{
        return  articleRepository
                .findById(idArticle)
                .map(

                        article -> {
                            article.setCodeArticle(articleDTO.getCodeArticle());
                            article.setDesignation(articleDTO.getDesignation());
                            article.setEtapeProductions(articleDTO.getEtapeProductions());
                            return ArticleMapper.MAPPER.toArticleDTO(articleRepository.save(article));
                        })
                .orElseThrow(() -> new NotFoundException(articleDTO.getId() + " not found"));

    }

    public void deleteArticle(String  idArticle) throws IOException{
        articleRepository.deleteById(idArticle);
    }





}
