package xj.gcb.entities;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/*

//@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class)

*/
@Data
@NoArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type")
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
//@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class)
@JsonSubTypes({
        @JsonSubTypes.Type(name = "CompteCourant", value = CompteCourant.class),
        @JsonSubTypes.Type(name = "CompteEpargne", value = CompteEpargne.class)})
public abstract class Compte {
    @Id
    private String codeCompte;
    private Date dateCreation;
    private double solde;

    public Compte(String codeCompte, Date dateCreation, double solde) {
        this.codeCompte = codeCompte;
        this.dateCreation = dateCreation;
        this.solde = solde;
    }

    public abstract Type getType();

    public enum Type {CompteCourant, CompteEpargne;}
}
