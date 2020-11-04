package xj.gcb.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;

/*@Entity
@DiscriminatorValue(value="CC")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class)
@Data
@ToString*/
@Data
@NoArgsConstructor

@Entity
public class CompteCourant extends Compte{
    private double decouvert;


    public CompteCourant(String codeCompte, Date dateCreation, double solde, double decouvert) {
        super(codeCompte, dateCreation, solde);
        this.decouvert = decouvert;
    }
    @Override
    public Type getType() {
        return Type.CompteCourant;
    }

}
