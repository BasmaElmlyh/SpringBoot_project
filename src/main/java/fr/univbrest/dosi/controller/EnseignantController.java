package fr.univbrest.dosi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.univbrest.dosi.bean.Enseignant;
import fr.univbrest.dosi.business.EnseignantBusiness;


@RestController
@RequestMapping("/enseignant")
public class EnseignantController {

	private EnseignantBusiness business;
	
	@Autowired
	public EnseignantController(EnseignantBusiness business) {
		this.business = business;
	}
	
	@RequestMapping(method = RequestMethod.POST) 
	public Enseignant creerEnseignant(@RequestBody Enseignant enseignantACreer) { //
		return business.creerEnseignant(enseignantACreer);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/{id}") 
	public boolean supprimerEnseignant(@PathVariable long id ) { //
		 return business.supprimerEnseignantByID(id);
		 
	}
	
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Enseignant> recupererTousLesEnseignants(){
		 return business.recupererToutEnseignants();
	}
	
	
	@RequestMapping(method = RequestMethod.GET,value="/{id}")
	public Enseignant recupererEnseignantByID(@PathVariable long id ){
		return business.recupererEnseignantByID(id);
	}

	@RequestMapping(method = RequestMethod.GET,value="/nom/{nom}")	
	public List<Enseignant> recupererEnseignantByNom(@PathVariable String nom) {
		return 	business.recupererEnseignantByNom(nom);
	}	
	
	@RequestMapping(method = RequestMethod.GET,value="/email/{email:.+}")	
	public List<Enseignant> recupererEnseignantByEmail(@PathVariable String email) {
		return 	business.recupererEnseignantByEmail(email);
	}	
	
	
}
