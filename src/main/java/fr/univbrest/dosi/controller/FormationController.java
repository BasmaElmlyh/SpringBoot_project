package fr.univbrest.dosi.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.univbrest.dosi.bean.Formation;
import fr.univbrest.dosi.business.FormationBusiness;

@RestController //controller d'api rest de spring
@RequestMapping("/formation") //c'est le controller de la ressouce /formation

public class FormationController {

	private FormationBusiness business;

	@Autowired
	public FormationController(FormationBusiness business) {
		this.business=business;
	}
	
	@RequestMapping(method = RequestMethod.POST) //methode appeler quand on fair un poste sur la classe formationController
	public Formation creerformation(@RequestBody Formation formationACreer) { //
		return business.creerFormation(formationACreer);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Formation> recupererToutesLesFormations(){
		 return business.recupererToutesLesFormations();
	}
	
	
	@RequestMapping(method = RequestMethod.GET, value="/nom/{nom}")
	public List<Formation> recupererFormationAvecLeNom(@PathVariable String nom) {
		return business.rechercherFormationParNom(nom);
	}
	
}
