package com.iris.irisback.controller;

import com.iris.irisback.dto.ArticleDTO;
import com.iris.irisback.service.ArticleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/article")
@CrossOrigin(origins = "*")
public class ArticleController {

  private final ArticleService articleService;

  public ArticleController(final ArticleService articleService) {
    this.articleService = articleService;
  }

  @PostMapping("/addArticle")
  public ArticleDTO addArticle(
      @RequestParam final String refIris,
      @RequestParam final String refClient,
      @RequestParam final List<String> nomEtapeProductions) {
    return articleService.addArticle(refIris, refClient, nomEtapeProductions);
  }
// add put method to update article and add a new one refArticle get from path variable



  @GetMapping("/getArticleByRefIris/{refIris}")
  public ArticleDTO getArticleByCodeArticle(@PathVariable(value = "refIris") final String refIris) {
    return articleService.getArticleByCodeArticle(refIris);
  }

  @GetMapping("/getArticleById/{idArticle}")
  public ArticleDTO getArticleById(@PathVariable(value = "idArticle") final String idArticle) {
    return articleService.getArticleById(idArticle);
  }

  @GetMapping("/articles")
  List<ArticleDTO> articles() {
    return articleService.articles();
  }

  @PutMapping("/updateArticle/{idArticle}")
  public ArticleDTO updateArticle(
      @RequestParam final String refIris,
      @RequestParam final String refClient,
      @RequestParam final List<String> nomEtapeProductions,
      @PathVariable(value = "idArticle") final String idArticle) {
    return articleService.updateArticle(refIris, refClient, nomEtapeProductions, idArticle);
  }

  @DeleteMapping("/deleteArticle/{idArticle}")
  public ResponseEntity<Void> deleteArticle(
      @PathVariable(value = "idArticle") final String idArticle) {
    articleService.deleteArticle(idArticle);
    return ResponseEntity.noContent().build();
  }

  @GetMapping("/getRefIris")
  public List<String> getRefIris() {
    return articleService.getRefIris();
  }
  @GetMapping("/getListArticlesNonLiée")
  public List<String> getListArticlesNonLiée() {
    return articleService.getListArticlesNonLiée();
  }
}
