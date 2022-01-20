package nounou.jsf.model.mock;

import java.io.Serializable; 
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import nounou.jsf.data.Assistante;
import nounou.jsf.data.Compte;
import nounou.jsf.data.Parent;
import nounou.jsf.data.mapper.IMapper;


@SuppressWarnings("serial")
@ApplicationScoped
public class Donnees implements Serializable {

	
    // Champs 

    private final Map<Integer, Compte>  	mapComptes 		= new HashMap<>();
	private final Map<Integer, Assistante>	mapAssistantes 	= new HashMap<>();
	private final Map<Integer, Parent>	mapParents	= new HashMap<>();

	private int 	dernierIdTelephone;
	
	@Inject
	private IMapper	mapper;

	
	// Getters
	
	public List<Compte> getComptes() {
		List<Compte> comptes = new ArrayList<>();
		for ( Compte compte : mapComptes.values() ) {
			comptes.add( mapper.duplicate( compte ) );
		}
		return comptes;
	}
	
	public List<Parent> getParents() {
		List<Parent> parents = new ArrayList<>();
		for ( Parent parent : mapParents.values() ) {
			parents.add( mapper.duplicate( parent ) );
		}
		return parents;
	}
	
	
	// Constructeur
	
	public Donnees() {
		initialiserDonnees();
	}
	
	
	// Actions
//	
//	public int categorieAjouter( Categorie categorie ) {
//		Integer idMax = Collections.max( mapAssistantes.keySet() );
//		if ( idMax == null ) {
//			idMax = 0;
//		}
//		categorie.setId( idMax + 1 );
//		mapAssistantes.put( categorie.getId(), mapper.duplicate( categorie ) );
//		return categorie.getId();
//	}
//	public void categorieModifier( Categorie categorie ) {
//		mapAssistantes.replace( categorie.getId(), mapper.duplicate( categorie ) );
//	}
//	public void categorieSupprimer( int id ) {
//		mapAssistantes.remove( id );
//	}
//	public Categorie categorieRetrouver( int id ) {
//		return mapper.duplicate( mapAssistantes.get( id ) );
//	}
	
	public int compteAjouter( Compte compte ) {
		Integer idMax = Collections.max( mapComptes.keySet() );
		if ( idMax == null ) {
			idMax = 0;
		}
		compte.setId( idMax + 1 );
		mapComptes.put( compte.getId(), mapper.duplicate( compte ) );
		return compte.getId();
	}
	public void compteModifier( Compte compte ) {
		mapComptes.replace( compte.getId(), mapper.duplicate( compte ) );
	}
	public void compteSupprimer( int id ) {
		mapComptes.remove( id );
	}
	public Compte compteRetrouver( int id ) {
		return mapper.duplicate( mapComptes.get( id ) );
	}
	
//	public int personneAjouter( Parent personne ) {
//		Integer idMax = Collections.max( mapParents.keySet() );
//		if ( idMax == null ) {
//			idMax = 0;
//		}
//		personne.setId( idMax + 1 );
//		affecterIdTelephones(personne);
//		mapParents.put( personne.getId(), mapper.duplicate( personne ) );
//		return personne.getId();
//	}
//	public void personneModifier( Parent personne ) {
//		affecterIdTelephones(personne);
//		mapParents.replace( personne.getId(), mapper.duplicate( personne ) );
//	}
//	public void personneSupprimer( int id ) {
//		mapParents.remove( id );
//	}
//	public Parent personneRetrouver( int id ) {
//		return mapper.duplicate( mapParents.get( id ) );
//	}
	
	// Méthodes auxiliaires

	private void initialiserDonnees() {
		
		
		// Comptes
		
		Compte compte;
		compte = new Compte( 1, "admin@3il.fr", "ADMIN");
		mapComptes.put( compte.getId(), compte );

		compte = new Compte( 2, "parent@3il.fr", "PARENT");
		mapComptes.put( compte.getId(), compte );

    	
		 
	
	}
	
    
//	private void affecterIdTelephones( Parent personne ) {
//		for( Telephone t : personne.getTelephones() ) {
//			if ( t.getId() == 0 ) {
//				t.setId( ++dernierIdTelephone );
//			}
//		}
//	}
	
	
}
