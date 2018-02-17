package fr.univbrest.dosi.business;

import static org.assertj.core.api.Assertions.assertThat;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;


import fr.univbrest.dosi.bean.Formation;
import fr.univbrest.dosi.repositories.FormationRepository;

public class FormationBusinessJPATest {


	
	@Test
	public void doitCreerUneFormation() {
		FormationRepository repos = new FormationRepositoryList();
		FormationBusinessJPA business = new FormationBusinessJPA(repos);
		Formation formationACreer = new Formation("33", "M2","O", BigDecimal.valueOf(2.0), "DOSI");
		
		Formation resultat= business.creerFormation(formationACreer);
		assertThat(resultat.getDebutAccreditation()).isCloseTo(new Date(),500); 
		assertThat(repos.count()).isEqualTo(1);
	}
	
	@Test
	public void doitRechercherParNomFormation() {
		Formation formation = new Formation("1","MASTER","M2", BigDecimal.valueOf(2.0),"DOSI");
		FormationRepository repos = new FormationRepositoryList();
		FormationBusinessJPA business = new FormationBusinessJPA(repos);
		business.creerFormation(formation);
		List<Formation> listFormation = business.rechercherFormationParNom("DOSI");
		
		assertThat(listFormation).hasSize(1);
		assertThat(listFormation.get(0).getNomFormation()).isEqualTo("DOSI");
	
	}
	
	class FormationRepositoryList implements FormationRepository{
		private List<Formation> data;
		public FormationRepositoryList() {
			data = new ArrayList<>();
		}
		
		@Override
		public <S extends Formation> S save(S entity) {
			data.add(entity);
			return entity;
		}
		
		@Override
		public long count() {
			// TODO Auto-generated method stub
			return this.data.size();
		}
		@Override
		public void delete(String arg0) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void delete(Formation arg0) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void delete(Iterable<? extends Formation> arg0) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void deleteAll() {
			// TODO Auto-generated method stub
			
		}
		@Override
		public boolean exists(String arg0) {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public Iterable<Formation> findAll() {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public Iterable<Formation> findAll(Iterable<String> arg0) {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public Formation findOne(String arg0) {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public <S extends Formation> Iterable<S> save(Iterable<S> arg0) {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public List<Formation> findByNomFormation(String nom) {
			List<Formation> listCandidat = new ArrayList<>();
			for (Formation f : data) {
				if(f.getNomFormation().equals(nom)) {
					listCandidat.add(f);
					return listCandidat;
				}
			}
			return null;
		}
	}
	
}
