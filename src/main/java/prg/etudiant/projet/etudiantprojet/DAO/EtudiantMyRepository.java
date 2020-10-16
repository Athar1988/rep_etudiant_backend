package prg.etudiant.projet.etudiantprojet.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import prg.etudiant.projet.etudiantprojet.Entity.Etudiant;
import java.util.List;

@RepositoryRestResource
public interface EtudiantMyRepository extends JpaRepository<Etudiant,Long> {
        /*
        Methode num1: avec les conventions fingBy: https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
         */
       /*
       //Chercher un etudiant selon nom
       @RestResource(path="/liste")
        public List<Etudiant> findByNomContains(@Param("nom") String nom);*/

        public List<Etudiant> findByNomContains(String nom);
        /*
        Methode num2: utiliser les requetes avec @Query: https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.at-query
         */
        @Query("select e from Etudiant e where e.nom like :x")
        public List<Etudiant> chercher(@Param("x") String nom);
        }
