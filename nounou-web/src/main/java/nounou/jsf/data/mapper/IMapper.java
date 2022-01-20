package nounou.jsf.data.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import nounou.commun.dto.DtoAssistante;
import nounou.commun.dto.DtoCompte;
import nounou.commun.dto.DtoContrat;
import nounou.commun.dto.DtoGarde;
import nounou.commun.dto.DtoParent;
import nounou.jsf.data.Assistante;
import nounou.jsf.data.Compte;
import nounou.jsf.data.Contrat;
import nounou.jsf.data.Garde;
import nounou.jsf.data.Parent;;


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

	// Assistante
	Assistante map(DtoAssistante dto);
	DtoAssistante map(Assistante courant);

	// Parent
	Parent map(DtoParent dto);
	DtoParent map(Parent courant);
	Parent duplicate( Parent source );

	// Contrat
	Contrat map(DtoContrat dto);
	DtoContrat map(Contrat courant);
	
}
