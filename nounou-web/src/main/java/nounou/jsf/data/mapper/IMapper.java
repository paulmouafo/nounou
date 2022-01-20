package nounou.jsf.data.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import nounou.commun.dto.DtoCategorie;
import nounou.commun.dto.DtoCompte;
import nounou.commun.dto.DtoGarde;
import nounou.commun.dto.DtoParent;
import nounou.commun.dto.DtoPersonne;
import nounou.commun.dto.DtoTelephone;
import nounou.jsf.data.Categorie;
import nounou.jsf.data.Compte;
import nounou.jsf.data.Garde;
import nounou.jsf.data.Parent;
import nounou.jsf.data.Personne;
import nounou.jsf.data.Telephone;


@Mapper( componentModel = "cdi" )
public interface IMapper {
  

	// Compte
	
	Compte    map( DtoCompte source );
	
	DtoCompte map( Compte source );
	
	Compte duplicate( Compte source );

	Compte update( @MappingTarget Compte target, Compte source );
	
	
	// Garde
	
	Garde map(DtoGarde dto);
	
	DtoGarde map(Garde courant);
	

	// Categorie
	
	Categorie    map( DtoCategorie source );
	
	DtoCategorie map( Categorie source );
	
	Categorie duplicate( Categorie source );

	
	// Personne
	
	Personne    map( DtoPersonne source );
	
	DtoPersonne map( Personne source );
	
    Personne duplicate( Personne source );

	
	// Telephone
	
	Telephone    map( DtoTelephone source );
	
	DtoTelephone map( Telephone source );

    // Méthodes nécessaire pour update( Personne )

	Telephone duplicate( Telephone source );

	List<Telephone> duplicate( List<Telephone> source );

	Parent map(DtoParent dto);

	DtoParent map(Parent courant);



}
