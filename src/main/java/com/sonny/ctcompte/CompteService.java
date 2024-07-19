package com.sonny.ctcompte;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CompteService {

    private RabbitMQService rabbitMQService;

    public void enregistrerCompte(Compte compte) {
        // Traitements
        // Validation
        // Mapping
        // Sauvegarde

        this.rabbitMQService.publier(compte);
    }
}
