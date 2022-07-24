package com.iris.irisback.controller;

import com.iris.irisback.dto.ArticleDTO;
import com.iris.irisback.service.ArticleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
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

  @GetMapping("/getArticleByRefIris/{refIris}")
  public ArticleDTO getArticleByCodeArticle(@PathVariable(value = "refIris") final String refIris)
      throws IOException {
    return articleService.getArticleByCodeArticle(refIris);
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
      @RequestParam final String refIris,
      @RequestParam final String refClient,
      @RequestParam final List<String> nomEtapeProductions,
      @PathVariable(value = "idArticle") final String idArticle)
      throws IOException {
    return articleService.updateArticle(refIris, refClient, nomEtapeProductions, idArticle);
  }

  @DeleteMapping("/deleteArticle/{idArticle}")
  public ResponseEntity<Void> deleteArticle(
      @PathVariable(value = "idArticle") final String idArticle) throws IOException {
    articleService.deleteArticle(idArticle);
    return ResponseEntity.noContent().build();
  }

  @GetMapping("/getRefIris")
  public List<String> getRefIris() throws IOException {
    return articleService.getRefIris();
  }
}
