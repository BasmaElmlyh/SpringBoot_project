package fr.univbrest.dosi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.univbrest.dosi.bean.Candidat;
import fr.univbrest.dosi.business.CandidatBusiness;


@RestController
@RequestMapping("/candidat")
public class CandidatController {

	private CandidatBusiness business;
	
	@Autowired
	public CandidatController(CandidatBusiness business) {
		this.business = business;
	}
	
	@RequestMapping(method = RequestMethod.POST) //methode appeler quand on fair un poste sur la classe candidatController
	public Candidat creercandidat(@RequestBody Candidat candidatACreer) { //
		return business.creerCandidat(candidatACreer);
	}
	
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Candidat> recupererToutesLesCandidats(){
		 return business.recupererToutLesCandidats();
	}
	
	
	@RequestMapping(method = RequestMethod.GET, value="/nom/{nom}")
	public List<Candidat> recupererCandidatAvecLeNom(@PathVariable String nom) {
		return business.recupererCandidatAvecLeNom(nom);
	}
	
	
	@RequestMapping(method = RequestMethod.GET, value="/universite/{universiteOrigine}")
	public List<Candidat> recupererCandidatAvecUnicersiteOrigine(@PathVariable String universiteOrigine) {
		return business.recupererCandidatAvecUnicersiteOrigine(universiteOrigine);
	}
	
	
	@RequestMapping(method = RequestMethod.DELETE, value="/{id}") 
	public boolean supprmierCandidatByID(@PathVariable String id) { //
		return business.supprimerCandidatByID(id);
	}
	
}
