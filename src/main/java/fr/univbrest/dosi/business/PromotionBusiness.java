package fr.univbrest.dosi.business;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import fr.univbrest.dosi.bean.Promotion;
import fr.univbrest.dosi.bean.PromotionPK;


public interface PromotionBusiness {

	Promotion creerPromotion(Promotion promotionACreer);

	boolean supprimerPromotion(Promotion promotionASupprimer);
	
	void supprimerPromotionByID(PromotionPK id);

	List<Promotion> recupererTousLesPromotions();

	Promotion recupererPromotionByID(PromotionPK promotionPK);
	
	List<Promotion> recupererPromotionBySigle(String sigle);

	List<Promotion> recupererPromotionByNoEns(BigDecimal numero);

}
