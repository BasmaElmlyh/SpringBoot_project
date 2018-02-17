package fr.univbrest.dosi.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.univbrest.dosi.bean.Promotion;
import fr.univbrest.dosi.bean.PromotionPK;
import fr.univbrest.dosi.business.PromotionBusiness;


@RestController
@RequestMapping("/promotions")
public class PromotionController {

	private PromotionBusiness business;
	
	@Autowired
	public PromotionController(PromotionBusiness business) {
		this.business = business;
	}
	
	@RequestMapping(method = RequestMethod.POST) //methode appeler quand on fair un poste sur la classe candidatController
	public Promotion creerPromotion(@RequestBody Promotion promotionACreer) { //
		return business.creerPromotion(promotionACreer);
	}
	
	@RequestMapping(method = RequestMethod.DELETE) 
	public boolean supprimerPromotion(@RequestBody Promotion promotionASupprimer) { //
		 return business.supprimerPromotion(promotionASupprimer);
		 
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/{codeF}/{annee}") 
	public void supprmierPromotionByID(@PathVariable String codeF,@PathVariable String annee) { //
		 business.supprimerPromotionByID(new PromotionPK(annee,codeF));
		
	}
	
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Promotion> recupererTousLesPromotions(){
		 return business.recupererTousLesPromotions();
	}
	
	
	@RequestMapping(method = RequestMethod.GET,value="/{codeF}/{annee}")
	public Promotion recupererPromotionByID(@PathVariable String codeF,@PathVariable String annee){
		PromotionPK promotionPk = new PromotionPK(annee, codeF);
		return business.recupererPromotionByID(promotionPk);
	}

	@RequestMapping(method = RequestMethod.GET,value="/sigle/{sigle}")	
	public List<Promotion> recupererPromotionBySigle(@PathVariable String sigle) {
		return 	business.recupererPromotionBySigle(sigle);
	}	
	
	@RequestMapping(method = RequestMethod.GET,value="/noEns/{noEns}")	
	public List<Promotion> recupererPromotionByNEns(@PathVariable BigDecimal noEns) {
		return 	business.recupererPromotionByNoEns(noEns);
	}	
	
	
}
