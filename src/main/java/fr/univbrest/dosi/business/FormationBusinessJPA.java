package fr.univbrest.dosi.business;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.univbrest.dosi.bean.Formation;
import fr.univbrest.dosi.repositories.FormationRepository;


@Component
public class FormationBusinessJPA implements FormationBusiness{
	
	
	private FormationRepository formationrepos;
	
	@Autowired
	public FormationBusinessJPA(FormationRepository formationrepos) {
		this.formationrepos =  formationrepos;
	}
	

	@Override
	public Formation creerFormation(Formation formationACreer) {
		
		formationACreer.setDebutAccreditation(new Date());
		return formationrepos.save(formationACreer);
		
	}

	
	@Override
	public List<Formation> rechercherFormationParNom(String nom) {
		return formationrepos.findByNomFormation(nom);
	}


	@Override
	public List<Formation> recupererToutesLesFormations() {
		// TODO Auto-generated method stub
		return (List<Formation>) formationrepos.findAll();
	}


	@Override
	public List<Formation> recupererFormationAvecLeNom(String nom) {
		
		return formationrepos.findByNomFormation(nom);
	}
	
	
	
	
	
}
