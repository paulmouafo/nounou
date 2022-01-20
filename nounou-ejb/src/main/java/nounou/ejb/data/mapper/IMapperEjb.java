package nounou.ejb.data.mapper;

import org.mapstruct.Mapper; 
import org.mapstruct.factory.Mappers;

import nounou.commun.dto.DtoAssistante;
import nounou.commun.dto.DtoCompte;
import nounou.commun.dto.DtoContrat;
import nounou.commun.dto.DtoGarde;
import nounou.commun.dto.DtoParent;
import nounou.ejb.data.Assistante;
import nounou.ejb.data.Compte;
import nounou.ejb.data.Contrat;
import nounou.ejb.data.Garde;
import nounou.ejb.data.Parent;

 
// @Mapper( componentModel = "cdi" )
public interface IMapperEjb {  
	
	static final IMapperEjb INSTANCE = Mappers.getMapper( IMapperEjb.class );
	
	
	// Compte
	Compte map( DtoCompte source );
	DtoCompte map( Compte source );
	
	// Parent
	Parent map( DtoParent source );
	DtoParent map( Parent source );

    // Garde 
	Garde map(DtoGarde dtoGarde);
	DtoGarde mapMinimal(Garde garde);
	DtoGarde map(Garde garde);

	// Parent
	DtoParent mapMinimal(Parent parent);	
	Assistante map(DtoAssistante dtoAssistante);

	// Assistante
	DtoAssistante map(Assistante assistante);
	DtoAssistante mapMinimal(Assistante assistante);

	// Contrat
	Contrat map(DtoContrat dtoContrat);
	DtoContrat map(Contrat contrat);
	DtoContrat mapMinimal(Contrat contrat);
	
	
}
