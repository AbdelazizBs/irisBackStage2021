package com.iris.irisback.service;

import com.iris.irisback.dto.LigneCommandDTO;
import com.iris.irisback.exception.NotFoundException;
import com.iris.irisback.mapper.LignCommandMapper;
import com.iris.irisback.model.Article;
import com.iris.irisback.model.Commande;
import com.iris.irisback.model.LigneCommand;
import com.iris.irisback.repository.ArticleRepository;
import com.iris.irisback.repository.CommandeRepository;
import com.iris.irisback.repository.LigneCommandRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LigneCommandService {
    final LigneCommandRepository ligneCommandRepository;
    final CommandeRepository commandeRepository;
    final ArticleRepository articleRepository ;
    public LigneCommandService(final LigneCommandRepository ligneCommandRepository, final CommandeRepository commandeRepository, final ArticleRepository articleRepository) {
        this.ligneCommandRepository = ligneCommandRepository;
        this.commandeRepository = commandeRepository;
        this.articleRepository = articleRepository;
    }
    public LigneCommand addLigneCommand(
            final String numCmd,
            final String refIris,
            final String qte,
            final Date delai) {
        final LigneCommandDTO ligneCommandDTO  = new LigneCommandDTO();
        ligneCommandDTO.setRefIris(refIris);
        ligneCommandDTO.setNumCmd(numCmd);
        ligneCommandDTO.setQte(qte);
        ligneCommandDTO.setDelai(delai);
        final LigneCommand ligneCommand = LignCommandMapper.MAPPER.toLigneCommand(ligneCommandDTO);
        final Commande commande = commandeRepository.findCommandeByNumCmd(numCmd).orElseThrow(() -> new NotFoundException(numCmd + " not found"));
        final Article article = articleRepository.findArticleByRefIris(refIris).orElseThrow(() -> new NotFoundException(refIris + " not found"));
        ligneCommand.setCommande(commande);
        ligneCommand.setArticle(article);
        return ligneCommandRepository.save(ligneCommand);
    }
    public List<LigneCommand> getLignCmdByIdArticleAndIdCmd(
            final String idArticle,
            final String idCmd) {
        final Article article = articleRepository.findArticleById(idArticle).orElseThrow(() -> new NotFoundException(idArticle + " not found"));
        final Commande commande  = commandeRepository.findCommandeById(idCmd).orElseThrow(() -> new NotFoundException(idCmd + " not found"));
        return ligneCommandRepository.findLigneCommandByCommandeAndAndArticle(commande,article);
    }



}
