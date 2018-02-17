package fr.univbrest.dosi.business;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.univbrest.dosi.bean.Candidat;

@Service
public interface CandidatBusiness {
	
	Candidat creerCandidat(Candidat candidatACreer);
	List<Candidat> findByNom(String nom);
	List<Candidat> findByUniversiteOrigine(String universiteOrigine);
	void supprimerCandidat(Candidat candidatASupprimer);
	List<Candidat> recupererToutLesCandidats();
	List<Candidat> recupererCandidatAvecLeNom(String nom);
	List<Candidat> recupererCandidatAvecUnicersiteOrigine(String nom);
	boolean supprimerCandidatByID(String id);

}
