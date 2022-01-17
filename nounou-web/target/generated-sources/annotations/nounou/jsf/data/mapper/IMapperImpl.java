package nounou.jsf.data.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import javax.enterprise.context.ApplicationScoped;
import nounou.commun.dto.DtoCategorie;
import nounou.commun.dto.DtoCompte;
import nounou.commun.dto.DtoEnfant;
import nounou.commun.dto.DtoPersonne;
import nounou.commun.dto.DtoTelephone;
import nounou.jsf.data.Categorie;
import nounou.jsf.data.Compte;
import nounou.jsf.data.Enfant;
import nounou.jsf.data.Parent;
import nounou.jsf.data.Personne;
import nounou.jsf.data.Telephone;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-17T14:52:36+0100",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.3.1300.v20210419-1022, environment: Java 15.0.2 (Oracle Corporation)"
)
@ApplicationScoped
public class IMapperImpl implements IMapper {

    @Override
    public Compte map(DtoCompte source) {
        if ( source == null ) {
            return null;
        }

        Compte compte = new Compte();

        compte.setId( source.getId() );
        compte.setMotDePasse( source.getMotDePasse() );
        compte.setEmail( source.getEmail() );
        compte.setRole( source.getRole() );

        return compte;
    }

    @Override
    public DtoCompte map(Compte source) {
        if ( source == null ) {
            return null;
        }

        DtoCompte dtoCompte = new DtoCompte();

        dtoCompte.setEmail( source.getEmail() );
        if ( source.getId() != null ) {
            dtoCompte.setId( source.getId() );
        }
        dtoCompte.setMotDePasse( source.getMotDePasse() );
        dtoCompte.setRole( source.getRole() );

        return dtoCompte;
    }

    @Override
    public Compte duplicate(Compte source) {
        if ( source == null ) {
            return null;
        }

        Compte compte = new Compte();

        compte.setId( source.getId() );
        compte.setMotDePasse( source.getMotDePasse() );
        compte.setEmail( source.getEmail() );
        compte.setRole( source.getRole() );

        return compte;
    }

    @Override
    public Compte update(Compte target, Compte source) {
        if ( source == null ) {
            return null;
        }

        target.setId( source.getId() );
        target.setMotDePasse( source.getMotDePasse() );
        target.setEmail( source.getEmail() );
        target.setRole( source.getRole() );

        return target;
    }

    @Override
    public Categorie map(DtoCategorie source) {
        if ( source == null ) {
            return null;
        }

        Categorie categorie = new Categorie();

        categorie.setId( source.getId() );
        categorie.setLibelle( source.getLibelle() );

        return categorie;
    }

    @Override
    public DtoCategorie map(Categorie source) {
        if ( source == null ) {
            return null;
        }

        DtoCategorie dtoCategorie = new DtoCategorie();

        if ( source.getId() != null ) {
            dtoCategorie.setId( source.getId() );
        }
        dtoCategorie.setLibelle( source.getLibelle() );

        return dtoCategorie;
    }

    @Override
    public Categorie duplicate(Categorie source) {
        if ( source == null ) {
            return null;
        }

        Categorie categorie = new Categorie();

        categorie.setId( source.getId() );
        categorie.setLibelle( source.getLibelle() );

        return categorie;
    }

    @Override
    public Personne map(DtoPersonne source) {
        if ( source == null ) {
            return null;
        }

        Personne personne = new Personne();

        personne.setId( source.getId() );
        personne.setNom( source.getNom() );
        personne.setPrenom( source.getPrenom() );
        personne.setCategorie( map( source.getCategorie() ) );
        personne.setTelephones( dtoTelephoneListToTelephoneList( source.getTelephones() ) );

        return personne;
    }

    @Override
    public DtoPersonne map(Personne source) {
        if ( source == null ) {
            return null;
        }

        DtoPersonne dtoPersonne = new DtoPersonne();

        dtoPersonne.setCategorie( map( source.getCategorie() ) );
        if ( source.getId() != null ) {
            dtoPersonne.setId( source.getId() );
        }
        dtoPersonne.setNom( source.getNom() );
        dtoPersonne.setPrenom( source.getPrenom() );
        dtoPersonne.setTelephones( telephoneListToDtoTelephoneList( source.getTelephones() ) );

        return dtoPersonne;
    }

    @Override
    public Personne duplicate(Personne source) {
        if ( source == null ) {
            return null;
        }

        Personne personne = new Personne();

        personne.setId( source.getId() );
        personne.setNom( source.getNom() );
        personne.setPrenom( source.getPrenom() );
        personne.setCategorie( duplicate( source.getCategorie() ) );
        personne.setTelephones( duplicate( source.getTelephones() ) );

        return personne;
    }

    @Override
    public Telephone map(DtoTelephone source) {
        if ( source == null ) {
            return null;
        }

        Telephone telephone = new Telephone();

        telephone.setId( source.getId() );
        telephone.setLibelle( source.getLibelle() );
        telephone.setNumero( source.getNumero() );

        return telephone;
    }

    @Override
    public DtoTelephone map(Telephone source) {
        if ( source == null ) {
            return null;
        }

        DtoTelephone dtoTelephone = new DtoTelephone();

        if ( source.getId() != null ) {
            dtoTelephone.setId( source.getId() );
        }
        dtoTelephone.setLibelle( source.getLibelle() );
        dtoTelephone.setNumero( source.getNumero() );

        return dtoTelephone;
    }

    @Override
    public Telephone duplicate(Telephone source) {
        if ( source == null ) {
            return null;
        }

        Telephone telephone = new Telephone();

        telephone.setId( source.getId() );
        telephone.setLibelle( source.getLibelle() );
        telephone.setNumero( source.getNumero() );

        return telephone;
    }

    @Override
    public List<Telephone> duplicate(List<Telephone> source) {
        if ( source == null ) {
            return null;
        }

        List<Telephone> list = new ArrayList<Telephone>( source.size() );
        for ( Telephone telephone : source ) {
            list.add( duplicate( telephone ) );
        }

        return list;
    }

    @Override
    public Enfant map(DtoEnfant dto) {
        if ( dto == null ) {
            return null;
        }

        Enfant enfant = new Enfant();

        enfant.setId( dto.getId() );
        enfant.setNom( dto.getNom() );
        enfant.setPrenom( dto.getPrenom() );
        enfant.setDateDeNaissance( dto.getDateDeNaissance() );

        return enfant;
    }

    @Override
    public DtoEnfant map(Enfant source) {
        if ( source == null ) {
            return null;
        }

        DtoEnfant dtoEnfant = new DtoEnfant();

        dtoEnfant.setDateDeNaissance( source.getDateDeNaissance() );
        if ( source.getId() != null ) {
            dtoEnfant.setId( source.getId() );
        }
        dtoEnfant.setNom( source.getNom() );
        dtoEnfant.setPrenom( source.getPrenom() );

        return dtoEnfant;
    }

    @Override
    public Enfant duplicate(Enfant source) {
        if ( source == null ) {
            return null;
        }

        Enfant enfant = new Enfant();

        enfant.setId( source.getId() );
        enfant.setNom( source.getNom() );
        enfant.setPrenom( source.getPrenom() );
        enfant.setDateDeNaissance( source.getDateDeNaissance() );
        List<Parent> list = source.getParents();
        if ( list != null ) {
            enfant.setParents( new ArrayList<Parent>( list ) );
        }

        return enfant;
    }

    protected List<Telephone> dtoTelephoneListToTelephoneList(List<DtoTelephone> list) {
        if ( list == null ) {
            return null;
        }

        List<Telephone> list1 = new ArrayList<Telephone>( list.size() );
        for ( DtoTelephone dtoTelephone : list ) {
            list1.add( map( dtoTelephone ) );
        }

        return list1;
    }

    protected List<DtoTelephone> telephoneListToDtoTelephoneList(List<Telephone> list) {
        if ( list == null ) {
            return null;
        }

        List<DtoTelephone> list1 = new ArrayList<DtoTelephone>( list.size() );
        for ( Telephone telephone : list ) {
            list1.add( map( telephone ) );
        }

        return list1;
    }
}
