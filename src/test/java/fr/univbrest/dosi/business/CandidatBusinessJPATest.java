package fr.univbrest.dosi.business;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fr.univbrest.dosi.bean.Candidat;
import fr.univbrest.dosi.repositories.CandidatRepository;

public class CandidatBusinessJPATest {
	
	@Test
	public void doitCreerUnCandidat() {
		CandidatRepository repos = new CandidatRepositoryList();
		CandidatBusinessJPA business = new CandidatBusinessJPA(repos);
		Candidat candidatACreer = new Candidat("1", "ELMLYH","Basma", "UM5", "Rabat");
		
		Candidat resultat= business.creerCandidat(candidatACreer);
		assertThat(resultat.getNom()).isEqualTo("ELMLYH");
		assertThat(resultat.getNoCandidat()).isEqualTo("1");
	}
	
	@Test
	public void doitRechercherParNom() {
		CandidatRepository repos = new CandidatRepositoryList();
		Candidat candidatACreer = new Candidat("1", "ELMLYH","Basma", "UM5", "Rabat");
		
		List<Candidat> resultat = repos.findByNom("ELMLYH");

		for(Candidat c : resultat )
		{
			assertThat(c.getNom()).isEqualTo("ELMLYH");
			assertThat(c.getNoCandidat()).isEqualTo("1");}
	}
	
	
	@Test
	public void doitRechercherParUniversiteOrigine() {
		CandidatRepository repos = new CandidatRepositoryList();
		Candidat candidatACreer = new Candidat("1", "ELMLYH","Basma", "UM5", "Rabat");
		
		List<Candidat> resultat = repos.findByUniversiteOrigine("UM5");
		
		for(Candidat c : resultat) {
		assertThat(c.getUniversiteOrigine()).isEqualTo("UM5");
		assertThat(c.getNoCandidat()).isEqualTo("1");}
		
	}
	
	
	@Test
	public void doitSupprimerCandidat() {
		CandidatRepository repos = new CandidatRepositoryList();
		CandidatBusinessJPA business = new CandidatBusinessJPA(repos);
		Candidat candidatACreer = new Candidat("1", "ELMLYH","Basma", "UM5", "Rabat");
		Candidat candidatASupprimer= business.creerCandidat(candidatACreer);
		assertThat(repos.count()).isEqualTo(1);

		 business.supprimerCandidat(candidatASupprimer);
		
		assertThat(repos.count()).isEqualTo(0);
		
	}
	
	class CandidatRepositoryList implements CandidatRepository{
		private List<Candidat> data;
		public CandidatRepositoryList() {
			data = new ArrayList<>();
		}
		@Override
		public long count() {
			return this.data.size();
		}
		@Override
		public void delete(String arg0) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void delete(Candidat candidat) {
			data.remove(candidat);
			
		}
		@Override
		public void delete(Iterable<? extends Candidat> arg0) {
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
		public Iterable<Candidat> findAll() {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public Iterable<Candidat> findAll(Iterable<String> arg0) {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public Candidat findOne(String arg0) {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public <S extends Candidat> S save(S entity) {
			data.add(entity);
			return entity;
		}
		@Override
		public <S extends Candidat> Iterable<S> save(Iterable<S> arg0) {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public List<Candidat> findByNom(String nom) {
			List<Candidat> liste = new ArrayList<>();
			
			for(Candidat c : data) {
				if(c.getNom()==nom) {
					liste.add(c);
				}
			}
			return liste;
		}
		@Override
		public List<Candidat> findByUniversiteOrigine(String universiteOrigine) {
			
			List<Candidat> liste = new ArrayList<>();
			
			for(Candidat c : data) {
				if(c.getUniversiteOrigine()==universiteOrigine) {
					liste.add(c);
				}
			}
			return liste;
		}
		
		
	}

}
