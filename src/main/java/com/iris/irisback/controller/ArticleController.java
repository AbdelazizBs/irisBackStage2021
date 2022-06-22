package com.iris.irisback.controller;

import com.iris.irisback.dto.ArticleDTO;
import com.iris.irisback.dto.ClientDTO;
import com.iris.irisback.mapper.ClientMapper;
import com.iris.irisback.model.Article;
import com.iris.irisback.model.Client;
import com.iris.irisback.service.ArticleService;
import com.iris.irisback.service.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/article")
@CrossOrigin(origins = "*")
public class ArticleController {

    @Autowired
    ArticleService articleService ;
    @PostMapping("/addArticle")
    public ArticleDTO addArticle(@RequestBody Article article ){
        try {
            return articleService.addArticle(article);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //     return  clientRepository.save(client);
    }

}
