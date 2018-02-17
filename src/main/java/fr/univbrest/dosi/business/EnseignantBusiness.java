package fr.univbrest.dosi.business;

import java.util.List;

import fr.univbrest.dosi.bean.Enseignant;

public interface EnseignantBusiness {
	
	
	Enseignant creerEnseignant(Enseignant enseignantACreer);
	
	boolean supprimerEnseignantByID(long id);
	
	List<Enseignant> recupererToutEnseignants();
	
	Enseignant recupererEnseignantByID(long numero);
	
	List<Enseignant> recupererEnseignantByNom(String nom);
	
	List<Enseignant> recupererEnseignantByEmail(String nom);
	

}
