package com.iris.irisback.controller;

import com.iris.irisback.dto.ArticleDTO;
import com.iris.irisback.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/article")
@CrossOrigin(origins = "*")
public class ArticleController {

  @Autowired ArticleService articleService;

  @PostMapping("/addArticle")
  public ArticleDTO addArticle(@RequestBody final ArticleDTO articleDTO) throws IOException {
    return articleService.addArticle(articleDTO);
    //     return  clientRepository.save(client);
  }

  @PutMapping("/updateArticle/{idArticle}")
  public ArticleDTO updateArticle(
          @RequestBody final ArticleDTO articleDTO, @PathVariable(value = "idArticle") final String idArticle)
      throws IOException {
    return articleService.updateArticle(articleDTO, idArticle);
  }

  @DeleteMapping("/deleteArticle/{idArticle}")
  public ResponseEntity<Void> deleteArticle(@PathVariable(value = "idArticle") final String idArticle)
      throws IOException {
    articleService.deleteArticle(idArticle);
    return ResponseEntity.noContent().build();
  }
}
