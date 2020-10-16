package prg.etudiant.projet.etudiantprojet.DAO;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import prg.etudiant.projet.etudiantprojet.Entity.Formation;

import java.util.List;
@RepositoryRestResource
public interface FormationRepository extends JpaRepository<Formation,Long> {
   // public List<Formation> findAllById();
 }
