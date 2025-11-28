package org.simplecash;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.simplecash.entity.*;
import org.simplecash.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProjetMazghiYasmineApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjetMazghiYasmineApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ClientRepository clientRepo,
                            ConseillerRepository conseillerRepo,
                            CompteRepository compteRepo) {
        return args -> {
            //-- Remplir DB ---

            // Creation d'un conseiller
            Conseiller conseiller = new Conseiller();
            conseiller.setNom("Yass");
            conseiller.setPrenom("Laboss");
            conseillerRepo.save(conseiller);

            // Creation d'un client
            Client client = new Client();
            client.setNom("Hiba");
            client.setPrenom("IAZZA");
            client.setAdresse("PARISSSS");
            client.setConseiller(conseiller); // Son conseiller c'est yass
            clientRepo.save(client);

            // Creation d'un client 2
            Client client2 = new Client();
            client2.setNom("Safia");
            client2.setPrenom("FIRITI");
            client2.setAdresse("PARISSSS");
            client2.setConseiller(conseiller); // Son conseiller c'est yass
            clientRepo.save(client2);

            // Comptes de hiba
            CompteCourant c1 = new CompteCourant();
            c1.setNumeroCompte("01");
            c1.setSolde(10.0); // Elle a 10 euros miskine
            c1.setClient(client);
            c1.setDecouvertAutorise(500.0);
            compteRepo.save(c1);

            CompteEpargne c2 = new CompteEpargne();
            c2.setNumeroCompte("02");
            c2.setSolde(100.0); // Elle  a 100€
            c2.setClient(client);
            c2.setTauxRemuneration(0.02);
            compteRepo.save(c2);


            // Comptes de Safia
            CompteCourant c3 = new CompteCourant();
            c1.setNumeroCompte("03");
            c1.setSolde(1000.0); // Elle a 1000 euros
            c1.setClient(client);
            c1.setDecouvertAutorise(500.0);
            compteRepo.save(c1);

            CompteEpargne c4 = new CompteEpargne();
            c2.setNumeroCompte("04");
            c2.setSolde(100.0); // Elle  a 100€
            c2.setClient(client);
            c2.setTauxRemuneration(0.02);
            compteRepo.save(c2);
            System.out.println(">>> DONNES POUR TESTER OK <<<");
        };
    }
}
