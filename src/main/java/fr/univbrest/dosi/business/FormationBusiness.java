package fr.univbrest.dosi.business;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.univbrest.dosi.bean.Formation;
@Service
public interface FormationBusiness {
	
	Formation creerFormation(Formation formationACreer);

	List<Formation> rechercherFormationParNom(String nom);

	List<Formation> recupererToutesLesFormations();
	
	List<Formation> recupererFormationAvecLeNom(String nom);

}
