package fr.univbrest.dosi.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.univbrest.dosi.bean.Promotion;
import fr.univbrest.dosi.bean.PromotionPK;

@Repository
public interface PromotionRepository extends CrudRepository<Promotion, PromotionPK> {
	
	List<Promotion> findBySiglePromotion(String siglePromotion);
	List<Promotion> findByNoEnseignant(BigDecimal numero);
	
}
