package com.iris.irisback.controller;

import com.iris.irisback.dto.ArticleDTO;
import com.iris.irisback.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/article")
@CrossOrigin(origins = "*")
public class ArticleController {

  @Autowired ArticleService articleService;

  @PostMapping("/addArticle")
  public ArticleDTO addArticle(
      @RequestParam final String codeArticle,
      @RequestParam final String designation,
      @RequestParam final List<String> nomEtapeProductions)
      throws IOException {
    return articleService.addArticle(codeArticle, designation, nomEtapeProductions);
    //     return  clientRepository.save(client);
  }

  @GetMapping("/getArticleByCodeArticle/{codeArticle}")
  public ArticleDTO getArticleByCodeArticle(
      @PathVariable(value = "codeArticle") final String codeArticle) throws IOException {
    return articleService.getArticleByCodeArticle(codeArticle);
  }

  @GetMapping("/getArticleById/{idArticle}")
  public ArticleDTO getArticleById(@PathVariable(value = "idArticle") final String idArticle)
      throws IOException {
    return articleService.getArticleById(idArticle);
  }

  @GetMapping("/articles")
  List<ArticleDTO> articles() throws IOException {
    return articleService.articles();
  }

  @PutMapping("/updateArticle/{idArticle}")
  public ArticleDTO updateArticle(
      @RequestParam final String codeArticle,
      @RequestParam final String designation,
      @RequestParam final List<String> nomEtapeProductions,
      @PathVariable(value = "idArticle") final String idArticle)
      throws IOException {
    return articleService.updateArticle(codeArticle, designation, nomEtapeProductions, idArticle);
  }

  @DeleteMapping("/deleteArticle/{idArticle}")
  public ResponseEntity<Void> deleteArticle(
      @PathVariable(value = "idArticle") final String idArticle) throws IOException {
    articleService.deleteArticle(idArticle);
    return ResponseEntity.noContent().build();
  }
}
