package fr.univbrest.dosi.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.univbrest.dosi.bean.Candidat;
import fr.univbrest.dosi.repositories.CandidatRepository;

@Component
public class CandidatBusinessJPA implements CandidatBusiness{
	
		private CandidatRepository candidatrepos;
		
		@Autowired
		public CandidatBusinessJPA(CandidatRepository candidatrepos) {
			this.candidatrepos =  candidatrepos;
		}
	
		@Override
		public Candidat creerCandidat(Candidat candidatACreer) {
			
			return candidatrepos.save(candidatACreer);
			
		}
		
		@Override
		public List<Candidat> findByNom(String nom){
			
			return candidatrepos.findByNom(nom);
		}
		
		@Override
		public List<Candidat> findByUniversiteOrigine(String universiteOrigine){
			
			return candidatrepos.findByUniversiteOrigine(universiteOrigine);
		}
		
		@Override
		public void supprimerCandidat(Candidat candidatASupprimer) {
			
			 candidatrepos.delete(candidatASupprimer);
		}

		@Override
		public List<Candidat> recupererToutLesCandidats() {
			return (List<Candidat>) candidatrepos.findAll();
		}

		@Override
		public List<Candidat> recupererCandidatAvecLeNom(String nom) {
			return candidatrepos.findByNom(nom);
		}

		@Override
		public List<Candidat> recupererCandidatAvecUnicersiteOrigine(String universiteOrigine) {
			return candidatrepos.findByUniversiteOrigine(universiteOrigine);
		}

		@Override
		public boolean supprimerCandidatByID(String id) {
			candidatrepos.delete(id);
			return true;
		}

}
