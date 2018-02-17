package fr.univbrest.dosi.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.univbrest.dosi.bean.Enseignant;
import fr.univbrest.dosi.repositories.EnseignantRepository;

@Service
public class EnseignantBusinessJPA implements EnseignantBusiness {

	private EnseignantRepository enseignantrepos;
	
	@Autowired 
	public EnseignantBusinessJPA( EnseignantRepository enseignantrepos) {
		this.enseignantrepos = enseignantrepos;
	}

	@Override
	public Enseignant creerEnseignant(Enseignant enseignantACreer) {
		return enseignantrepos.save(enseignantACreer);
	}

	@Override
	public boolean supprimerEnseignantByID(long id) {
		enseignantrepos.delete(id);;
		return true;
	}

	@Override
	public List<Enseignant> recupererToutEnseignants() {
		return (List<Enseignant>) enseignantrepos.findAll();	}


	@Override
	public Enseignant recupererEnseignantByID(long numero) {
		return enseignantrepos.findOne(numero);
	}

	@Override
	public List<Enseignant> recupererEnseignantByNom(String nom) {
		return enseignantrepos.findByNom(nom);
	}

	@Override
	public List<Enseignant> recupererEnseignantByEmail(String mail) {
		return enseignantrepos.findByEmailUbo(mail);
	}

	
	
}
