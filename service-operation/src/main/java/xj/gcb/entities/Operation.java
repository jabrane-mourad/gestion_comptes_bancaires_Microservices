package xj.gcb.entities;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type")
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type", discriminatorType= DiscriminatorType.STRING)
//@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class)
@JsonSubTypes({
        @JsonSubTypes.Type(name="Retrait", value=Retrait.class),
        @JsonSubTypes.Type(name="Versement", value=Versement.class)})
public abstract class Operation {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long numero;
    private Date date;
    private double nomtant;
    public enum Type {Retrait, Versement;}

    public abstract Type getType();

    public Operation(Long numero, Date date, double nomtant) {
        this.numero = numero;
        this.date = date;
        this.nomtant = nomtant;

    }
    /*
    *     @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long numero;
    private Date date;
    private double nomtant;
    @JsonIgnore
    @ManyToOne(cascade={CascadeType.REMOVE})
    @JoinColumn(name="codeCompte")
    private Compte compte;*/
}
