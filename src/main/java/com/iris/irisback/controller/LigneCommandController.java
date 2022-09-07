package com.iris.irisback.controller;

import com.iris.irisback.model.LigneCommand;
import com.iris.irisback.service.LigneCommandService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/ligneCommand")
@CrossOrigin(origins = "*")
public class LigneCommandController {
    final
    LigneCommandService ligneCommandService ;

    public LigneCommandController(final LigneCommandService ligneCommandService) {
        this.ligneCommandService = ligneCommandService;
    }

    @PostMapping("/addLigneCommand")
    public LigneCommand addArticle(
            @RequestParam final String numCmd,
            @RequestParam final String refIris,
            @RequestParam final String qte,
            @RequestParam final Date delai) {
        return ligneCommandService.addLigneCommand(numCmd,refIris,qte, delai);
    }
    @GetMapping("/getLignCmdByIdArticleAndIdCmd/{idArticle}/{idCmd}")
    public List<LigneCommand> getLignCmdByIdArticleAndIdCmd(
            @PathVariable(value = "idArticle") final String idArticle,
            @PathVariable(value = "idCmd") final String idCmd) {
        return ligneCommandService.getLignCmdByIdArticleAndIdCmd(idArticle,idCmd);
    }
}
