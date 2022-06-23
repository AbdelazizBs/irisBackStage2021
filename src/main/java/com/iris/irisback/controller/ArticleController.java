package com.iris.irisback.controller;

import com.iris.irisback.dto.ArticleDTO;
import com.iris.irisback.dto.ClientDTO;
import com.iris.irisback.dto.MachineDTO;
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
    public ArticleDTO addArticle(@RequestBody ArticleDTO articleDTO  ) throws IOException {
            return articleService.addArticle(articleDTO);
        //     return  clientRepository.save(client);
    }

    @PutMapping("/updateArticle/{idArticle}")
    public ArticleDTO updateArticle(@RequestBody ArticleDTO articleDTO , @PathVariable(value = "idArticle") String  idArticle ) throws IOException {
        return articleService.updateArticle(articleDTO,idArticle);
    }

    @DeleteMapping("/deleteArticle/{idArticle}")
    public  void deleteArticle(@PathVariable(value = "idArticle") String  idArticle ) throws IOException {
        articleService.deleteArticle(idArticle);
    }


}
