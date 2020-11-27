package xj.gcb.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.Date;

/*@Entity
@DiscriminatorValue(value="CE")
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class)
@Data
@ToString*/
@Data
@NoArgsConstructor

@Entity
public class CompteEpargne extends Compte {
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
