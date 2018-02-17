package fr.univbrest.dosi.business;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.Test;

import fr.univbrest.dosi.bean.Enseignant;
import fr.univbrest.dosi.repositories.EnseignantRepository;

public class EnseigantBusinessJPATest {
	
	
	@Test
	public void doitCreerUnEnseignant() {
		EnseignantRepository repos = new EnseignantRepositoryList();
		EnseignantBusinessJPA business = new EnseignantBusinessJPA(repos);
		Enseignant EnseignantACreer = new Enseignant(7,"basma.elmlyh@univ-brest.fr", "ELMLYH","Basma", "Rabat");
		
		Enseignant resultat= business.creerEnseignant(EnseignantACreer);
		Long temp= repos.count();	
		 assertThat(temp).isEqualTo(1);
	}
	
	@Test
	public void doitSupprimerEnseignant() {
		EnseignantRepository repos = new EnseignantRepositoryList();
		EnseignantBusinessJPA business = new EnseignantBusinessJPA(repos);
		Enseignant EnseignantACreer = new Enseignant(7,"basma.elmlyh@univ-brest.fr", "ELMLYH","Basma", "Rabat");
		Enseignant EnseignantASupprimer= business.creerEnseignant(EnseignantACreer);
		assertThat(repos.count()).isEqualTo(1);

		boolean resultat = business.supprimerEnseignantByID(EnseignantASupprimer.getNoEnseignant());
		
		assertThat(resultat).isEqualTo(true);
		
	}
	
	@Test
	public void doitRechercherParNom() {
		EnseignantRepository repos = new EnseignantRepositoryList();
		Enseignant EnseignantACreer = new Enseignant(7,"basma.elmlyh@univ-brest.fr", "ELMLYH","Basma", "Rabat");
		EnseignantBusinessJPA business = new EnseignantBusinessJPA(repos);
		business.creerEnseignant(EnseignantACreer);
		List<Enseignant> resultat = repos.findByNom("ELMLYH");

		assertThat(resultat).hasSize(1);
		/*for(Enseignant c : resultat )
		{
			assertThat(c.getNom()).isEqualTo("ELMLYH");
			assertThat(c.getNoEnseignant()).isEqualTo("1");}*/
	}
	
	
	@Test
	public void doitRechercherParEmail() {
		EnseignantRepository repos = new EnseignantRepositoryList();
		Enseignant EnseignantACreer = new Enseignant(7,"basma.elmlyh@univ-brest.fr", "ELMLYH","Basma", "Rabat");
		EnseignantBusinessJPA business = new EnseignantBusinessJPA(repos);
		business.creerEnseignant(EnseignantACreer);
		
		List<Enseignant> resultat = (List<Enseignant>) repos.findByEmailUbo("basma.elmlyh@univ-brest.fr");
		
		assertThat(resultat).hasSize(1);
		/*for(Enseignant c : resultat) {
		assertThat(c.getEmailUbo()).isEqualTo("basma.elmlyh@univ-brest.fr");
		
		}*/
	}
	
	
	class EnseignantRepositoryList implements EnseignantRepository{
		private List<Enseignant> data;
		
		public EnseignantRepositoryList() {
			data = Lists.newArrayList();
		}
		
		@Override
		public long count() {
			return data.size();		}
		@Override
		public void delete(Long arg0) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void delete(Enseignant entity) {
			data.remove(entity);
			
		}
		@Override
		public void delete(Iterable<? extends Enseignant> arg0) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void deleteAll() {
			// TODO Auto-generated method stub
			
		}
		@Override
		public boolean exists(Long arg0) {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public Iterable<Enseignant> findAll() {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public Iterable<Enseignant> findAll(Iterable<Long> arg0) {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public Enseignant findOne(Long arg0) {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public <S extends Enseignant> S save(S entity) {
			data.add(entity);
			return entity;
		}
		@Override
		public <S extends Enseignant> Iterable<S> save(Iterable<S> arg0) {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public List<Enseignant> findByNom(String nom) {
			for (int i = 0; i < data.size(); i++) {
				if(data.get(i).getNom() == nom) {
					List<Enseignant> data2 = Lists.newArrayList();
					data2.add(data.get(i));
					return data2;
				}
			}
			
			return null;
		}
		@Override
		public List<Enseignant> findByEmailUbo(String mail) {
			for (int i = 0; i < data.size(); i++) {
				if(data.get(i).getEmailUbo() == mail) {
					List<Enseignant> data3 = Lists.newArrayList();
					data3.add(data.get(i));
					return data3;
				}
			}
			
			return null;
		}
		}
		

	}
