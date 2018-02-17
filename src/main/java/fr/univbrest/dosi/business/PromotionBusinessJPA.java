package fr.univbrest.dosi.business;


import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.univbrest.dosi.bean.Promotion;
import fr.univbrest.dosi.bean.PromotionPK;
import fr.univbrest.dosi.repositories.PromotionRepository;

@Service
public class PromotionBusinessJPA implements PromotionBusiness {

	private PromotionRepository promotionrepos;
	
	@Autowired 
	public PromotionBusinessJPA(PromotionRepository promotionrepos) {
		this.promotionrepos = promotionrepos;
	}

	@Override
	public Promotion creerPromotion(Promotion promotionACreer) {
		return promotionrepos.save(promotionACreer);
	}
	
	@Override
	public boolean supprimerPromotion(Promotion promotionASupprimer) {
		promotionrepos.delete(promotionASupprimer);
		return true;
		
	}
	
	@Override
	public void supprimerPromotionByID(PromotionPK id) {
		
		promotionrepos.delete(id);
		
	}
	
	@Override
	public List<Promotion> recupererTousLesPromotions() {
		return (List<Promotion>) promotionrepos.findAll();
		
	}

	@Override
	public Promotion recupererPromotionByID(PromotionPK id) {
		return  promotionrepos.findOne(id);
		
	}

	@Override
	public List<Promotion> recupererPromotionBySigle(String sigle) {
		return promotionrepos.findBySiglePromotion(sigle);
	}
	
	@Override
	public List<Promotion> recupererPromotionByNoEns(BigDecimal numero) {
		return promotionrepos.findByNoEnseignant(numero);
	}

	
}
