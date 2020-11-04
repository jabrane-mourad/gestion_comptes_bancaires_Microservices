package xj.gcb.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/*
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type", discriminatorType=DiscriminatorType.STRING, length=2)

@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class)
@JsonSubTypes({
        @JsonSubTypes.Type(name="CC", value=CompteCourant.class),
        @JsonSubTypes.Type(name="CE", value=CompteEpargne.class)})
*/
@Data
@NoArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type")
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class)
@JsonSubTypes({
        @JsonSubTypes.Type(name="CompteCourant", value=CompteCourant.class),
        @JsonSubTypes.Type(name="CompteEpargne", value=CompteEpargne.class)})
public abstract class Compte{
    @Id
    private String codeCompte;
    private Date dateCreation;
    private double solde;

    public abstract Type getType();

    public enum Type {CompteCourant, CompteEpargne}


    public Compte(String codeCompte, Date dateCreation, double solde) {
        this.codeCompte=codeCompte;
        this.dateCreation=dateCreation;
        this.solde=solde;
    }
}
