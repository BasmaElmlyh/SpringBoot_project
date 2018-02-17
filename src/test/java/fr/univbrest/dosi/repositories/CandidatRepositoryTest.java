package fr.univbrest.dosi.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.univbrest.dosi.AppTestConfig;
import fr.univbrest.dosi.bean.Candidat;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AppTestConfig.class)
public class CandidatRepositoryTest {
	
	@Autowired
	CandidatRepository candidatrepo;
	
	@Before
	public void setup() {
		Candidat candidat1 = new Candidat("1","ELMLYH","Basma","UM5","Rabat");
		Candidat candidat2 = new Candidat("2","ELMOUST","Oumaima","FSSM","Marrakech");
		
		candidatrepo.save(candidat1);
		candidatrepo.save(candidat2);
	}
	
	@Test
	public void doitRechercherParNom() {
		List<Candidat> resultat = candidatrepo.findByNom("ELMLYH");
		assertThat(resultat).hasSize(1);
		assertThat(resultat.get(0).getNom()).isEqualTo("ELMLYH");
		assertThat(resultat.get(0).getNoCandidat()).isEqualTo("1");
	}

	@Test
	public void doitRechercherParUniversiteOrigine() {
		List<Candidat> resultat = candidatrepo.findByUniversiteOrigine("FSSM");
		assertThat(resultat).hasSize(1);
		assertThat(resultat.get(0).getUniversiteOrigine()).isEqualTo("FSSM");
		assertThat(resultat.get(0).getNoCandidat()).isEqualTo("2");

	}
	
}
