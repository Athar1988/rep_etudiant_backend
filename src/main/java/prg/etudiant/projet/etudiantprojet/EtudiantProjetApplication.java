package prg.etudiant.projet.etudiantprojet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import prg.etudiant.projet.etudiantprojet.DAO.EtudiantMyRepository;
import prg.etudiant.projet.etudiantprojet.DAO.FormationRepository;
import prg.etudiant.projet.etudiantprojet.Entity.Etudiant;
import prg.etudiant.projet.etudiantprojet.Entity.Formation;

import java.util.Date;


@SpringBootApplication
public class EtudiantProjetApplication implements CommandLineRunner {

    @Autowired
    private RepositoryRestConfiguration repConfig;
    @Autowired
    private EtudiantMyRepository iEtudiantrepository;
    @Autowired
    private FormationRepository iFormationrepository;
    public static void main(String[] args) { SpringApplication.run(EtudiantProjetApplication.class, args);
    }

     @Override
    public void run(String... args) throws Exception {
       repConfig.exposeIdsFor(Etudiant.class,Formation.class);
       /*
       Ajoute des Formations
        */
         iFormationrepository.save(new Formation(null,"JAVA",120,null));
         iFormationrepository.save(new Formation(null,"Spring",30,null));
         iFormationrepository.save(new Formation(null,"Angular",58,null));
       /*
       Ajoute des Etudiants
        */
        iEtudiantrepository.save(new Etudiant(null, "Ali", "Ben salah", new Date(),null));
        iEtudiantrepository.save(new Etudiant(null, "Mohamed", "Bourcheni", new Date(),null));
        iEtudiantrepository.save(new Etudiant(null, "Rim", "Loukil", new Date(),null));
        iEtudiantrepository.save(new Etudiant(null, "Amira", "Hakim", new Date(),null));
        iEtudiantrepository.findAll().forEach(p->{
            System.out.println(p.toString());
        });
    }


}
