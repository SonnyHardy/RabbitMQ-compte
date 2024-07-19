package com.sonny.ctcompte;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "comptes")
@AllArgsConstructor
public class CompteController {

    private CompteService compteService;

    @PostMapping
    public void enregistrerCompte(@RequestBody Compte compte) {
        this.compteService.enregistrerCompte(compte);
    }
}
