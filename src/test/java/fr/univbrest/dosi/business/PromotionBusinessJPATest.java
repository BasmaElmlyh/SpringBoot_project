package fr.univbrest.dosi.business;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.Test;

import fr.univbrest.dosi.bean.Promotion;
import fr.univbrest.dosi.bean.PromotionPK;
import fr.univbrest.dosi.repositories.PromotionRepository;


public class PromotionBusinessJPATest {
	PromotionBusinessJPA business;
	
	@Test
	public void doitCreerUneFomation() {
		 PromotionRepository repos = new  PromotionRepositoryList();
		 business = new PromotionBusinessJPA(repos);
		 Promotion promotionACreer = new Promotion(new PromotionPK("2014-2015","M2DOSI"), "DOSI6");		
		 Promotion resultat = business.creerPromotion(promotionACreer);
		  Long res=  repos.count();
		  assertThat(res).isEqualTo(1);
	}
  @Test
	public void doitSupprimerUnPromotion() {
	  PromotionRepository repos = new  PromotionRepositoryList();
		 business = new PromotionBusinessJPA(repos);
		 Promotion promotionACreer =  new Promotion(new PromotionPK("2014-2015","M2DOSI"), "DOSI6");
		 business.creerPromotion(promotionACreer);
		 boolean res = business.supprimerPromotion(promotionACreer);
			assertThat(res).isEqualTo(true);
	}
  @Test
	public void doitChercherUnPromotionParSigle() {
	  PromotionRepository repos = new  PromotionRepositoryList();
		 business = new PromotionBusinessJPA(repos);
		 Promotion promotionACreer = new Promotion(new PromotionPK("2014-2015","M2DOSI"), "DOSI6");		
		 business.creerPromotion( promotionACreer);
		 List< Promotion> resultat =  business.recupererPromotionBySigle("DOSI6");
			assertThat(resultat).hasSize(1);
			assertThat(resultat.get(0).getId().getAnneeUniversitaire()).isEqualTo("2014-2015");
			assertThat(resultat.get(0).getId().getCodeFormation()).isEqualTo("M2DOSI");
	}
  
}
class PromotionRepositoryList implements PromotionRepository{


	private List<Promotion> data;
	
	public PromotionRepositoryList (){
		data = Lists.newArrayList();
	}

	@Override
	public long count() {
		return data.size();
	}

	@Override
	public void delete(PromotionPK arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Promotion entity) {
		data.remove(entity);
		
	}

	@Override
	public void delete(Iterable<? extends Promotion> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean exists(PromotionPK arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Promotion> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Promotion> findAll(Iterable<PromotionPK> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Promotion findOne(PromotionPK arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Promotion> S save(S entity) {
		data.add(entity);
		return entity;

	}

	@Override
	public <S extends Promotion> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Promotion> findBySiglePromotion(String siglePromotion) {
		List<Promotion> data2=Lists.newArrayList();
		for (int i = 0; i < data.size(); i++) {
			if(data.get(i).getSiglePromotion().equals(siglePromotion)) {
				data2.add(data.get(i));
				return data2;
			}
		}
		return null;
	}

	@Override
	public List<Promotion> findByNoEnseignant(BigDecimal numero) {
		List<Promotion> data2=Lists.newArrayList();
		for (int i = 0; i < data.size(); i++) {
			if(data.get(i).getSiglePromotion().equals(numero)) {
				data2.add(data.get(i));
				return data2;
			}
		}
		return null;
	}
	
	
	
}
