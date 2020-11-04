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
@DiscriminatorValue(value="CE")
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class)
@Data
@ToString*/
@Data
@NoArgsConstructor

@Entity
public class CompteEpargne extends Compte{
    private double taux;



    public CompteEpargne(String codeCompte, Date dateCreation, double solde, double taux) {
        super(codeCompte, dateCreation, solde);
        this.taux = taux;
    }
    @Override
    public Type getType() {
        return Type.CompteEpargne;
    }
}
