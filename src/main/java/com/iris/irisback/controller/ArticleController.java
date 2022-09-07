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
      @RequestParam final String clientName,
      @RequestParam final String designation,
      @RequestParam final String idOf,
      @RequestParam final List<String> nomEtapeProductions) {
    return articleService.addArticle(refIris,designation, refClient,clientName,idOf, nomEtapeProductions);
  }



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


  @GetMapping("/getArticleByIdClient/{idClient}")
  public List<ArticleDTO> getArticleByIdClient(@PathVariable(value = "idClient") final String idClient){
    return articleService.getArticleByIdClient(idClient);
  }
  @GetMapping("/getListArticleClientByNomClient/{nomClient}")
  public List<ArticleDTO> getListArticleClientByNomClient(@PathVariable(value = "nomClient") final String nomClient){
    return articleService.getArticleByNomClient(nomClient);
  }
  @GetMapping("/{idCmd}")
  public List<ArticleDTO> getArticlesByIdCommande(@PathVariable(value = "idCmd") final String idCmd){
    return articleService.getArticlesByIdCommande(idCmd);
  }
  @PutMapping("/updateArticle/{idArticle}")
  public ArticleDTO updateArticle(
      @RequestParam final String refIris,
      @RequestParam final String refClient,
      @RequestParam final String clientName,
      @RequestParam final String designation,
      @RequestParam final String idOf,
      @RequestParam final List<String> nomEtapeProductions,
      @PathVariable(value = "idArticle") final String idArticle) {
    return articleService.updateArticle(refIris,designation, refClient,clientName,idOf, nomEtapeProductions, idArticle);
  }
  @PutMapping("/addToClient/{nomClient}/{idArticle}")
  public ArticleDTO addToClient(  @PathVariable(value = "idArticle") final String idArticle,@PathVariable(value = "nomClient") final String nomClient
                                ) {
    return articleService.addToClient(idArticle,nomClient);
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
  @GetMapping("/getListArticlesNonLiee")
  public List<ArticleDTO> getListArticlesNonLiée() {
    return articleService.getListArticlesNonLiée();
  }
}
